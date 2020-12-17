package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    private static final Faker faker = new Faker(new Locale("ru"));

    public static String getCity() {
        return faker.address().city();
    }

        public static String getDate(int shift) {
        LocalDate now = LocalDate.now().plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return now.format(formatter);
    }

    public static String getName() {
        return faker.name().lastName().replace("ё", "е") +
                " " + faker.name().firstName().replace("ё", "е");
    }

    public static String getPhone() {
        return faker.phoneNumber().phoneNumber().replace("+", "").
                replace("(", "").replace(")", "").replace("-", "");
    }

    public static class Registration {

        public static RegistrationForm getRegistrationFormData() {
            return new RegistrationForm(getCity(), getName(), getPhone());
        }


    }
}
