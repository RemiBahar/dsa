package data_structures.queues;

public class ArrayQueueImpl implements Queue{
    private int front;
    private int back;
    private String[] values;

    public ArrayQueueImpl(){
        values = new String[10];
    }

    public void resize(int newSize){
        String[] newValues = new String[newSize];
        int newBack = front;

        for(int index = front; index <= back; index++){
            newValues[index] = values[index];
            newBack++;
        }

        front = 0;
        back = newBack;
    }

    @Override
    public String enqueue(String value) {

        if(values.length == (back + 1)){
            // Resize
            resize(values.length * 2);
        }


        int newIndex = back + 1;
        values[newIndex] = value;
        back = newIndex;

        return value;
    }

    @Override
    public String dequeue() {
        int newIndex = front + 1;

        if(front == back){
            front = 0;
            back = 0;
            return "List is now empty";
        }

        if(newIndex == (values.length/4)){
            resize(values.length / 2);
        }

        values[front] = null;
        front = newIndex;
        return values[front];
    }

    @Override
    public String toString(){
        String returnStr = "[";

        for(int index = front; index <= back; index++){
            returnStr += values[index] + ",";
        }

        returnStr += "]";

        return returnStr;
    }

    // Main
    public static void main(String[] args){
        ArrayQueueImpl queue = new ArrayQueueImpl();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("5");

        System.out.println(queue);
    }
}
