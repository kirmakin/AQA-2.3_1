package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryFormTest {

    @Test
    void shouldResubmitRequest() {
        open("http://localhost:9999");
        $("[data-test-id=city] .input__control").setValue(DataGenerator.Registration.getCity());
        $(".input__menu .menu-item__control").click();
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] .input__control").setValue(DataGenerator.Registration.getDatePlus4());
        $("[data-test-id=name] [name=name]").setValue(DataGenerator.Registration.getFullName());
        $("[data-test-id=phone] [name=phone]").setValue(DataGenerator.Registration.getPhone());
        $("[data-test-id=agreement]>.checkbox__box").click();
        $(".grid-col .button__text").click();
        $("[data-test-id='success-notification']>.notification__title").shouldBe(visible);
                //shouldBe(visible).shouldHave(text("Встреча успешно запланирована на " +
                //"DataGenerator.Registration.getDatePlus4()"));
        $("[data-test-id=date] .input__control").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id=date] .input__control").sendKeys(DataGenerator.Registration.getDatePlus10());
        $(".grid-col .button__text").click();
        $("[data-test-id='replan-notification'] .button__text").click();
        $("[data-test-id='success-notification']>.notification__title");
                //shouldBe(visible).shouldHave(text("Встреча успешно запланирована на " +
                //DataGenerator.Registration.getDatePlus10()));
    }
}
