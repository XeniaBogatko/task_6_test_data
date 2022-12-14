package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.FormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class FormTest {
    FormPage formPage = new FormPage();
    TestData testData = new TestData();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1024x768";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void firstTest() {

        formPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.mobile)
                .setBirthDate(testData.day, testData.month, testData.year)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .uploadPicture(testData.picture)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submit();

        formPage.checkResultTableVisible()
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.mobile)
                .checkResult("Date of Birth", testData.day + " " + testData.month + "," + testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.picture)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);
    }
}
