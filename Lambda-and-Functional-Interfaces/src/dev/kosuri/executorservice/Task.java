package dev.kosuri.executorservice;

public class Task implements Runnable {
	public void run() {
		System.out.println("Running thread " + Thread.currentThread().getName());
	}
}
