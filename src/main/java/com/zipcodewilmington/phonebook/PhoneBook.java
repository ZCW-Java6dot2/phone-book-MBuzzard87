package com.zipcodewilmington.phonebook;

import java.security.KeyStore;
import java.util.*;

//import java.util.HashMap;

/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.put(name, Collections.singletonList(phoneNumber));

    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.put(name, Arrays.asList(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String mapKey = "";
        for (Map.Entry<String, List<String>> forMap : phonebook.entrySet()) {
            if (forMap.getValue().contains(phoneNumber)) {
                mapKey = forMap.getKey();
            }
        }

        return mapKey;
    }

    public List<String> getAllContactNames() {
        ArrayList<String> contactList = new ArrayList<>(phonebook.size());
        for( String contacts : phonebook.keySet()) {
            contactList.add(contacts);
        }


        return contactList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
