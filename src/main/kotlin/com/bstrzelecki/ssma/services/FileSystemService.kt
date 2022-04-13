package com.bstrzelecki.ssma.services

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.time.Instant
import java.util.*

@Service
class FileSystemService: ImageStorageService {

    val path = "./imgs"

    override fun save(file:MultipartFile) :String{
        val uploadPath = Paths.get(path)
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath)
        }
        val inputStream = file.inputStream
        val uuid = UUID.randomUUID()
        val timeStamp = Instant.now().toString()

        val imageId = uuid.toString() +"_"+ timeStamp;
        val filePath = uploadPath.resolve(imageId + "_img.png")
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)

        return imageId;
    }

    override fun getAll(): java.util.stream.Stream<Path> {
        TODO("Not yet implemented")
    }

    override fun clear() {
        Files.delete(Paths.get(path))
    }

}