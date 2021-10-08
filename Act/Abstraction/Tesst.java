public class Tesst{
   static Prime ad1 = new Prime(200,1000l);
   static Prime ad2 = new Prime(100,700l);

   static Thread th1 = new Thread(ad1);
   static Thread th2 = new Thread(ad2);


   public static void main(String[] args) throws InterruptedException{
      th1.setName("Thread-1");
      th2.setName("Thread-2");

      System.out.println("Main Thread Started");
      th1.start();
      th2.start();
      th1.setPriority(Thread.NORM_PRIORITY);
      th2.setPriority(Thread.MAX_PRIORITY);

      System.out.println(Thread.currentThread().getName() + " => waiting => " + th1.getName());
      th1.join();
      // System.out.println(th1.getName() + " => result => " + ad1.getSum());
      System.out.println(Thread.currentThread().getName() + " => waiting => " + th2.getName());
      th2.join();
      // System.out.println(th2.getName() + " => result => " + ad2.getSum());
      
   }
}


class Adder implements Runnable{
   private int sum;
   private int maxCount;
   private long sleep;
   public Adder(int maxCount, long sleep){
      this.sum = 0;
      this.maxCount = maxCount;
      this.sleep = sleep;
   }
   @Override
   public void run(){
      int a = 0;

      while(a < maxCount){
         this.sum += a;
         System.out.println(Thread.currentThread().getName() + " => process " +a);
         a++;
      }
      this.setToSleep();
   }

   public int getSum(){
      return this.sum;
   }
   public int getMaxCount(){
      return this.maxCount;
   }
   private void setToSleep(){
   try{
      System.out.println("[ " + Thread.currentThread().getName() + " ] Sleep [ " + (float)this.sleep/1000 +"s ]" );
      Thread.sleep(this.sleep);

   }catch(InterruptedException e){
      e.printStackTrace();
   }
}
}

class Prime implements Runnable{
   private int maxCount;
   private long sleep;

   public Prime(int maxCount, long sleep){
      this.maxCount = maxCount;
      this.sleep = sleep;
   }
   @Override
   public void run(){
      for(int a  = 0; a < this.maxCount ; a++){
            System.out.println(Thread.currentThread().getName() + "=> Prime " + a + " = " + this.isPrime(a));
            this.setToSleep();
      }

   }
   public boolean isPrime(int num){
      int max = num/2;
      int count = 0;
      int flag = 1;
      if(num > 1){
         if(num == 2){flag = 0;}
         else{
           
            for(count= 2; count <= max; count++){
               if(!(num % count == 0)){
                  flag = 0;
                  
               }
               break;
            }
           
      }

   }
   
   return flag == 0;
}

private void setToSleep(){
   try{
      System.out.println("[ " + Thread.currentThread().getName() + " ] Sleep [ " + (float)this.sleep/1000 +"s ]" );
      Thread.sleep(this.sleep);

   }catch(InterruptedException e){
      e.printStackTrace();
   }
}
}

