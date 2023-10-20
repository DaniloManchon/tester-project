package com.example.test.service


import com.example.test.model.TestModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.springframework.stereotype.Service

@Service
class TesteService {

    fun jsonMapper(event: String): MutableMap<String, Any?> {
        val mapAdapter = Gson().getAdapter(object: TypeToken<MutableMap<String, Any?>>() {})
        val mappedEvent: MutableMap<String, Any?> = mapAdapter.fromJson(event)
        return mappedEvent
    }

    fun jsonFilter(mappedEvent:  MutableMap<String, Any?>): MutableMap<String, Any?> {
        mappedEvent.remove("nome")
        mappedEvent.remove("idade")
        return mappedEvent
    }

    fun mapperToObject(mappedEvent:  MutableMap<String, Any?>): TestModel{
        return TestModel(
            mappedEvent.getValue("nome").toString(),
            Integer.parseInt(mappedEvent.getValue("idade").toString()),
                jsonFilter(mappedEvent)
        )
    }

   fun dataValidation(event: String): TestModel {
       val dataMapeadaFull = jsonMapper(event)
       val objetoMapeado = mapperToObject(dataMapeadaFull)

       if(objetoMapeado.idade >= 18){
           objetoMapeado.nome = "Danilo"
       }

       return objetoMapeado
   }

}
