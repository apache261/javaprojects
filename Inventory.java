
class Product{
	private String name;
	private double price;
	private int quantity;

	public Product(){
		this.name = "";
		this.price = 0.00;
		this.quantity = 0;
	}
	public Product(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public String getName(){
		return this.name;
	}
	public double getPrice(){
		return this.price;
	}
	public void setQuantity(int quan){
		this.quantity = quan;
	}
	public boolean reduceStock(int purchase){
		if(this.quantity >= purchase){
			setQuantity(this.quantity - purchase);
			return true;
		}
		System.out.println("Not Enough Stock");
		return false;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(this.name).append(" | ");
		sb.append(Double.toString(this.price)).append(" | ");
		sb.append(Integer.toString(this.quantity)).append("\n");
		return sb.toString();
	}

}




public class Inventory {
	// Increase the size of array
	// If exceed to its size
	private static Product[] increase(Product[] prod){
		int size = prod.length;
		Product[] temp = new Product[size *2];
		for(int index = 0; index < size; index++){
			temp[index] = prod[index];
		}
		return temp;
	}

	
	private static void printAll(Product[] prod){
		if(prod.length == 0){
			System.out.println("Nothing In Here!");
			return;
		}
		for(int index = 0; prod[index] != null; index++){
			System.out.print((index+1) + ". " +prod[index]);
		}
	}
	private static double calculate(Product[] cart){
		double total = 0.00;
		if(cart.length == 0){
			
			return total;
		}
		for(int index = 0; cart[index] != null; index++){
			total += (cart[index].getQuantity() * cart[index].getPrice());
		}
		return total;
	}

	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		Product[] stocks = new Product[10];
		Product[] cart = new Product[10];
		
		int stockSize = 0;
		int cartSize = 0;
		int quantity = 0;

		int selection = 0;
		int custQuant = 0;

		double price = 0.00;

		String prodName = "";
		String custName = "";

		

		do{
			System.out.println("1. Add Item to the Stock");
			System.out.println("2. View Stocks");
			System.out.println("3. Customer Transaction");
			System.out.print("Enter: ");
			int choice = sc.nextInt();

			switch(choice){
				//ADD ITEM
				case 1:
				if(stockSize >= stocks.length){
					stocks = increase(stocks);
				}
				
				System.out.print("Enter Product Name: ");
				prodName = sc.next();
				System.out.print("Enter Price: ");
				price = sc.nextDouble();
				System.out.print("Enter Quantity: ");
				quantity = sc.nextInt();
				stocks[stockSize] = new Product(prodName,price,quantity);
				stockSize++;
				break;

				//VIEW 
				case 2:
				System.out.println("***** YOUR Stocks******");
				printAll(stocks);
				System.out.println("***** END ********");
				break;

				// PURCHASE
				case 3:
				System.out.print("Enter Customer Name: ");
				custName =sc.next();

				do{
					System.out.println("\n\n********MENU*******");
					System.out.println("-1. Exit");
					System.out.println("0. View Cart");
					System.out.println("####PRODUCTS####");
					printAll(stocks);
					System.out.println("******************");

					if(cartSize >= cart.length){
						cart = increase(cart);
					}
					System.out.print("Select PRODUCT: ");
					selection = sc.nextInt();
					if(selection >= 0){
						if(selection == 0){
							System.out.println("***** YOUR CART ******");
							printAll(cart);
							System.out.println("***** END ********");
						}else{
							System.out.print("Enter Quantity: ");
							custQuant = sc.nextInt();
							if(stocks[selection-1].reduceStock(custQuant) == true){
								
								cart[cartSize] = new Product(stocks[selection-1].getName(),stocks[selection-1].getPrice(),custQuant);
								
							}
						}
					}
				}while(selection != -1);
				System.out.println("\n********** YOUR RECEIPT  " + custName + "******");
				printAll(cart);
				System.out.println("\n\t\tTOTAL: " + calculate(cart));
				System.out.println("****** THANK YOU*******\n\n");
				break;
				default:
				System.out.println("Operation Not Founnd!");
				break;
			}

		}while(true);

	}
}