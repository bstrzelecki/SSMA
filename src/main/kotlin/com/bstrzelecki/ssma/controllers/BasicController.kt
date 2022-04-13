package com.bstrzelecki.ssma.controllers

import com.bstrzelecki.ssma.repositories.ImageRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BasicController(val imgs: ImageRepository) {

    @GetMapping("/")
    fun start(model: Model):String{
        val img = imgs.findAll()
        if(img.isEmpty()){
            model.addAttribute("display", "empty")
            return "index"
        }
        model.addAttribute("images", img.map { ImagePost(it.id, it.title, it.desc, it.user?.name?:"none") })
        return "index"
    }
    @GetMapping("/hello")
    fun hello():String{
        return "hello"
    }

    @GetMapping("/user/login")
    fun login() :String{
        return "login"
    }
}

