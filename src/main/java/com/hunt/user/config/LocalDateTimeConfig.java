package com.hunt.user.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeConfig extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime v, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeNumber(v.toLocalDate() + " " + v.toLocalTime());
    }
}