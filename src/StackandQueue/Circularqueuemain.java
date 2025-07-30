package StackandQueue;

public class Circularqueuemain {
    public static void main(String[] args) throws Exception {

        CircularQueue queue = new CircularQueue(5);

        queue.insert(2);
        queue.insert(23);
        queue.insert(12);
        queue.insert(4);
        queue.insert(26);

        queue.display();

        System.out.println(queue.remove());
        queue.insert(133);
        queue.display();

        System.out.println(queue.remove());
        queue.insert(99);
        queue.display();
    }
}
