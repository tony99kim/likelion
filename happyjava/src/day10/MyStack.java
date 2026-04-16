package day10;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
    List<T> stack;
    int capacity;

    public MyStack(int capacity){
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be at least 1");
        }
        this.capacity = capacity;
        this.stack = new ArrayList<>();
    }

    public void push(T value){
        if(isFull()){
            throw new IllegalStateException("Stack is full");
        }
        stack.add(value);
    }

    public T pop(){
        if(isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(size()-1);
    }

    public T peek(){
        if(isEmpty()){
        throw new IllegalStateException("Stack is empty");
        }
        return stack.get(size()-1);
    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }

    public boolean isFull(){
        return stack.size() == capacity;
    }

    public int size(){
        return stack.size();
    }

    public static void main(String[] args) {
        MyStack<Integer> intStack = new MyStack<>(3);
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.pop();
        intStack.pop();
//        intStack.pop();  예외 싱황


        System.out.println("Integer stack peek: " + intStack.peek());
        System.out.println("Integer stack pop: " + intStack.pop());
        System.out.println("Integer stack size: " + intStack.size());
        System.out.println("Integer stack isEmpty: " + intStack.isEmpty());
        System.out.println("Integer stack isFull: " + intStack.isFull());

        MyStack<String> stringStack = new MyStack<>(2);
        stringStack.push("Hello");
        stringStack.push("World");

        System.out.println("String stack peek: " + stringStack.peek());
        System.out.println("String stack pop: " + stringStack.pop());
        System.out.println("String stack size: " + stringStack.size());
        System.out.println("String stack isEmpty: " + stringStack.isEmpty());
        System.out.println("String stack isFull: " + stringStack.isFull());
    }

    }


