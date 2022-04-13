package com.bstrzelecki.ssma.controllers

import com.bstrzelecki.ssma.entities.Image
import com.bstrzelecki.ssma.entities.UserEntry
import com.bstrzelecki.ssma.repositories.ImageRepository
import com.bstrzelecki.ssma.repositories.UserRepository
import com.bstrzelecki.ssma.services.FileSystemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.InputStreamResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths


@Controller
class ContentController(@Autowired val fileSystem: FileSystemService, @Autowired val imgs: ImageRepository, val users: UserRepository) {


    @PostMapping("/send/image")
    fun image(@RequestParam("image") multipartFile:MultipartFile, @RequestParam("title") title:String, @RequestParam("desc") desc:String, @AuthenticationPrincipal principal:OAuth2User): String{
        val id = fileSystem.save(multipartFile)

        val userId = principal.getAttribute<Int?>("id") ?: 0
        var user = users.findAll().firstOrNull{it.id == userId}
        if(user == null){
            user = UserEntry(userId, principal.getAttribute<String>("name") ?: "anonymous")
            users.save(user)
        }

        val img = Image(id, user, title, desc)
        imgs.save(img)

        return "redirect:/"
    }
    @GetMapping("/get/image")
    fun getImage(@RequestParam id:String): ResponseEntity<InputStreamResource>{
        val file = Files.newInputStream(Paths.get("./imgs").resolve(id + "_img.png"))
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(InputStreamResource(file))
    }


}