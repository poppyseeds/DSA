package LinkedList;

public class Main {
    public static void main(String[] args) {
//        LL list = new LL();
//        list.insertatfirst(23);
//        list.insertatfirst(4);
//        list.insertatfirst(6);
//        list.insertatfirst(15);
//        list.insertatfirst(2);
//        list.insertatfirst(3);
//        list.insertatlast(7);
//        list.insertatposition(16, 3);
//        list.display();
//        System.out.println();
//        System.out.println("Deleted Item from start: " + list.deletefirst());
//        list.display();
//        System.out.println();
//        System.out.println("Deleted Item from last: " + list.deleteLast());
//        list.display();
//        System.out.println();
//        System.out.println("Delete Item from index " + 3 + ": "  +list.deleteatposition(3) );
//        list.display();


        DLL list = new DLL();
        list.insertfirst(3);
        list.insertfirst(2);
        list.insertfirst(8);
        list.insertfirst(17);
        list.insertatlast(99);
        list.insert(8, 65);

        list.display();
    }
}
