package data_structures.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueueImpl<T> implements Iterable<T>{
    // Fields
    private Node<T> front;

    private Node<T> back;

    private int size;

    // Node
    private class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }

    // Constructor
    public LinkedQueueImpl() {
        this.size = 0;
        this.back = null;
        this.front = null;
    }

    // Methods

    /**
     * Add to back of queue
     * @param value
     * @return
     */
    public T enqueue(T value){
        Node newBack = new Node(value); // create new node

        if(back == null){
            front = newBack;
            back = newBack;
        } else {
            back.next = newBack;
            back = newBack;
        }

        size++;

        return value;
    }

    /**
     * Remove from front of queue
     * @return
     */
    public T dequeue(){
        if(front == null){
            throw new NoSuchElementException("List empty");
        }

        // Make second item new front of queue
        Node<T> newFront = front.next;


        // Allow old front to be garbage-collected
        front.next = null;

        // Update front
        front = newFront;
        size--;

        T val = newFront.value;

        return newFront.value;
    }

    @Override
    public String toString(){
        Node current = front;
        String returnValue = "[";

        while(current != null){
            returnValue += current.value + ",";

            current = current.next;
        }

        returnValue += "]";
        return returnValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<T> {
        private Node<T> current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.value;
            current = current.next;
            return item;
        }
    }

    // Main
    public static void main(String[] args){
        LinkedQueueImpl<String> linkedQueue = new LinkedQueueImpl<String>();
        linkedQueue.enqueue("1");
        linkedQueue.enqueue("2");
        linkedQueue.enqueue("3");
        linkedQueue.enqueue("4");
        linkedQueue.dequeue();
        linkedQueue.dequeue();
        linkedQueue.enqueue("5");

        System.out.println(linkedQueue);

        for(String item : linkedQueue){
            System.out.println("Item " + item);
        }
    }

}
