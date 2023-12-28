package ru.papermoon.boatserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BoatServerApplication

fun main(args: Array<String>) {
    runApplication<BoatServerApplication>(*args)
}
