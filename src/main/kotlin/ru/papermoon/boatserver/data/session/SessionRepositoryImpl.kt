package ru.papermoon.boatserver.data.session

import org.springframework.stereotype.Repository
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

@Repository
class SessionRepositoryImpl: SessionRepository {

    companion object {
        private const val ROOT_DIR = "sessions"
        private const val RATE = "10"
    }

    override fun createSessionFolder(sessionId: UUID): Boolean {
        val dir = File("./$ROOT_DIR")
        if (!dir.exists()) {
            dir.mkdirs()
        }
        Files.createDirectory(Paths.get("./$ROOT_DIR/$sessionId"))
        return true
    }

    override fun finishSession(sessionId: UUID): Boolean {
        convertToVideo(sessionId)
        return true
    }

    private fun convertToVideo(sessionId: UUID) {
        val processBuilder = ProcessBuilder(
            "ffmpeg",
            "-y",
            "-framerate", RATE,
            "-hide_banner", "-loglevel", "error",
            "-pattern_type", "sequence",
            "-i", "./sessions/$sessionId/%04d.jpg",
            "-c:v", "libx264",
            "-pix_fmt", "yuv420p",
            "./sessions/$sessionId/out.mp4"
        )

        processBuilder.redirectErrorStream(false)
        val process = processBuilder.start()
        process.waitFor()

        clearDir(sessionId)
    }

    private fun clearDir(sessionId: UUID) {
        val dir = File("./$ROOT_DIR/${sessionId}")
        if (!dir.exists()) {
            return
        }
        for (f in dir.listFiles()!!) {
            if (f.getName().endsWith(".jpg")) {
                f.delete()
            }
        }
    }
}
