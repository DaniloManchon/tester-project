package com.example.test.model

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter

@Getter
@Setter
@AllArgsConstructor
class TestModel (
    var nome: String,
    var idade: Int
){
    @JsonIgnore
    var mappedPayload: MutableMap<String, Any?> = LinkedHashMap()

    @JsonAnySetter
    fun setMappedPayload(k: String, v: Any?) {
        this.mappedPayload.put(k, v);
    }

    @JsonAnyGetter
    fun mergeMappedPayloadIntoModel() : MutableMap<String, Any?> {
        return this.mappedPayload;
    }
}
