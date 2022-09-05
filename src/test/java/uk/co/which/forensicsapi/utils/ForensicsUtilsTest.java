package uk.co.which.forensicsapi.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForensicsUtilsTest {

    ForensicsUtils utils = new ForensicsUtils();

    @Test
    void userAuthenticated_should_true_with_Valid_and_auth_user() {
        //given
        String validUser = getValidEmail();

        //when
        boolean actual = utils.userAuthenticated(validUser);

        //then
        assertTrue(actual);
    }

    @Test
    void userAuthenticated_should_false_with_in_Valid_and_auth_user() {
        //given
        String validUser = "uppalavij@gmail.com";

        //when
        boolean actual = utils.userAuthenticated(validUser);

        //then
        assertFalse(actual);
    }

    @Test
    void isValidEmailFormat_should_true_with_valid_email() {
        //given
        String givenEmail = getValidEmail();

        //when
        boolean actual = utils.isValidEmailFormat(givenEmail);

        //then
        assertTrue(actual);
    }

    @Test
    void isValidEmailFormat_should_false_with_in_valid_email() {
        //given
        String givenEmail = "uppalavijaygmail.com";

        //when
        boolean actual = utils.isValidEmailFormat(givenEmail);

        //then
        assertFalse(actual);
    }

    @Test
    void isValidEmailFormat_should_false_with_in_valid_email_no_domain() {
        //given
        String givenEmail = "uppalavijay@";

        //when
        boolean actual = utils.isValidEmailFormat(givenEmail);

        //then
        assertFalse(actual);
    }

    private String getValidEmail() {
        return "uppalavijay@gmail.com";
    }
}