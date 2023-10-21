package com.example.test.service


import com.example.test.model.TestModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.springframework.stereotype.Service

@Service
class TesteService {
   fun dataValidation(event: TestModel): TestModel {
       if(event.idade >= 18){
           event.nome = "Danilo"
       }
       return event
   }
}
