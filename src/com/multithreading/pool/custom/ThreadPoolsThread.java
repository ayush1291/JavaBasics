package com.multithreading.pool.custom;

class ThreadPoolsThread extends Thread {
 
    private ICustomBlockingQueue<Runnable> taskQueue;
    private ThreadPool threadPool;
 
    public ThreadPoolsThread(ICustomBlockingQueue<Runnable> queue,
                  ThreadPool threadPool){
        taskQueue = queue;
        this.threadPool=threadPool;
       
    }
 
    public void run() {
           try {
                  /*
                   * ThreadPool's threads will keep on running
                   * until ThreadPool is not shutDown (shutDown will interrupt thread) and
                   * taskQueue contains some unExecuted tasks.
                   */
                  while (!this.threadPool.isPoolShutDownInitiated()) {    
                        System.out.println(Thread.currentThread().getName()
                                      +" is READY to execute task as it has been started aftering being added in the threadPool");
                        /*ThreadPool's thread will take() task from sharedQueue
                         * only if tasks are available else
                         * waits for tasks to become available.
                         */
                        Runnable runnable = taskQueue.take();
                        System.out.println(Thread.currentThread().getName() +" has taken task.");
                        //Now, execute task with current thread.
                        runnable.run();                
                        
                        System.out.println(Thread.currentThread().getName() +" has EXECUTED task.");
                        
                        /*
                         * 1) Check whether pool shutDown has been initiated or not,
                         * if pool shutDown has been initiated and
                         * 2) taskQueue does not contain any
                         *    unExecuted task (i.e. taskQueue's size is 0 )
                         * than  interrupt() the thread.
                         */
                  }
           } catch (Exception e) {
                  System.out.println(Thread.currentThread().getName()+" has been STOPPED with exception");
           }
           System.out.println(Thread.currentThread().getName()+" has been STOPPED.");
    }
}