package LinkedList;

public class LL {

    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertatfirst (int value){
        Node ketan = new Node(value);
        ketan.next = head;
        head = ketan;

        if(tail==null){
            tail = head;
        }
        size += 1;
    }

    public void insertatlast(int value){
        if(tail==null){insertatfirst(value);}
        else{
        Node ketan = new Node(value);
        tail.next = ketan;
        ketan.next = null;
        tail = ketan;}
        size += 1;
    }

    public void insertatposition(int value, int position){
        if(position == 0){
            insertatfirst(value);
            return;
        }
        if (position == size){
            insertatlast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i <position ; i++) {
            temp = temp.next;
        }
         Node ketan = new Node(value, temp.next);
        temp.next = ketan;

        size++;
    }

    public int deletefirst(){
        int temp = head.value;
        head = head.next;
        if(head==null){
            tail = null;
        }
        --size;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) { // start from 0
            temp = temp.next;
        }
        return temp;
    }

    public Node find(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null; // not found
    }


    public int deleteLast(){
        if(size<=1){
            deletefirst();
        }
        int value = tail.value;
        Node secondlast = get(size-1);
        tail = secondlast;
        secondlast.next = null;
        --size;
        return value;
    }

    public int deleteatposition(int index){
        if(index == 0){
            return deletefirst();
        }
        if(index == size-1){
            return deleteLast();
        }
        Node previous = get(index-1);
        int value = previous.next.value;
        previous.next = previous.next.next;
        --size;
        return value;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "--> ");
            temp = temp.next;
        }
    System.out.println("END");
    }

    //insetion using recursion
    public void insertrecursion(int value, int index){
        head = insertrecursion(value, index, head);
    }
    private Node insertrecursion(int value, int index, Node node){
        if(index == 0){
            Node temp = new Node(value);
            temp.next = node;
            size++;
            return temp;
        }
        node.next = insertrecursion(value, index-1, node.next);
        return node;
    }

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    //Questions

    //merging the two sorted linked list
    public LL merge(LL list1, LL list2){
        Node head1 = list1.head;
        Node head2 = list2.head;
        LL sorted = new LL();

        while(head1 != null && head2 != null){
            if(head1.value > head2.value){
                sorted.insertatlast(head2.value);
                head2 = head2.next;
                size++;
            }
            else {
                sorted.insertatlast(head1.value);
                size++;
                head1 = head1.next;
            }
        }

        while(head1 != null){
            sorted.insertatlast(head1.value);
            head1 = head1.next;
            size++;
        }
        while(head2 != null){
            sorted.insertatlast(head2.value);
            head2 = head2.next;
            size++;
        }
        return sorted;
    }

     //check if there is a cycle or not
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    //finding the length of cycle in a cyclic Linked List
    public int findlength(Node list){
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                Node temp = slow;
                int length = 0;
                do{
                    temp = temp.next;
                    length++;
                }
                while(temp != slow);
                return length;
            }
        }
        return 0;

    }

    //return the node from where the list starts
    public Node cyclicnode(Node head){
        int length = 0;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = findlength(slow);
                break;
            }
        }
        if(length==0){
            return null;
        }
        Node f = head;
        Node s = head;
        while(length>0){
            s = s.next;
            length--;
        }
        while(f!=s){
            f = f.next;
            s=s.next;
        }
        return s;
    }

    public Node middleNode(Node head){
        Node count = head;
        Node ans = new Node(0);
        int length = 0;
        while(count.next != null){
            count = count.next;
            length++;
        }
        if(length%2==0){
            //return (length/2)th node
             ans = get(length/2);
        }
        else{
            //return (length - 1/2)th node
             ans = get((length-1)/2);
        }
        return ans;
    }

}

