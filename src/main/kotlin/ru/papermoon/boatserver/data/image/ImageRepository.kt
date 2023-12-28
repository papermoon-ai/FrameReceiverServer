package ru.papermoon.boatserver.data.image

import org.springframework.web.multipart.MultipartFile
import java.util.*

interface ImageRepository {
    fun saveFile(sessionId: UUID, file: MultipartFile): Boolean
}
