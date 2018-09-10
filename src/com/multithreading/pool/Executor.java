package com.multithreading.pool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Two ways to create it

public class Executor {
	
	boolean stopRequested;
	ExecutorService exec = Executors.newFixedThreadPool(4);

	private void runServer() throws IOException {
	  ServerSocket sock = new ServerSocket(1040);
	  while (!stopRequested) {
	    Socket s = sock.accept();
	    exec.execute(new ConnectionRunnable(s));
	  }
	}

	private static class ConnectionRunnable implements Runnable {
	  private final Socket s;
	  ConnectionRunnable(Socket s) {
	    this.s = s;
	  }
	  public void run() {
	    // handle connection
	  }
	}

}
