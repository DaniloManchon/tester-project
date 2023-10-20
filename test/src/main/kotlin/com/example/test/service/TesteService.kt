package com.example.test.service


import com.example.test.model.TestModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import org.springframework.stereotype.Service

@Service
class TesteService {

    fun jsonMapper(event: String): Map<String, Any?> {
        val mapAdapter = Gson().getAdapter(object: TypeToken<Map<String, Any?>>() {})
        val mappedEvent: Map<String, Any?> = mapAdapter.fromJson(event)
        return mappedEvent
    }

    fun jsonFilter(mappedEvent:  Map<String, Any?>): MutableMap<String, Any?> {
        val map = mappedEvent.toMutableMap()
        map.remove("nome")
        map.remove("idade")
        return map
    }

    fun mapperToObject(mappedEvent:  Map<String, Any?>): TestModel{
        return TestModel(
            mappedEvent.getValue("nome").toString(),
            Integer.parseInt(mappedEvent.getValue("idade").toString())
        )
    }

   fun dataValidation(event: String): String? {
       val dataMapeadaFull = jsonMapper(event)
       val objetoMapeado = mapperToObject(dataMapeadaFull)
       val dataMapeadaHalf = jsonFilter(dataMapeadaFull)
        println(dataMapeadaHalf)

       if(objetoMapeado.idade >= 18){
           objetoMapeado.nome = "Danilo"
       }
       //todo corrigir esse bug
       val halfDataJson = Gson().toJson(dataMapeadaHalf)
       val objetoMapeadoJson = Gson().toJson(objetoMapeado)
       val somaData = Gson().toJson(halfDataJson + objetoMapeadoJson)
       return somaData
   }

}
