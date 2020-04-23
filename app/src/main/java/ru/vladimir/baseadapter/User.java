package ru.vladimir.baseadapter;

import androidx.annotation.NonNull;

public class User {
    String name, phoneNumber;
    Sex sex;

    public User(String name, String phoneNumber, Sex sex) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Sex getSex() {
        return sex;
    }

    @NonNull
    @Override
    public String toString() {
        return "User {\n" +
                "name: " + this.name + "\n" +
                "phone: " + this.phoneNumber + "\n" +
                "sex: " + this.sex + "\n" + "}\n";
    }
}
