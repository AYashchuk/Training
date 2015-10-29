package Session5.Hash;

/**
 * Created by admin on 10.11.2014.
 */
public class Persen {
    String name;
    String family;
    String perntName;
    int ZP ;
    int age;

    public String getName() {
        return name;
    }

    Persen(String name, String family, String perntName, int age,int zp){
        this.name = name;
        this.family = family;
        this.age = age;

        this.perntName = perntName;
        this.ZP = zp;

    }


    @Override
    public boolean equals(Object obj) {
        boolean cheack = false;
        if (this == obj) {
            return true;
        } else {
            if (obj instanceof Persen) {
                Persen human = (Persen) obj;
                if (human.name == this.name && human.family == this.family && human.age == this.age && human.perntName == this.perntName && human.ZP == this.ZP) {
                        return true;
                } else return false;
            } else return false;
        }
    }

    @Override
    public int hashCode(){
        int code = name.hashCode()+family.hashCode()+age+perntName.hashCode()+ZP;
        return code;
    }


    @Override
    public String toString(){
        return name+" " +family +" " + perntName;
    }
}
