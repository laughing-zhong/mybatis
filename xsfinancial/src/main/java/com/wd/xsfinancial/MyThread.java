package com.wd.xsfinancial;

import java.util.concurrent.TimeoutException;

public class MyThread extends Thread {
	
	private BlockingCell<MyDataObj> blockCell;
	private boolean isSet;
	private Thread notiThread;
	public MyThread(BlockingCell<MyDataObj> blockingCell, boolean isSet, Thread thread){
		blockCell = blockingCell;
		this.isSet = isSet;
		notiThread = thread;
	}
	@Override
	public void run(){
		try {
			if(isSet){
				Thread.sleep(10000);
				MyDataObj myDataObj = new MyDataObj();
				myDataObj.setUserName("wesly");
				this.blockCell.set(myDataObj);
				System.out.println("send obj end");
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!isSet){
			try {
				System.out.println("begin get");
				MyDataObj myObj = this.blockCell.get(1000);
				System.out.println("get object end = "+ myObj.getUserName());
			} catch (InterruptedException | TimeoutException e) {
				// TODO Auto-generated catch block
				notiThread.interrupt();
				e.printStackTrace();
			}
		}
	}

}
