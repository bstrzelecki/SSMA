package com.bstrzelecki.ssma

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.HttpStatusEntryPoint

@SpringBootApplication
class SsmaSecurity : WebSecurityConfigurerAdapter() {
    override fun configure(http :HttpSecurity){
        http.cors().and().csrf().disable()
        http.authorizeRequests(){
            it.antMatchers("/", "/user/login", "/send/image", "/hello", "/user/status", "/get/image").permitAll().anyRequest().authenticated()
        }.exceptionHandling(){
            it.authenticationEntryPoint(HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
        }.oauth2Login()
    }
}