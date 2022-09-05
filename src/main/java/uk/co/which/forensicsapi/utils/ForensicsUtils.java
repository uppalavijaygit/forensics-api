package uk.co.which.forensicsapi.utils;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class ForensicsUtils {


    List<String> validEmails = List.of("uppalavijay@gmail.com","valid@email.com");

    /**
     * This function will validate the email against the Auth Users list if format is valid
     * @param enteredEmail is the email which received as a path param
     * @return will return the true if given string is in correct email format and authenticated user
     */
    public boolean userAuthenticated(String enteredEmail){
        if(isValidEmailFormat(enteredEmail)){
            return validEmails.contains(enteredEmail);
        }
        return false;
    }

    /**
     * This function will check the format of the email
     * @param enteredEmail is the email which received as a path param
     * @return will return the true if given string is in correct email format
     */
    public boolean isValidEmailFormat(String enteredEmail){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(enteredEmail);
        return matcher.matches();
    }
}
