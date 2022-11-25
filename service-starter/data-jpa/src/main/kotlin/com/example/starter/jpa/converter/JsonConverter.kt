package com.example.starter.jpa.converter

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class JsonConverter<T> : AttributeConverter<T, String?> {

    override fun convertToDatabaseColumn(attribute: T?): String? {
        try {
            return if (attribute == null) null else  ObjectMapper().writeValueAsString(attribute)
        } catch (ex: Exception) {
            throw IllegalArgumentException(ex.message)
        }
    }

    override fun convertToEntityAttribute(dbData: String?): T? {
        try {
            if(dbData.isNullOrEmpty())
                return null

            return ObjectMapper().readValue(dbData, object : TypeReference<T>() {})
        } catch (ex: Exception) {
            throw IllegalArgumentException(ex.message)
        }
    }
}