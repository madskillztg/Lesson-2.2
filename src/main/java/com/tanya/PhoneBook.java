package com.tanya;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, List<String>> contacts = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        contacts.computeIfAbsent(surname, key -> new ArrayList<>())
                .add(phoneNumber);
    }

    public List<String> get(String surname) {
        return contacts.getOrDefault(surname, List.of());
    }
}
