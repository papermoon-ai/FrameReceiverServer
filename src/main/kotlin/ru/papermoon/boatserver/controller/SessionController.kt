package ru.papermoon.boatserver.controller

import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.papermoon.boatserver.service.session.SessionService
import java.util.*

@RestController
@RequestMapping("/api/session")
class SessionController(
    private val sessionService: SessionService
) {

    @PostMapping("/initialize")
    fun initializeSession(): UUID {
        return sessionService.initializeSession()
    }

    @PatchMapping("/finish")
    fun initializeSession(sessionId: UUID) {
        return sessionService.finishSession(sessionId)
    }
}
