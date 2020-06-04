package com;

import com.google.gson.Gson;

public class Functions {
    static Gson gson = new Gson();

    public String serialization(Person person) {
        return gson.toJson(person);
    }

    public Person deserialization(String serializedPerson) {
        return gson.fromJson(serializedPerson, Person.class);
    }
}
