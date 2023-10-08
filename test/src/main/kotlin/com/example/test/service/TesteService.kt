package com.example.test.service


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.springframework.stereotype.Service

@Service
class TesteService {

    fun jsonMapper(event: String): String {
        val gson = Gson()
        val mapAdapter = gson.getAdapter(object: TypeToken<Map<String, Any?>>() {})
        val model: Map<String, Any?> = mapAdapter.fromJson(event)

        return model.getValue("nome").toString()
    }
}
