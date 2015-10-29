package Session6.Map;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by admin on 11.11.2014.
 */

// создать клас хештаблица, и зделать метод добавления елемента в карту (метод put)
public class MyHashTabel <E> {
    LinkedList<Para>[] HashTable = new LinkedList[16];

    public void add(int Key, int value) {
        if (HashTable[Key % 16].size() == 0) {
            HashTable[Key % 16].add(new Para(Key, value));
        } else {
            for (int i = 0; i < HashTable[Key % 16].size(); i++) {
                if (HashTable[Key % 16].get(i).getKey() == Key) {
                    HashTable[Key % 16].get(i).setValue(value);
                }
            }

        }


    }


    public int get(int Key) {
        int hashcode = Key % 16;
        if (HashTable.length < hashcode) {

        }
        return 0;
    }



    class Para{
        int Key;
        int Value;

        public int getValue() {
            return Value;
        }

        public void setValue(int value) {
            Value = value;
        }

        public int getKey() {
            return Key;
        }

        Para(int key, int value) {
            this.Key = key;
            this.Value = value;
        }
    }

}
