package com.okmichaels.aufbauchecker;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.okmichaels.aufbauchecker.model.Grade;

import java.lang.reflect.Type;

public class GradeDeserializer implements JsonDeserializer<Grade>
{
    public Grade deserialize(JsonElement element, Type type, JsonDeserializationContext
            context) throws android.net.ParseException {
        //get "grade" element from parsed json
        JsonElement grade = element.getAsJsonObject().get("grades");
        //deserialize, use a new Gson instance to avoid infinite recursion to this
        //deserializer
        return new Gson().fromJson(grade, type);
    }
}