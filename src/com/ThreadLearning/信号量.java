package com.ThreadLearning;

import java.util.concurrent.*;

public class �ź��� { 
    public static void main(String[] args) { 
            MyPool myPool = new MyPool(20); 
            //�����̳߳� 
            ExecutorService threadPool = Executors.newFixedThreadPool(3); 
            MyThread t1 = new MyThread("����A", myPool, 6); 
            MyThread t2 = new MyThread("����B", myPool, 15); 
            MyThread t3 = new MyThread("����C", myPool, 7); 
            //���̳߳���ִ������ 
            threadPool.execute(t1); 
            threadPool.execute(t2); 
            threadPool.execute(t3); 
            //�رճ� 
            threadPool.shutdown(); 
    } 
} 

/** 
* һ���� 
*/ 
class MyPool { 
    private Semaphore sp;     //����ص��ź��� 

    /** 
     * �صĴ�С�������С�ᴫ�ݸ��ź��� 
     * 
     * @param size �صĴ�С 
     */ 
    MyPool(int size) { 
            this.sp = new Semaphore(size); 
    } 

    public Semaphore getSp() { 
            return sp; 
    } 

    public void setSp(Semaphore sp) { 
            this.sp = sp; 
    } 
} 

class MyThread extends Thread { 
    private String threadname;            //�̵߳����� 
    private MyPool pool;                        //�Զ���� 
    private int x;                                    //�����ź����Ĵ�С 

    MyThread(String threadname, MyPool pool, int x) { 
            this.threadname = threadname; 
            this.pool = pool; 
            this.x = x; 
    } 

    public void run() { 
            try { 
                    //�Ӵ��ź�����ȡ������Ŀ����� 
                    pool.getSp().acquire(x); 
                    //todo��Ҳ����������������ӵ�ҵ�� 
                    System.out.println(threadname + "�ɹ���ȡ��" + x + "����ɣ�");
                    long time = new java.util.Random().nextInt(3000);
                    System.out.println(threadname+"����"+time);
                    Thread.sleep(time);
            } catch (InterruptedException e) { 
                    e.printStackTrace(); 
            } finally { 
                    //�ͷŸ�����Ŀ����ɣ����䷵�ص��ź����� 
                    pool.getSp().release(x); 
                    System.out.println(threadname + "�ͷ���" + x + "����ɣ�"); 
            } 
    } 
}