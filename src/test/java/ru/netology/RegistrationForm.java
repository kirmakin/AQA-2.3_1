package ru.netology;
import com.github.javafaker.PhoneNumber;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class RegistrationForm {
    private final String city;
    private final String name;
    private final PhoneNumber phone;
}
