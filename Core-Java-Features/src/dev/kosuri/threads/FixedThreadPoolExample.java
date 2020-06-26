package dev.kosuri.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

	public static void main(String... args) {
		
		int coreCount = Runtime.getRuntime().availableProcessors();
		System.out.println("Number of CPU cores available on this machine are: "+ coreCount);
		
		//For CPU intensive operations, pool size > coreCount is of not much use.
		//For IO intensive operations, pool size should be more than the CPU count, as we want other treads to pick more tasks while existing threads are blocked/waiting on IO
		ExecutorService service = Executors.newFixedThreadPool(10);
	
		
		for (int i=0; i<1100; i++) {
			// these tasks are submitted to a BlockingQueue from which Threads from the pool pick the tasks
			service.execute(new Task()); 
		}
	}
	
	/**
	 * Cannot instantiate the instance of this inner class (in execute method call) if it were't static.
	 * It should be instantiated like this - new MyThreadExecutor().new Task()
	 * 
	 * This Task can be a separate Class as well, obviously.
	 */
	static class Task implements Runnable{
		public void run(){
			System.out.println("Running Thread "+Thread.currentThread().getName());
			/*
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
	}
}


