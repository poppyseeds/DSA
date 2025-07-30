package Trees;



class SegmentTree {

    public SegmentTree(int[] arr) {
        this.root = constructTree(arr, 0, arr.length-1);
    }

    public static class Node{
            int value;
            int startinterval;
            int endinterval;
            Node left;
            Node right;


             public Node(int StartInterval, int EndInterval){
                this.startinterval = StartInterval;
                this.endinterval = EndInterval;
            }
        }

        Node root;

    private Node constructTree(int[] arr, int start, int end) {
            if(start == end){
                Node node = new Node(start, end);
                node.value = arr[start];
                return node;
            }

            Node node = new Node(start,end);

            int mid = start + (end-start)/2;

            node.left = this.constructTree(arr, start, mid);
            node.right = this.constructTree(arr, mid+1, end);

            node.value = node.left.value + node.right.value;
            return node;
    }


    public void display(){
            display(this.root);
    }


    private void display(Node node){

             String str = "";
            if(node.left != null){
                str = str + "Interval : [" + node.left.startinterval + "," + node.left.endinterval + "] Value : " + node.left.value + " | ";
            }
            else{
                str = str + "No left Node | ";
            }

            //current node
        str = str + "Interval : [" + node.startinterval + "," + node.endinterval + "] Value : " + node.value + " | ";

            //right node
        if(node.right != null){
            str = str + "Interval : [" + node.right.startinterval + "," + node.right.endinterval + "] Value : " + node.right.value + " | ";
        }
        else{
            str = str + "No right Node | d";
        }


        System.out.println(str + '\n');


        if(node.left != null){
            display(node.left);
        }
        if(node.right != null){
            display(node.right);
        }
    }

    public int query(int qsi, int qei) {
        return this.query(this.root, qsi, qei);
    }
    private int query(Node node, int qsi, int qei) {
        if(node.startinterval >= qsi && node.endinterval <= qei) {
            // node is completely lying inside query
            return node.value;
        } else if (node.startinterval > qei || node.endinterval < qsi) {
            // completely outside
            return 0;
        } else {
            return this.query(node.left, qsi, qei) + this.query(node.right, qsi, qei);
        }
    }

    public void update(int index, int value) {
        this.root.value = update(this.root, index, value);
    }
    private int update(Node node, int index, int value) {
        if (index >= node.startinterval&& index <= node.endinterval){
            if(index == node.startinterval && index == node.endinterval) {
                node.value = value;
                return node.value;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.value = leftAns + rightAns;
                return node.value;
            }
        }
        return node.value;
    }



}