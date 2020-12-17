package ru.netology;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import static ru.netology.DataGenerator.Registration.*;
import static ru.netology.DataGenerator.*;

public class DeliveryFormTest {

    RegistrationForm registrationFormData = getRegistrationFormData();

    @Test
    void shouldResubmitRequest() {
        open("http://localhost:9999");
        $("[data-test-id=city] .input__control").setValue(registrationFormData.getCity());
        $(".input__menu .menu-item__control").click();
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] .input__control").setValue(getDate(4));
        $("[data-test-id=name] [name=name]").setValue(registrationFormData.getName());
        $("[data-test-id=phone] [name=phone]").setValue(registrationFormData.getPhone());
        $("[data-test-id=agreement]>.checkbox__box").click();
        $(".grid-col .button__text").click();
        $("[data-test-id='success-notification']>.notification__content").
                waitUntil(visible, 15000).shouldHave(text("Встреча успешно запланирована на " +
                getDate(4)));
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] .input__control").sendKeys(getDate(10));
        $(".grid-col .button__text").click();
        $("[data-test-id='replan-notification'] .button__text").click();
        $("[data-test-id='success-notification']>.notification__content").
                waitUntil(visible, 15000).shouldHave(text("Встреча успешно запланирована на " +
                getDate(10)));
    }
}
