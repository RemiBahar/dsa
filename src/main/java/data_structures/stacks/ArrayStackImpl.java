package data_structures.stacks;

import java.io.IOException;

/**
 * Stack implemented with an array which doubles in length when full
 */
public class ArrayStackImpl implements Stack{
    private int front;

    private String[] values;

    private ArrayStackImpl(){
        values = new String[10];
        front = -1;
    }

    /**
     * Removes an item from the front of the stack
     * @return value removed
     */
    public String pop(){
        String value = values[front]; // get old value to return
        values[front] = null; // allow old front to be garbage collected, stop loitering
        front = front - 1;

        int halfSize = values.length / 4;

        if(front < halfSize){
            resize(values.length / 2);
        }

        return value;
    }

    /**
     * Inserts an item to the top of the stack
     * @param value value to insert
     * @return value inserted
     */
    public String insert(String value){
        front = front + 1; // move front of array to next position

        if(front >= values.length){
            resize(values.length * 2;);
        }

        this.values[front] = value; // add value to array
        return value;
    }

    private void resize(int newSize){
        String[] newValues = new String[newSize];

        // Copy values to new array
        for(int i = 0; i < values.length; i++){
            newValues[i] = values[i];
        }

        // Update array
        this.values = newValues;
    }

    @Override
    public String toString() {
        String result = "[";

        int current = front;
        while(current >= 0){
            result += values[current] + ",";
            current = current - 1;
        }

        result += "]";
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        ArrayStackImpl list = new ArrayStackImpl();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.pop();
        list.insert("4");

        System.out.println(list);

    }
}