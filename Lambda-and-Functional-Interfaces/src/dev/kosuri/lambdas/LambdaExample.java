package dev.kosuri.lambdas;

public class LambdaExample {
	
	public static void main(String... args) {
		Thread t = new Thread(new MyRunnable());
		t.start();
		
		Thread t1 = new MyThread();
		t1.start();
	}
}
