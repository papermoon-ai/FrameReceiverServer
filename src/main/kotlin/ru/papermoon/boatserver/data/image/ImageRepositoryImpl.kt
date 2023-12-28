package ru.papermoon.boatserver.data.image

import org.springframework.stereotype.Repository
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

@Repository
class ImageRepositoryImpl: ImageRepository {

    companion object {
        private const val ROOT_DIR = "sessions"
    }

    override fun saveFile(sessionId: UUID, file: MultipartFile): Boolean {
        val dirPath = Paths.get("./$ROOT_DIR/$sessionId")
        val fileNames = StringBuilder()
        val fileNameAndPath = Paths.get(dirPath.toString(), file.originalFilename)
        fileNames.append(file.originalFilename)
        Files.write(fileNameAndPath, file.bytes)
        return true
    }
}
