package com.tester.service

import com.tester.model.TesterModel
import org.springframework.stereotype.Service

@Service
class TesterService {
    fun dataValidation(event: TesterModel): TesterModel {
        if(event.idade >= 18){
            event.maiorDeIdade = true
        }
        return event
    }
}