package com.bstrzelecki.ssma.controllers

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/user")
class UserController {
    @GetMapping("status")
    fun user(@AuthenticationPrincipal principal: OAuth2User):Map<String, Any>{
        return principal.attributes
    }
}