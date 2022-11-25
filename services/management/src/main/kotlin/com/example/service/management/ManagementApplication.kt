package com.example.service.management

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.example"])
class ManagementApplication {

    fun main(args: Array<String>) {
        runApplication<ManagementApplication>(*args)
    }
}