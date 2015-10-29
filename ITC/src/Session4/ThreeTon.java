package Session4;

/**
 * Created by admin on 04.11.2014.
 */
public class ThreeTon {

        private static int counter=0;
        private static ThreeTon instance ;
        private ThreeTon(int i){
             System.out.println("ThreeTone _ " + i);
        }
        public synchronized static ThreeTon getInstance(){
            if(counter<3){
                counter++;
                instance = new ThreeTon(counter);
                return instance;
            }
            return null;
        }
}

