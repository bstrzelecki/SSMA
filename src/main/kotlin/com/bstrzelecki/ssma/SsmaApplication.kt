package com.bstrzelecki.ssma

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication(scanBasePackages =["com.bstrzelecki.ssma"])
class SsmaApplication

    fun main(args: Array<String>) {
        runApplication<SsmaApplication>(*args)
    }

