package com.multithreading.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolExeBlockingQueue {

	
	
	
	public static void main(String[] args) {
		BlockingQueue q = new ArrayBlockingQueue(5);
		ThreadPoolExecutor ex = new ThreadPoolExecutor(2, 3, 20, TimeUnit.SECONDS, q);
		try{
		for (int i = 0; i < 10; i++) {
			ex.execute(new RunnableObject(i));
		}
		}
		catch (RejectedExecutionException rej) {
		    System.out.println("Exception!!!! Max limit reached");
		  } 
		
	}
}
