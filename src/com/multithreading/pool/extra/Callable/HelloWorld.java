package com.multithreading.pool.extra.Callable;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;


public class HelloWorld implements Callable<String> {

	public AtomicInteger inte=new AtomicInteger(1);
	
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return inte.incrementAndGet()+"";
    }
    
    public static void main(String args[]){
        final ExecutorService executor = Executors.newFixedThreadPool(3);
        final List<Future<String>> list = new ArrayList<Future<String>>();

        Callable<String> callable = new HelloWorld();
        for(int i=0; i< 10; i++){
            Future<String> future = executor.submit(callable);
            list.add(future);
        }
        new Thread(){
        	@Override
        	public void run() {
        		for(Future<String> fut : list){
                    try {
                        //print the return value of Future, notice the output delay in console
//                         because Future.get() waits for task to get completed
                        System.out.println(new Date()+ "::"+fut.get());
                        list.add(new Future<String>() {

							@Override
							public boolean cancel(boolean mayInterruptIfRunning) {
								// TODO Auto-generated method stub
								return false;
							}

							@Override
							public boolean isCancelled() {
								// TODO Auto-generated method stub
								return false;
							}

							@Override
							public boolean isDone() {
								// TODO Auto-generated method stub
								return false;
							}

							@Override
							public String get() throws InterruptedException,
									ExecutionException {
								// TODO Auto-generated method stub
								return null;
							}

							@Override
							public String get(long timeout, TimeUnit unit)
									throws InterruptedException,
									ExecutionException, TimeoutException {
								// TODO Auto-generated method stub
								return null;
							}
						});
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                executor.shutdown();
        	}
        }.start();
        
        
    }

}