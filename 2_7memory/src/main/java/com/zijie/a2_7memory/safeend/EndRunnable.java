package com.zijie.a2_7memory.safeend;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：中断Runnable类型的线程
 */
public class EndRunnable {
	
	private static class UseRunnable implements Runnable{
		
		@Override
		public void run() {

			String threadName = Thread.currentThread().getName();
			//TODO
			System.out.println(threadName+" interrput flag is "
					+Thread.currentThread().isInterrupted());
		}			
	}

	public static void main(String[] args) throws InterruptedException {
		UseRunnable useRunnable = new UseRunnable();
		Thread endThread = new Thread(useRunnable,"endThread");
		endThread.start();
		Thread.sleep(20);
		endThread.interrupt();
	}

}