package StackandQueue;

public class Dynamicqueue extends CircularQueue{
   public Dynamicqueue(){
       super();
   }

   public Dynamicqueue(int size){
       super(size);
   }

   @Override
    public boolean insert ( int item){
       if(this.isFull()){

           int[] temp = new int[data.length*2];

           //copy all the elements from data to temp
           for (int i = 0; i < data.length; i++) {
               temp[i] = data[i];
           }
           front = 0;
           end = data.length;
           data = temp;
       }
       return super.insert(item);
   }

}
