package LinkedList;

public class DLL {
    private Node head;

    public void insertfirst(int value){
        Node ketan = new Node(value);
        ketan.next = head;
        ketan.previous = null;
        if(head != null){
            head.previous = ketan;
        }
        head = ketan;
    }

    public void display (){
        Node temp = head;
        Node last = null;
        while(temp != null){
            System.out.print(temp.value+ "--> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");


        System.out.println("Print in reverse");
        System.out.print("END <--");
        while(last != null){
            System.out.print(last.value + " <--");
            last = last.previous;
        }
        System.out.println("START");

    }

    public void insertatlast(int value){
        Node ketan = new Node(value);
        Node last = head;

        if(head == null){
            ketan.previous = null;
            head = ketan;
            return;
        }

        while(last.next!=null){
            last = last.next;
        }

        last.next = ketan;
        ketan.previous = last;
        ketan.next = null;

    }
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.previous = p;
        if (node.next != null) {
            node.next.previous = node;
        }
    }


    private class Node{
        int value;
        Node next;
        Node previous;


        Node(int value){
            this.value = value;
        }

        Node(int value, Node next, Node previous){
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }
}
