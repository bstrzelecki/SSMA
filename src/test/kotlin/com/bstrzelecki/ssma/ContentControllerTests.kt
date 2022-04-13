package com.bstrzelecki.ssma
import com.bstrzelecki.ssma.controllers.ContentController
import com.bstrzelecki.ssma.entities.Image
import com.bstrzelecki.ssma.entities.UserEntry
import com.bstrzelecki.ssma.repositories.ImageRepository
import com.bstrzelecki.ssma.repositories.UserRepository
import com.bstrzelecki.ssma.services.FileSystemService
import io.mockk.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.multipart.MultipartFile

class ContentControllerTests {
    val fileSystemService: FileSystemService = mockk()
    val imgs: ImageRepository = mockk()
    val users: UserRepository = mockk()
    @Test
    fun imageSaveTest(){
        val contentController = ContentController(fileSystemService, imgs, users)
        val file:MultipartFile = mockk()
        val userAuth:OAuth2User = mockk()
        val user: UserEntry = mockk()

        every{userAuth.getAttribute<Int>("id")} returns 1
        every{user.id} returns 1
        every{fileSystemService.save(file)} returns "UUID"
        every { users.findAll() } returns listOf(user)

        val img = Image("UUID", user, "title", "desc")
        every { imgs.save(img) } returns img


        val result = contentController.image(file,"title", "desc", userAuth)
        Assertions.assertEquals(result, "redirect:/")

        verify(exactly = 1) { fileSystemService.save(file) }
        verify(exactly = 1) { imgs.save(img) }


        confirmVerified(fileSystemService)
    }

}