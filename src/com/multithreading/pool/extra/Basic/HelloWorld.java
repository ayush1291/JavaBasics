package com.multithreading.pool.extra.Basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Need to shutdown executor else keep on running on jvm

public class HelloWorld{

     public static void main(String []args){
         ExecutorService executor = null;
         
        try {
            
            executor = Executors.newFixedThreadPool(4);
            try {
				executor.awaitTermination(4, TimeUnit.SECONDS);
			} catch (Exception e) {
				System.out.println("Await exception");
				e.printStackTrace();
			}
            for (int i = 0; i <= 5; i++) 
            {
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
            }
            System.out.println("attempt to shutdown executor");
           
            executor.shutdown();
            Task task = new Task("Task " + 12);
            executor.execute(task);
            
        }
        catch (Exception e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
     }
}
