package com.multithreading.waitnotifynotifyall.notworking;

public class HelloWorld{

     public static void main(String []args){
        System.out.println("Produce and consume products >> Create Strawberry ice cream");
        Product product = new Product("Strawberry ice cream"); 
        Consumer consumer1 = new Consumer(product);
        new Thread(consumer1,"consumer1").start();
        Consumer consumer2 = new Consumer(product);
        new Thread(consumer2,"consumer2").start();
        Producer producer = new Producer(product);
        new Thread(producer,"producer").start();
    }
}