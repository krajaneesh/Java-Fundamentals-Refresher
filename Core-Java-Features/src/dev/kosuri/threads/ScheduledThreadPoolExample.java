package dev.kosuri.threads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

	public static void main (String... args) {
		
		//Uses DelayQueue - which maintains tasks in the order in which they need to run - not the order in which they are declared below.
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		//Start after a delay of -
		service.schedule(new Task(), 10, TimeUnit.SECONDS);
		
		//Start after a delay of 10 seconds & run every 5 seconds, no matter Task triggered earlier is complete or not.
		service.scheduleAtFixedRate(new Task(), 10, 5, TimeUnit.SECONDS);
		
		//Start after initial delay of 10 seconds & then run Task with 2 second delay between execution completion and next execution trigger. 
		service.scheduleWithFixedDelay(new Task(), 10, 2, TimeUnit.SECONDS);
		
	}
	
	static class Task implements Runnable{
		public void run() {
			System.out.println("Running Thread "+ Thread.currentThread().getName());
		}
	}
}
