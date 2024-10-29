package task_2;

import task_2.validator.UserValidator;

public class Main {
    public static void main(String[] args) {
        boolean isValid = UserValidator.validateUser("login_123", "pass111", "pass123");

        if (isValid){
            System.out.println("All is valid");
        }
    }
}
