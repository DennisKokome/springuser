package co.bw.weblogic.springuser.util;

/**
 * Created by oaitse on Aug, 16, 2021
 */
public class UsernameExistException extends Exception {
    public UsernameExistException(String message) {
        super(message);
    }
}
