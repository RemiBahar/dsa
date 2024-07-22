package data_structures.stacks;

import java.io.IOException;

/**
 * Stack implemented with a custom linked list
 */
public class LinkedStackImpl implements Stack{
    private Node head;

    private LinkedStackImpl(){
        this.head = null;
    }

    /**
     * Removes an item from the front of the stack
     * @return value removed
     */
    public String pop(){
        if(head == null){
            return "No head";
        }

        Node oldHead = head;

        // Make second item the new start of list
        this.head = oldHead.next;

        // Allow current head to be garbage collected
        oldHead.next = null;

        return oldHead.value;
    }

    /**
     * Inserts an item to the top of the stack
     * @param value value to insert
     * @return value inserted
     */
    public String insert(String value){
        Node insertNode = new Node(value);

        if(head != null){
            // link new node to previous start of list
            insertNode.next = head;
        }

        // update start of list to be new node
        this.head = insertNode;

        return value;
    }

    @Override
    public String toString() {
        String value = "[";
        Node node = head;
        while(node != null){
            value += node.value + ", ";

            node = node.next;
        }

        return value + "]";
    }

    /**
     * Represents an item which is linked to a successive item
     */
    private class Node {
        private Node next;
        private String value;

        private Node(String value){
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        LinkedStackImpl list = new LinkedStackImpl();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.pop();
        list.insert("4");

        System.out.println(list);

    }
}