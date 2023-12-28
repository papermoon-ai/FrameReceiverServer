package ru.papermoon.boatserver.data.session

import java.util.*

interface SessionRepository {
    fun createSessionFolder(sessionId: UUID): Boolean
    fun finishSession(sessionId: UUID): Boolean
}
