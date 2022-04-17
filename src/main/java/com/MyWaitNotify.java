package com;
public class MyWaitNotify extends  Thread{

   final static TestJDKCharacter myMonitorObject = new TestJDKCharacter();
    boolean wasSignalled = false;

    public void doWait(){
        synchronized(myMonitorObject){
            while(!wasSignalled){
                try{
                    System.out.println("wait");
                    myMonitorObject.wait();
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            //clear signal and continue running.
            wasSignalled = false;
        }
    }
    @Override
    public void run() {
        this.doNotify();
    }
    

    public void doNotify(){
        System.out.println("notify11");
        synchronized(myMonitorObject){
            wasSignalled = true;
            myMonitorObject.notify();
        System.out.println("notify");
        }
    }

    public static  void main(String args[]){
//        mywait
        MyWaitNotify aa = new MyWaitNotify();
        MyWaitNotify bb = new MyWaitNotify();
        bb.doWait();
        new Thread(aa).start();;
        new Thread(aa).run();

    }
}