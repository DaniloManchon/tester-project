package com.example.test.controller


import com.example.test.service.TesteService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @Autowired
    var service = TesteService()

    @PostMapping("/test")
    fun testStuff(@RequestBody event: String) : String? {
       return service.dataValidation(event)
    }

}