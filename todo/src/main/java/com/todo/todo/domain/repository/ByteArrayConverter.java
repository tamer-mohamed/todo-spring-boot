package com.todo.todo.domain.repository;

import javax.persistence.AttributeConverter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ByteArrayConverter implements AttributeConverter<String, byte[]> {
    private Charset charset = StandardCharsets.UTF_8;

    @Override
    public byte[] convertToDatabaseColumn(String attribute) {
        return attribute.getBytes(charset);
    }

    @Override
    public String convertToEntityAttribute(byte[] dbData) {
        if (dbData == null) {
            return null;
        }
        return new String(dbData, charset);
    }
}