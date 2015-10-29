package Homework3.hash;

import java.util.Date;

/**
 * Created by admin on 12.11.2014.
*/
public class User {
    private String UserName;
    private String password;
    private String date;
    private int rating;
    private boolean isMan;


    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

    public int getRating() {
        return rating;
    }

    public boolean isSex() {
        return isMan;
    }

    public User(String userName, String password, String date, int rating, boolean sex) {
        this.password = password;
        UserName = userName;
        this.date = date;
        this.rating = rating;
        this.isMan = sex;
    }
    public User(String userName, String password) {
        this.password = password;
        UserName = userName;
        this.date = new Date()+"";
        this.rating = 0;
        this.isMan = true;
    }

    @Override
    public int hashCode(){
        return UserName.hashCode()+password.hashCode()+date.hashCode()+rating+(isMan+"").hashCode();
    }
    @Override
    public String toString(){
        return "username: "+UserName+"; password: "+password+"; date: " +date+"; rating:"+rating;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }else{
            if(obj instanceof User){
                User human = (User)obj;
                if(human.UserName.equals(UserName) &&
                   human.password.equals(password) &&
                   human.date.equals(date)         &&
                   human.rating == this.rating     &&
                   human.isMan == this.isMan){
                    return true;
                }else return false;
            }else return false;
        }
    }

}