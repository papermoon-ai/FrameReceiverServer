package ru.papermoon.boatserver.service.session

import java.util.UUID

interface SessionService {
    fun initializeSession(): UUID
    fun finishSession(sessionId: UUID)
}
