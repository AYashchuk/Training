package Homework3.authentication;

/**
 * Created by admin on 13.11.2014.
 */
public class AuthTest {
    public static void main(String[] args) {
        Auth auth = new Auth();
        auth.add();
        System.out.println(auth.authenticate());
        System.out.println(auth.remove());
        auth.showBase();
    }
}
