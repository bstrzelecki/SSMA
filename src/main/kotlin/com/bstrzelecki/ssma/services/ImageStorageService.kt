package com.bstrzelecki.ssma.services

import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path

interface ImageStorageService {
    fun save(file: MultipartFile) :String
    fun getAll(): java.util.stream.Stream<Path>
    fun clear()
}
