class Adder{
	//static
	private static int total;
	//constructor
	// No Parameter Set to 0
	public Adder(){
		total = 0;
	}
	public Adder(int a){
		total = a;
	}
	public void addNum(int number){
		total += number;
	}
	public int getTotal(){
		return total;
	}
	//main method
	public static void main(String[] args){
		Adder a = new Adder();
		a.addNum(10);
		a.addNum(20);
		a.addNum(30);
		System.out.println("Total " + a.getTotal());
	}
}
