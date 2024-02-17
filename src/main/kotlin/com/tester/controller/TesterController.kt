package com.tester.controller

import com.tester.model.TesterModel
import com.tester.service.TesterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TesterController {

    @Autowired
    var service = TesterService()

    @PostMapping("/test")
    fun testStuff(@RequestBody event: TesterModel) : TesterModel {
        return service.dataValidation(event)
    }

}