package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

public class StudentRegistrationForm extends TestBase{
    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    @Test
    void successfulStudentRegistrationFormTest() {

        // Given / Open site
        studentRegistrationFormPage.openDemoQaSite();

        // When / Fill the form
        studentRegistrationFormPage.fillForm();

        // Then / Verify successful form submit
        studentRegistrationFormPage.checkData();
    }
}
