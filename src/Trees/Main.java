package Trees;

public class Main {

    public static void main(String[] args) {

        int[] arr = {2,3,5,2,3,3,4,1};
        SegmentTree tree = new SegmentTree(arr);
         tree.display();

        System.out.println(tree.query(1, 6));
    }
}
