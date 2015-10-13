package Homework1.Cashier;

import sun.security.util.Password;

/**
 * Created by admin on 02.11.2014.
 */
public class User {
    private String login;
    private String password;
    private boolean isAdmine;


    public User(String login, String password, boolean isAdmine){
        this.login = login;
        this.password = password;
        this.isAdmine = isAdmine;
    }

    public String getLogin(){
        return this.login;
    }
    public String getPassword(){
        return this.password;
    }
    public boolean getIsAdmine(){
        return this.isAdmine;
    }

    @Override
    public String toString(){

        return "UserLogin: "+ login+", userPassword: " + password + ", isAdmine: " + isAdmine;
    }
}
