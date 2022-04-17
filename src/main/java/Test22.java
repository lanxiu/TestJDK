
/*
* @文 件 名:  Test22.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2019年6月6日 下午3:57:54 
*/
/**   
 * @文 件 名:  Test22.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2019年6月6日 下午3:57:54 
 */
public class Test22 {
	    private static int sharedVariable = 0;

	    private static final int MAX = 10;

	    public static void main(String[] args)  throws Exception{
	    Thread t1 =     new Thread(() -> {
	            int oldValue = sharedVariable;
	            while (sharedVariable < MAX) {
	                if (sharedVariable != oldValue) {
	                    System.out.println(Thread.currentThread().getName() + " watched the change :********************************************************************************* " + oldValue + "->" + sharedVariable);

	                    oldValue = sharedVariable;
	                    }
	                else {

//	                    System.out.println(Thread.currentThread().getName() + " watched the change11 : " + oldValue + "->" + sharedVariable);
	                }

//	                try {
//	                    Thread.sleep(10);
//	                } catch (InterruptedException e) {
//	                    e.printStackTrace();
//	                }

	            }
	        }, "t1");

	      Thread t2=   new Thread(() -> {
	            int oldValue = sharedVariable;
	            while (sharedVariable < MAX) {
	                System.out.println(Thread.currentThread().getName() + " do the change : " + sharedVariable + "->" + (++oldValue));

	                sharedVariable = oldValue;

	                try {
	                    Thread.sleep(500);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }, "t2");t2.start();
	        Thread.sleep(100);
	        t1.start();
	        

	      
	        
	        
	        
	        
	        
	        

            Thread.sleep(5000+5000);
            System.out.println(t1.isAlive() +" "+ Test22.sharedVariable) ;
            System.out.println(t2.isAlive());
	    }
	}

