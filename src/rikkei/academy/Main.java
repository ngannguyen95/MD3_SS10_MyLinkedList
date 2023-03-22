package rikkei.academy;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList(10);
        myLinkedList.addFist(5);
        myLinkedList.addFist(7);
        myLinkedList.addLast(10);
        System.out.println(myLinkedList);

    }
}
