package ru.papermoon.boatserver.service.image

import org.springframework.web.multipart.MultipartFile
import java.util.*

interface ImageService {
    fun uploadImage(sessionId: UUID, image: MultipartFile): Boolean
}
