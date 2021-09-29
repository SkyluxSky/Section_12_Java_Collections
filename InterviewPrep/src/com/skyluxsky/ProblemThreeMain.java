package com.skyluxsky;

public class ProblemThreeMain {

    public static void main(String[] args) {
        LinkedList singlyLinkedList = new LinkedList();
        singlyLinkedList.insert(singlyLinkedList,12);
        singlyLinkedList.insert(singlyLinkedList,14);
        singlyLinkedList.insert(singlyLinkedList,15);
        singlyLinkedList.insert(singlyLinkedList,16);
        singlyLinkedList.printList(singlyLinkedList);
    }
}
