package com.bstrzelecki.ssma.repositories;

import com.bstrzelecki.ssma.entities.Image
import org.springframework.data.jpa.repository.JpaRepository

interface ImageRepository : JpaRepository<Image, String> {
    fun findAllByTitleOrderByTitle(title: String):Collection<Image>
}