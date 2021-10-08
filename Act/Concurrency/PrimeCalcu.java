import java.util.ArrayList;
import java.util.Collections;
// 10 Task Performance 1 - ARG (Concurrency)
// Programing Languages
// Submitted TO Mr. De Los Santos
// From Lynol Ibarra CS3A

// PRIME NUMBER CALCULATOR 
// OPTIMIZED FOR DUAL CORE PROCESSORS
// EACH THREADS COMPUTES separate ranges of numbers 
// Results are then Store on a single array
// CONCURRENT 6 METHODS USED: 
// isAlive(); setPriority(), setName(), join(), sleep(), start()

public class PrimeCalcu{

	private Thread workOne;
	private Thread workTwo;
	private int workOnePriority;
	private int workTwoPriority;

	public PrimeCalcu(Thread th1, Thread th2){

		this.workOne = th1;
		this.workTwo = th2;

		this.workOnePriority = th1.getPriority();
		this.workTwoPriority = th2.getPriority();
	}
	//Alive & sleep
	protected void waitForThreads(){

		while(this.workOne.isAlive() || this.workTwo.isAlive()){
			try{
				// pause Main Thread while 2 threads are working
				Thread.sleep(1); 
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			
		}

	}
	// Start the threads and apply Priority
	protected void startThreads(){
		
		try{
			this.workOne.start();
			this.workTwo.start();
			if(this.workOnePriority < this.workTwoPriority){
				this.workTwo.join();
				this.workOne.join();
			}else{
				this.workOne.join();
				this.workTwo.join();
			}
		}catch(final InterruptedException e){
			e.printStackTrace();
		}
	}
	// Main Driver
	public static void main(String[] args) {
		ArrayList<Integer> primeList = new ArrayList<>(); // storage Array

		PrimeSolver solverOne = new PrimeSolver(0,100,primeList); // 0-100
		PrimeSolver solverTwo = new PrimeSolver(101,200,primeList); // 101 - 200

		Thread workerOne = new Thread(solverOne);
		Thread workerTwo = new Thread(solverTwo);

		workerOne.setPriority(Thread.MAX_PRIORITY); // Highest Priority
		workerTwo.setPriority(Thread.NORM_PRIORITY); // Normal Priority
		workerOne.setName("Thread-1");
		workerTwo.setName("Thread-2");

		PrimeCalcu calc = new PrimeCalcu(workerOne,workerTwo);

		calc.startThreads(); // Start the threads

		System.out.println("**** Computing Done ****");
		Collections.sort(primeList); // sort results
		System.out.println("\n" + primeList.toString() + "\n");
	}


}

class PrimeSolver implements Runnable{
	private ArrayList<Integer> primeList;
	private int startNum; // starting number
	private int endNum; // terminating number

	public PrimeSolver(int start, int end, ArrayList<Integer> storage){
		this.primeList = storage;
		this.startNum = start;
		this.endNum = end;
	}
	public void run(){
		int currentTest 	= 0;
		int finalTest 		= this.endNum;
		for(currentTest = this.startNum; currentTest <= finalTest; currentTest++){
			if(this.isPrime(currentTest)){
				//only one thread can write on the array at a time
				synchronized(this.primeList){
					this.primeList.add(currentTest);
					this.threadStat(currentTest);
				}
			}
		}

	}
	public boolean isPrime(int number){
		int maxCase = number/2; //theorem
		boolean isPrime = true;
		// less / equal 1 is not prime
		if(number <= 1) {isPrime = false;}

		if(number > 2){
			for(int currentCase = 2; currentCase <= maxCase; currentCase++){
				if(number % currentCase == 0){isPrime= false; break;}
			}
		}
		return isPrime;

	}
	public void threadStat(int num){
		System.out.println("| " + Thread.currentThread().getName() + " | => "+ num);
	}



}