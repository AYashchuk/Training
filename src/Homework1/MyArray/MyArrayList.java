package Homework1.MyArray;

import java.util.*;

public class MyArrayList <E> implements Iterable<E> {

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


    public int indexOf(int value) {
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


    public Iterator iterator () {

        return new MyIterator();
    }


    private class MyIterator <User> implements Iterator {

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
