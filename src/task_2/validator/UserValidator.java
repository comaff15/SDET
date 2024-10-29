package task_2.validator;

import task_2.exception.WrongLoginException;
import task_2.exception.WrongPasswordException;

public class UserValidator {
    public static boolean validateUser(String login, String password, String confirmPassword){
        try {
            if(!login.matches("[a-zA-Z0-9_]+") || login.length() >= 20){
                throw new WrongLoginException("Wrong login");
            }

            if (!password.matches("[a-zA-Z0-9_]+") || password.length() >= 20 || !password.equals(confirmPassword)){
                throw new WrongPasswordException("Wrong password or login");
            }

            return true;
        }catch (WrongLoginException | WrongPasswordException e)  {
            System.err.println(e.getMessage());

            return false;
        }
    }
}
