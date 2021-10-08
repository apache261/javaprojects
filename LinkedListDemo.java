import java.util.Scanner;


class Node{
	public String name;
	public Node next;
	public Node prev;

	public Node(String name,Node next){
		this.name = name;
		this.next = next;
	}
	public Node (String name, Node prev,Node next){
		this.name = name;
		this.prev = prev;
		this.next = next;
	}

}

/*
* ptr1->ptr2->ptr3->null
*/
class SinglyLinkedList{
	private Node start = null;

	public void insertBeginning(String name){
		if(start == null){
			start = new Node(name,null);
		}else{
			Node ptr = start;
			start = new Node(name,ptr);
		}
	}

	public void insertEnd(String name){
		Node ptr;
		if(start == null){
			start = new Node(name,null);
		}else{
			ptr = start;
			while(ptr.next != null){
				ptr = ptr.next;
			}
			ptr.next = new Node(name,null);
		}

	}

	public void delFirst(){
		if(start == null){
			System.out.println("NO List");
		}else{
		// if no other nodes
			if(start.next == null){
				start = null;
			}else{
				start = start.next;
			}
		}
	}
	public void delEnd(){

		if(start == null){
			System.out.println("No List");
		}else{

			if(start.next == null){
				start = null;
			}else{
				Node prevPtr = null;
				Node currentPtr = start;
				while(currentPtr.next != null){
					prevPtr = currentPtr;
					currentPtr = currentPtr.next;
				}
				prevPtr.next = null;
			}

		}
	}

	public void viewAll(){
		Node ptr;
		ptr = start;
		if(ptr == null){
			System.out.println("No List");
			return;
		}
		while(ptr != null){
			System.out.println(ptr.name);
			ptr = ptr.next;
		}
	}

}

/*
* ptr1->ptr2->ptr3->
* ^					|
* |_________________|
*/
class CircularlyLinkedList{
	private Node start = null;

	public void insertBegin(String name){
		if(start == null){
			start = new Node(name,null);
			start.next = start;
		}else{
			Node ptr = start;
			start = new Node(name,ptr);
		}

	}

	public void insertEnd(String name){
		if(start == null){
			start = new Node(name,null);
			start.next = start;
		}else{
			Node currentPtr = start;
			while(currentPtr.next != null){
				currentPtr = currentPtr.next;
			}
			currentPtr.next = new Node(name,start);
		}

	}
	public void delBegin(){
		if(start == null){
			System.out.println("No List");
		}else{
			if(start.next == start){
				start = null;
			}else{
				Node lastNode = start;
				while(lastNode.next != start){
					lastNode = lastNode.next;
				}
				start = start.next;
				lastNode.next = start;

			}
		}

	}
	public void delEnd(){
		if(start == null){
			System.out.println("No List");
		}else{
			if(start.next == start){
				start = null;
			}else{
				Node currentPtr = start;
				Node previousPtr = null;
				while(currentPtr.next != start){
					previousPtr = currentPtr;
					currentPtr = currentPtr.next;
				}
				currentPtr = null;
				previousPtr.next = start;
			}
		}

	}
	public void viewAll(){
		Node ptr = start;
		if(ptr == null){
			System.out.println("No List");
		}else{
			while(ptr.next != start){
				System.out.println(ptr.name);
			}
			System.out.println(ptr.name);
		}
	}
	
}


/*
*		ptr1->ptr2->ptr3->null
*	null <-ptr1<-ptr2<-ptr3
*/
class DoublyLinkedList{
	private Node start = null;

	public void insertBegin(String name){
		if(start == null){
			start = new Node(name,null,null);
		}
		else{
			Node currentPtr = start;
			start = new Node(name,null,currentPtr);
			currentPtr.prev = start;
		}
	}
	public void insertEnd(String name){
		if(start == null){
			start = new Node(name,null,null);
		}
		else{
			Node lastNode = start;
			while(lastNode.next != null){
				lastNode = lastNode.next;
			}
			lastNode.next = new Node(name,lastNode,null);
		}
	}
	public void delBegin(){
		if(start == null){
			System.out.println("No List");
		}
		else{
			if(start.next == null){
				start = null;
			}
			else{
				start.next.prev = null;
				start = start.next;
			}
		}
	}
	public void delEnd(){
		if(start == null){
			System.out.println("No List");
		}else{
			if(start.next == null){
				start = null;
			}else{
				Node lastNode = start;
				while(lastNode.next != null){
					lastNode = lastNode.next;
				}
				lastNode.prev.next = null;
				lastNode = null;

			}
		}
	}
	public void viewAll(){
		if(start == null){
			System.out.println("No List");
		}else{
			Node currentPtr = start;
			while(currentPtr != null){
				System.out.println(currentPtr.name);
				currentPtr = currentPtr.next;
			}
		}
	}
}



/*
* Using doublyLinkedList and Circular Linked List
* First node is pointing to the last node.
* Last  node is pointing to the first node.
* Each node has its own prev and next pointer.
*/
class OptimizedLinkedList{
	Node start = null;

	public void insertBegin(String name){
		if(start == null){
			start = new Node(name,null,null);
			start.prev = start;
			start.next = start;
		}else{
			// Node currentPtr = start;
			// currentPtr.next = start.prev.next;
			start = new Node(name,start.prev,start);
			start.prev.next = start;
		}
	}

	public void insertEnd(String name){
		if(start == null){
			start = new Node(name,null,null);
			start.next = start;
			start.prev = start;
		}else{
			Node lastNode = start.prev;
			start.prev = new Node(name,lastNode,start);
			lastNode.next = start.prev;
		}
	}
	public void delBegin(){
		if(start == null){
			System.out.println("No List");
		}else{
			if(start.prev == start){
				start = null;
			}else{
			// QUICK READ!!!
			// Node lastNode = start.prev;
			// Node newStart = start.next;
			// newStart.prev = lastNode;
			// lastNode.next = newStart;
				start.prev.next = start.next;
				start = start.next;
			}
		}
	}
	public void delEnd(){
		if(start == null){
			System.out.println("No List");
		}else{
			if(start.prev == start){
				start = null;
			}else{
				Node lastNode = start.prev;
			// Node preLastNode = lastNode.prev;
			// start = preLastNode;
			// preLastNode.next = start;
				start.prev = start.prev.prev;
				start.prev.next = start;	
			}
		}
	}
	public void viewAll(){
		if(start == null){
			System.out.println("No List");
		}else{
			Node currentPtr = start;
			while(currentPtr.next != start){
				System.out.println(currentPtr.name);
				currentPtr = currentPtr.next;
			}
			System.out.println(currentPtr.name);
		}
	}

}



public class LinkedListDemo{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int iSelect = 0;
		String name = "";
		OptimizedLinkedList op = new OptimizedLinkedList();
		do{
			System.out.println("1. Display");
			System.out.println("2. Insert Beginning");
			System.out.println("3. Insert End");
			System.out.println("4. Delete Beginning");
			System.out.println("5. Delete End");
			System.out.println("6. Exit");
			System.out.print("Enter: ");
			iSelect = sc.nextInt();

			switch(iSelect){
				case 1:
				op.viewAll();
				break;
				case 2:
				System.out.print("Enter Name: ");
				name = sc.next();
				op.insertBegin(name);

				break;
				case 3:
				System.out.print("Enter Name: ");
				name = sc.next();
				op.insertEnd(name);

				break;
				case 4:
				op.delBegin();

				break;
				case 5:
				op.delEnd();
				break;
			}
		}while (iSelect != 6);

	}

}