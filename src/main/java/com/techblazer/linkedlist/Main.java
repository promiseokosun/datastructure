package com.techblazer.linkedlist;

class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add("Promise");
        list.add("Kings");
        list.add("Adams");
        list.add("Hope");
        list.add("200");

//        list.print();
//        System.out.println(list.size());
//        System.out.println("First item: " + list.first());
//        System.out.println("Last item: " + list.last());
//        System.out.println("Get item at index 0: " + list.getAt(0));
//        System.out.println("Get last: " + list.lastV2());
//        System.out.println("get index: " + list.getIndexOf("Adams"));
//        list.print();
//        list.deleteAt(5);
//        list.print();

//        list.print();
//        System.out.println("Before deleting: " + list.size());
//        System.out.println("Deleted: " + list.delete("Adams"));
//        list.print();
//        System.out.println("After deleting: " + list.size());

//        list.print();
//        System.out.println("Before replacing: " + list.size());
//        list.replaceAt(2,"Dumebi");
//        list.print();
//        System.out.println("After replacing: " + list.size());


//        list.print();
//        System.out.println("Before replacing: " + list.size());
//        list.addAt(2,"Dumebi");
//        list.print();
//        System.out.println("After replacing: " + list.size());

//        list.print();
//        System.out.println("Before clear: " + list.size());
//        list.clear();
//        list.print();
//        System.out.println("After clear: " + list.size());

        list.print();
        System.out.println("Is empty: " + list.isEmpty());
        list.clear();
        System.out.println("Is empty: " + list.isEmpty());
        list.print();
    }
}

class Node<T> {
    T data;
    Node next;
}

class SinglyLinkedList<T> {

    Node<T> head;
    int size;

    SinglyLinkedList() {
        head = null;
    }

    public void add(T data) {
        Node<T> node = new Node<>();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            // traverse through the list resolve data and address
            Node<T> current = head;
            while (true) {
                if (current.next == null) break;
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void print() {
        Node<T> current = head;
        if(current == null) {
            System.out.println("[]");
            return;
        }
        String sb = "[";
        while (current.next != null) {
            sb = sb + current.data + ", ";
            current = current.next;
        }
        sb = sb + current.data + "]";
        System.out.println(sb);
    }

    public int size() {
        return size;
    }

    public T getAt(int index) {
        Node<T> current = head;
        checkEmpty(current);
        checkIndexBound(index);

        for (int i = 0; i < size(); i++) {
            if (i == index) return current.data;
            current = current.next;
        }
        return null;
    }


    public int getIndexOf(T data) {
        Node current = head;
        checkEmpty(current);
        for(int i = 0; i < size(); i++) {
            if(current.data == data) return i;
            current = current.next;
        }
        return -1;
    }

    private void checkIndexBound(int index) {
        if (index >= size() || index < 0) throw new IllegalArgumentException("Index out of bound");
    }

    private static <T> void checkEmpty(Node<T> current) {
        if (current == null) throw new IllegalArgumentException("list is empty");
    }


    public T first() {
        Node<T> current = head;
        checkEmpty(current);
        return head.data;
    }

    public T firstV2() {
        return getAt(0);
    }

    public T last() {
        Node<T> current = head;
        checkEmpty(current);
        Node<T> last = null;
        while (true) {
            last = current;
            current = current.next;
            if (current == null) break;
        }
        return last.data;
    }

    public T lastV2() {
        return getAt(size() - 1);
    }

    public boolean deleteAt(int index) {
        Node<T> current = head;
        int initialSize = size();
        checkEmpty(current);
        checkIndexBound(index);
        head = null;
        size = 0;

        for (int i = 0; i < initialSize; i++) {
            if (i == index) {
                current = current.next;
                continue;
            }
            add(current.data);
            current = current.next;
        }
        return size() < initialSize;
    }

    public boolean delete(T data) {
        Node<T> current = head;
        int initialSize = size();
        checkEmpty(current);
        head = null;
        size = 0;

        for (int i = 0; i < initialSize; i++) {

            if (current.data.equals(data)) {
                current = current.next;
                continue;
            }
            add(current.data);
            current = current.next;
        }
        return size() < initialSize;
    }


    public void replaceAt(int index, T data) {
        Node<T> current = head;
        int initialSize = size();
        checkEmpty(current);
        head = null;
        size = 0;

        for (int i = 0; i < initialSize; i++) {

            if (i == index) {
                add(data);
            } else {
                add(current.data);
            }
            current = current.next;
        }
    }


    public void addAt(int index, T data) {
        Node<T> current = head;
        int initialSize = size();
        checkEmpty(current);
        head = null;
        size = 0;

        for (int i = 0; i < initialSize; i++) {

            if (i == index) {
                add(data);
            }
            add(current.data);
            current = current.next;
        }
    }


    public void clear() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

}

