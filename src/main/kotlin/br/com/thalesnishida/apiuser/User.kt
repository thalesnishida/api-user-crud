package br.com.thalesnishida.apiuser

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "users")
data class User(
    @Id @GeneratedValue
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String
)