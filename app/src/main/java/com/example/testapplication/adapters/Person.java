package com.example.testapplication.adapters;

public class Person {
    String personName;
    int personImage;
    String nameSport;

    public Person(String personName, int personImage,String nameSport) {
        this.personName = personName;
        this.personImage = personImage;
        this.nameSport = nameSport;
    }


    public String getNameSport() {
        return nameSport;
    }

    public int getPersonImage() {
        return personImage;
    }

    public String getPersonName() {
        return personName;
    }
}
