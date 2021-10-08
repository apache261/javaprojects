// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int max = 20;
        Counter job1 = new Counter(2,max); // by 2
        Counter job2 = new Counter(5,max); // by 5
        
        Thread th1 = new Thread(job1);
        Thread th2 = new Thread(job2);
        
        th1.setName("Thread_1");
        th2.setName("Thread_2");
        
        th1.setPriority(Thread.MAX_PRIORITY);
        th2.setPriority(Thread.MIN_PRIORITY);
        
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("\nAll Threads Done");
        
    }
}

class Counter implements Runnable{
    private int skip;
    private int max;
    public Counter(int skip, int max){
        this.skip = skip;
        this.max = max;
    }
    @Override
    public void run(){
        for(int start = this.skip; start <= this.max; start += this.skip ){
            System.out.println("\n| "+ Thread.currentThread().getName() + " | " + start+ "\n");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
                if(Thread.currentThread().isAlive()){
                    Thread.currentThread().stop();
                }
            }
        }
    }
    
}