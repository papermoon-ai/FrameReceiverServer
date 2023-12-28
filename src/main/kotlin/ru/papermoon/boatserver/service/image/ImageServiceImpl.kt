package ru.papermoon.boatserver.service.image

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import ru.papermoon.boatserver.data.image.ImageRepository
import java.util.*

@Service
class ImageServiceImpl(
    private val imageRepository: ImageRepository
) : ImageService {

    override fun uploadImage(sessionId: UUID, image: MultipartFile): Boolean {
        return imageRepository.saveFile(sessionId, image)
    }
}