import java.util.ArrayList;
public class Test{

	private ArrayList<String> me;

	public Test(ArrayList<String> str){
		this.me = str;
	}
	public void addItem(){
		this.me.add("dsfsdf");
	}



	public static void main(String[] args) {
		ArrayList<String> s = new ArrayList<>();
		Test ts = new Test(s);
		ts.addItem();

		System.out.println(s.toString());
	}
}