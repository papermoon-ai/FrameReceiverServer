package ru.papermoon.boatserver.service.session

import org.springframework.stereotype.Service
import ru.papermoon.boatserver.data.session.SessionRepository
import java.util.*

@Service
class SessionServiceImpl(
    private val sessionRepository: SessionRepository
): SessionService {
    override fun initializeSession(): UUID {
        val sessionId = UUID.randomUUID()
        sessionRepository.createSessionFolder(sessionId)
        return sessionId
    }

    override fun finishSession(sessionId: UUID) {
        sessionRepository.finishSession(sessionId)
    }
}
