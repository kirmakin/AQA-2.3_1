package ru.netology;

import com.github.javafaker.Faker;
import ru.netology.RegistrationForm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static class Registration {
        private Registration() {
        }

        private static final Faker faker = new Faker(new Locale("ru"));

        public static String getCity() {
            return faker.address().city();
        }

        public static String getDatePlus4() {
            LocalDate now = LocalDate.now().plusDays(4);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            return now.format(formatter);
        }

        public static String getDatePlus10() {
            LocalDate now = LocalDate.now().plusDays(10);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
            return now.format(formatter);
        }

        public static String getFullName() {
            return faker.name().lastName().replace("ё", "е") +
                    " " + faker.name().firstName().replace("ё", "е");
        }

        public static String getPhone() {
            return faker.phoneNumber().phoneNumber().replace("+", "").
                    replace("(", "").replace(")", "").replace("-", "");
        }
    }
}
