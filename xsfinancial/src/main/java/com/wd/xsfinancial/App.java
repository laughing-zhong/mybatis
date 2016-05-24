package com.wd.xsfinancial;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Hello World!" );
        App app = new App();
        System.out.println(Thread.currentThread().getName());
        BlockingCell<MyDataObj> blockCell = new BlockingCell<MyDataObj>();
        
        Thread setThread = new MyThread(blockCell, true, null);
        
        Thread getThread = new MyThread(blockCell, false, setThread);
      
     
        getThread.start();
        setThread.start();
        
        setThread.join();
        getThread.join();
        
      
    }
        	
      
    
}
