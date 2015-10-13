package Homework2.parallel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<E> {

    private E value;
    private Object[] array = new Object[11];
    private int imageLength;

    public MyArrayList() {
        this.imageLength = 0;
    }

    // метод расшіряет текущий масив
    private void enlargeArray() {
        int length = array.length;


        if (length < 20000) {
            length = length + (int) (length * 1.5); // увеличиваем размер масива в 1.5 раза
        } else {
            if (length < 20000000) {
                length = length + (int) (length * 0.5); // увеличиваем размер масива на 50%
            } else {
                length = length + (int) (length * 0.001); // увеличиваем размер масива на 1/10 процента
            }
        }


        Object newArray[] = new Object[length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }


    public void add(E value) {
        if (array.length > imageLength) {  // если реальная длина масива больше мнимой, то споколйно добавляем елемент
            array[imageLength] = value;
        } else {
            enlargeArray();              // если же нет, то вызываем метод рашырения масива
            array[imageLength] = value;// и спокойно добавляем новый елемент
        }
        imageLength++;// увелииваем мнимую длину на единицу
    }


    public E get(int index) {
        if (index < 0 || index >= imageLength) {
            throw new ArrayIndexOutOfBoundsException(index);
        } else {
            return (E) array[index];
        }
    }


    public boolean set(int index, E value) {
        if (index < 0 || index >= imageLength) {
            return false;
        } else {
            array[index] = value;
            return true;
        }


    }


    public boolean add(int index, E value) {
        if (index < 0 || index > imageLength) {
            return false;
        } else {
            if (array.length <= imageLength + 1) {  // если реальная длина масива больше мнимой, то споколйно добавляем елемент
                enlargeArray();
            }
            E tmp1 = null;
            E tmp2 = null;
            for (int i = index; i < imageLength + 1; i++) {
                if (i == index) tmp1 = (E) array[i];
                tmp2 = (E) array[i + 1];
                array[i + 1] = tmp1;
                tmp1 = tmp2;
            }
            array[index] = value;
            imageLength++;
            return true;
        }

    }


    public int indexOf(E value) {
        int index = -1;
        boolean cheack = false;
        for (int i = 0; i < imageLength; i++) {
            if (array[i].equals(value)) {
                cheack = true;
                index = i;
                break;
            }
        }
        return index;
    }

    public int size() {
        //System.out.println("real  size: " + array.length);
        //System.out.println("image size: " + (imageLength));
        return imageLength;
    }

    public E remove(int index) {
        if (index < 0 || index >= imageLength) {
        } else {
            if (array.length == imageLength) {
                enlargeArray();
            }
            for (int i = index; i < imageLength; i++) {
                array[i] = array[i + 1];
            }
            imageLength--;
        }
        return null;
    }




    @Override
    public String toString() {
        String imageArray = "[";
        for (int i = 0; i < imageLength; i++) {
            if (array[i] != null) {
                imageArray = imageArray + array[i].toString() + " ";
            } else {
                imageArray = imageArray + "null" + " ";
            }

        }
        imageArray = imageArray + "]";

        // System.out.println("real  Array: " + Arrays.toString(array));
        System.out.println("image Arary: " + imageArray);
        return "";
    }







    public int parallelIndexOf(E e){
        int step = 20000;
        int counter =0;
        // расчитуем сколько потоков надо зайдействовать
        for(double many=imageLength; many>0;many = many-step ) {
            counter++;
         }

        if(counter == 1){                                 // если всего один поток, то зачем парится?
            return indexOf(e);
        }else{                                            // если потоков больше, то ех...
            ParalleSearch [] threadArray = new ParalleSearch[counter];
            for(int i=0;i<counter;i++){
                Object tmp[];
                if(i != counter ){    // если ето не последняя часть масива
                    tmp =new Object[step];
                    System.arraycopy(array,  (i*step),tmp,0,tmp.length);
                }else{               // если это последння часть масива
                    int newLength =  (imageLength - counter*step);
                    tmp =new Object[(newLength)];
                    System.arraycopy(array,  (i*step),tmp,0,tmp.length);
                }
                //System.out.println(Arrays.toString(tmp));
                threadArray[i] = new ParalleSearch(tmp.clone(),e,counter);
                threadArray[i].start();
            }
            boolean exit = true;
            while(exit){
                for(int i=0;i<counter;i++){
                    if(threadArray[i].getIndexSearchElement() != -1){
                        exit=false;
                        return (int) (threadArray[i].getIndexSearchElement()+i*step);
                    }
                }
                // проверяем закончили ли роботу все потоки
                int cheack = counter;
                for(int i=0;i<counter;i++){
                    if(threadArray[i].getState() == Thread.State.TERMINATED ){
                        cheack--; // если поток закончил роботу уменьшаем щетчик на 1
                    }
                }
                if(cheack==0){ // щетчик = 1 - выходим
                    exit = false;
                }
            }
        }



        return -1;
    }



    private class ParalleSearch <E> extends Thread{
        private Object[]  array;
        private boolean nullElement = false;
        private int index = -1;
        private E searchElement;
        int id;

        public ParalleSearch(Object array [], E searchElement, int id){
            this.array = array;
            this.searchElement = searchElement;
            this.id = id;
        }
        public boolean getNullElement(){
            return  this.nullElement;
        }
        public int getIndexSearchElement(){
            return  this.index;
        }


        @Override
        public void run(){
            for(int i=0;i<array.length;i++){
              if(array[i] != null){
                          if(searchElement.equals( (E)array[i])){
                              index = i;
                                System.out.println("Я, поток id: "+ id + ", его нашол:)  ");
                  }
              }else nullElement = true;

            }
        }
    }



















    public Iterator iterator() {

        return new MyIterator();
    }



    private class MyIterator <E> implements Iterator {

        private int index;

        public MyIterator() {
            index  = 0;
        }

        @Override
        public boolean hasNext() {

            return index< imageLength ;
        }

        @Override
        public E next() {
            if (index < imageLength) {
                return (E) array[index++];
            } else throw new NoSuchElementException();

        }

        @Override
        public void remove() {
            if (array.length == imageLength) {
                enlargeArray();
            }
            if(index-1 >=0){
                for (int i = index-1; i < imageLength; i++) {
                    array[i] = array[i + 1];
                }
                index--;
                imageLength--;
            }else{
                throw  new IllegalStateException();
            }

        }

    }

}
