package com.techblazer.array;

public class Main {
    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(20);
        array.insert(10);
        array.insert(40);
        array.insert(5);
        array.print();


        System.out.println("After removing item at index 2");
        array.removeAt(2);
        array.print();

//        System.out.println("After removing item at index 0");
//        array.removeItem(40);
//        array.print();

//        System.out.println("After replacing item at index 1");
//        array.replaceAt(1, 500);
//        array.print();

//        System.out.println("index of 40 is: " + array.indexAt(40));

//        System.out.println("Item at index 3: " + array.getAt(3));

    }
}


class Array {
    private int count;
    private Object [] items;

    Array(int size) {
        items = new Object[size];
    }

    public void insert(Object item) {
        // when the size of the array is reached create a new one with twice as large and then copy all the items into it and add the new item
        // then copy it back to the items array
        if(items.length == count) {
            Object [] tempItems = new Object[count * 2];
            for(int i = 0; i < count; i++) {
                tempItems[i] = items[i];
            }
            tempItems[count] = item;
            items = tempItems;
        } else {
            items[count] = item;
        }
        count++;
    }

    public void removeAt(int index) {
        // traverse through the old array and copy all the items into the new array except for the one that is at the index provided
        Object[] tempItems = new Object[count-1]; // since we are removing an item it is safe to reduce the array by 1
        int tempIndex = 0;
        for(int i = 0; i < count; i++) {
            if(i != index) {
                tempItems[tempIndex] = items[i];
                tempIndex++;
            }
        }
        // then assign the old array to
        items = tempItems;
        count--;
    }

    public void removeItem(Object item) {
        Object[] tempItems = new Object[count-1]; // since we are removing an item it is safe to reduce the array by 1
        int tempIndex = 0;
        for(int i = 0; i < count; i++) {
            if( getAt(i).equals(item) ) {
                tempItems[tempIndex] = items[i];
                tempIndex++;
            }
        }
        // then assign the old array to
        items = tempItems;
        count--;
    }


    public void replaceAt(int index, Object item) {
        Object[] tempItems = new Object[count]; // since we are removing an item it is safe to reduce the array by 1
        for(int i = 0; i < count; i++) {
            if(i == index) {
                tempItems[i] = item;
            } else {
                tempItems[i] = items[i];
            }
        }
        // then assign the old array to
        items = tempItems;
    }


    public int indexAt(Object item) {
        int index = -1;
        for(int i = 0; i < count; i++) {
            if( getAt(i).equals(item) ) {
                index = i;
            }
        }
        return index;
    }

    public Object getAt(int index) {
        return items[index];
    }

    public void print() {
        for(int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

}
