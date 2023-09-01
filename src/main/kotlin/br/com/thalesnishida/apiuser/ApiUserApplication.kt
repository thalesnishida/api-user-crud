package br.com.thalesnishida.apiuser

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiUserApplication

fun main(args: Array<String>) {
	runApplication<ApiUserApplication>(*args)
}
