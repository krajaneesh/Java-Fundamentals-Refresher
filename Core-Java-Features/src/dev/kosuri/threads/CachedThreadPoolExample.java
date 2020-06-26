package dev.kosuri.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

	public static void main(String[] args) {
		
		// CachedThreadPool only holds only one Task in a SynchronousQueue. 
		//If current threads are busy, creates a ne Thread and assigns the Task.
		//If any Thread is idle for 60 seconds - kills that Thread.
		//VM is in control of number of Threads it creates and kills, not the programmer.
		ExecutorService service = Executors.newCachedThreadPool();
		
		for(int i=0; i<50; i++) {
			service.execute(new Task());
		}
	}
	
	static class Task implements Runnable{
		public void run() {
			System.out.println("Running thread "+ Thread.currentThread().getName());
		}
	}

}
