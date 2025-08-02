package RandomQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
public class RayBenKevin {

    public static void main(String[] args) {

    }


    public static String function(String ray){
        Queue<Character> rayqueue = new LinkedList<>();
        Deque<Character> ben = new ArrayDeque<>();
        StringBuilder kevin = new StringBuilder();
        for(char ch : ray.toCharArray()){
            rayqueue.offer(ch);
        }
        while(!rayqueue.isEmpty() || !ben.isEmpty()){
            if(ben.isEmpty()) {  ben.add(rayqueue.remove());
            }
            else if (rayqueue.isEmpty()){
                kevin.append(ben.peekLast());
            }
            else
            {if(rayqueue.peek() < ben.peekLast()) {
                ben.add(rayqueue.remove());
            }
            else{
                kevin.append(ben.pollLast());
            }
            }
        }
        return String.valueOf(kevin);
    }



}
