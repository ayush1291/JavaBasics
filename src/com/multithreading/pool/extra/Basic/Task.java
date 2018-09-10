package com.multithreading.pool.extra.Basic;


import java.util.concurrent.*;
class Task implements Runnable 
{
    private String name;
 
    public Task(String name) 
    {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
    @Override
    public void run() 
    {
        try
        {
            //Long duration = (long) (Math.random() * 10);
            System.out.println("Doing a task during : " + name);
            TimeUnit.SECONDS.sleep(1);
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }
}