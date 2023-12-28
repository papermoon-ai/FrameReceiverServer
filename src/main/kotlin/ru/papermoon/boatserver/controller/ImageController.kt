package ru.papermoon.boatserver.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import ru.papermoon.boatserver.service.image.ImageService
import java.util.*

@RestController
@RequestMapping("/api/image")
class ImageController(
    private val imageService: ImageService
) {

    @PostMapping("/upload")
    fun uploadImage(sessionId: UUID, @RequestParam("image") image: MultipartFile): Boolean {
        return imageService.uploadImage(sessionId, image)
    }
}
