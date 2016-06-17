package com.queueapi;

/**
 * Created by Dhaval on 6/15/2016.
 */
public class DynamicArrayQueue {

    private String[] s;
    private int head = -1;
    private int tail = -1;

    public DynamicArrayQueue(){
//        s = new String[1];
    }
    public boolean isEmpty() {
        return head == -1 || head >= tail || s.length == 0;

    }

    public void enqueue(String item){

        if(isEmpty()){
            head = 0;
            tail = 0;
            s = new String[1];
        }

        if(tail - head == s.length || tail > s.length - 1){
            resize(s.length * 2);
        }

        s[tail++] = item;
    }

    public String dequeue() throws QueueUnderFlowException{

        if(isEmpty()){
            throw new QueueUnderFlowException();
        }

        String item = s[head++];
        if(tail - head == s.length/4){
            resize(s.length/2);
        }
        return item;

    }

    public void resize(int capacity){

        String[] copy = new String[capacity];
        for(int i = head; i < tail; i++){
            copy[i - head] = s[i];
        }
        s = copy;
        tail = tail - head;
        head = 0;
    }

}
