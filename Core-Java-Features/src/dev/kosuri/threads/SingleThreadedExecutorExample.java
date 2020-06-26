package dev.kosuri.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadedExecutorExample {

	public static void main(String[] args) {
		
		// Single Thread handles the Tasks.
		//Use when we need to run the Tasks in order.
		
		// If there is an Exception while running any Thread, the ExecutorService ensures that a new Thread is created to complete the remaining Tasks
		// - just like other Executors
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		for(int i=0; i<50; i++) {
			service.execute(new Task());
		}
		
	}
	
	static class Task implements Runnable{
		public void run() {
			System.out.println("Running thread "+Thread.currentThread().getName());
		}
	}

}
