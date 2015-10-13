package Session1;

/**
 * Created by admin on 27.10.2014.
 */
public class Human {

    private long id;
    private String name;
    private int age;
    private boolean sex;
    private int iq;


    public Human(boolean sex, int id, String name,int age,int iq){
        this.sex = sex;
        this.id = id;
        this.name = name;
        this.age = age;
        this.iq = iq;
    }

    @Override
    public boolean equals(Object obj){
        boolean cheack = false;
        if(this == obj){
            return true;
        }else{
            if(obj instanceof Human){
                Human human = (Human)obj;
                if(human.sex == this.sex && human.id == this.id && human.name == this.name && human.age == this.age && human.iq == this.iq){
                    return true;
                }else return false;
            }else return false;
        }
    }


}
