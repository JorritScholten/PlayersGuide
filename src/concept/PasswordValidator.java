package concept;

abstract public class PasswordValidator {
    static public boolean isValid(String password) {
        if (password.length() < 6 || password.length() > 13)
            return false;
        boolean hasLower = false, hasUpper = false, hasNumber = false;
        for (char c : password.toCharArray()) {
            if (!hasLower && Character.isLowerCase(c))
                hasLower = true;
            if (!hasUpper && Character.isUpperCase(c))
                hasUpper = true;
            if (!hasNumber && Character.isDigit(c))
                hasNumber = true;
            if (c == 'T' || c == '&')
                return false;
        }
        return hasLower && hasUpper && hasNumber;
    }
}
