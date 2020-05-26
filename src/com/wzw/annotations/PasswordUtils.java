package com.wzw.annotations;

import java.util.List;

public class PasswordUtils {

    @UseCase(id=47, description = "Password must contain at least on numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "New password can't equal previously used one")
    public boolean checkFoNewPassword(List<String> prePasswords, String password) {
        return !prePasswords.contains(password);
    }
}
