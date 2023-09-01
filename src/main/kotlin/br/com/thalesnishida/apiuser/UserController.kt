package br.com.thalesnishida.apiuser

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/users")
class UserController(private val repository: UserRepository) {

    @PostMapping
    fun create(@RequestBody user: User): User = repository.save(user)

    @GetMapping
    fun getAll(): List<User> = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) : ResponseEntity<User> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody user: User) : ResponseEntity<User> =
        repository.findById(id).map {
            val userUpdate = it.copy(
                name = user.name,
                email = user.email,
                password = user.password
            )
            ResponseEntity.ok(repository.save(userUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}
