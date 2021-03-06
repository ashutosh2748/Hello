package lesson8;

import java.util.Iterator;

public class MyStringLinkedList {
		Node header;

		MyStringLinkedList() {
			header = null;
		}

		public void addFront(String item) {
			if (header == null)
				header = new Node(null, item, null);
			else {
				Node n = new Node(null, item, header);
			    	header.previous = n;
			    	header = n;
			}
		}

	// Implement the code

		public void addLast(String item) {
			Node temp=header;
			while(temp.next!=null){
				temp=temp.next;
			}
			
					Node n=new Node(temp,item,null);
					temp.next=n;
			
		}


		// implement the code
		public void postAddNode(Node n, String value){
			Node newNode;
			if (n == null){
				//List is empty
				newNode = new Node(null, value, null);
			}
			else if (n.next == null) {
				//n is the first node
				addLast(value);
			}
			else{
					newNode=new Node(n,value,n.next);
					n.next.previous=newNode;
					n.next=newNode;
					//break;
			}
					
		}
	// implement the code

	       public int Size(){
	    	   
	    	   int count=0;
	    	  while(true){
	    	  
	    		  if(header.next==null)break;
	    		  
	    		  count++;
	    	  }
	    	   
	    	   return count;
	       }

	// implement code
	    public boolean isEmpty()
	    
	{
	    	if(header==null)return true;
	    	return false;
	}  

	 

	       
		
		public void preAddNode(Node n, String value){
			Node newNode;
			if (n == null){
				//List is empty
				newNode = new Node(null, value, null);
			}
			else if (n.previous == null) {
				//n is the first node
				addFront(value);
			}
			else {
				newNode = new Node(n.previous, value, n);
				n.previous.next = newNode;
				n.previous = newNode;
			}	
						
		}
		
		public Node findLast() {
			if (header == null)
				return null;
			else {
				Node temp = header;
				while (temp.next != null)
					temp = temp.next;
				return temp;
			}
		}

		public Node findItem(String str) {
			if (header == null)
				return null;
			else {
				Node temp = header;
				while (temp != null)
					if (str.equals(temp.value))
						return temp;
					else
						temp = temp.next;
				return null;
			}
		}

		public void deleteNode(Node n) {
			if (header != null && n != null) {
				if (n.next == null && n.previous == null) {
					// only one node
					header = null;
					n = null;
					System.out.println("I am here 1");

				} else if (n.previous == null) {
					// remove first node
					n.next.previous = null;
					header = n.next;
					n = null;
					System.out.println("I am here 2");
				} else if (n.next == null) {
					// remove last node
					n.previous.next = null;
					n = null;
					System.out.println("I am here 3");
				} else {
					// general case
					n.next.previous = n.previous;
					n.previous.next = n.next;
					n = null;
					System.out.println("I am here 4");
				}

			}

		}
		
		public void deleteList(){
			Node tempOne = header;
			Node tempTwo = header;
			while (tempOne != null) {
				tempOne = tempOne.next;
				tempTwo = null;
				tempTwo = tempOne;
			}
			header = null;
		}

		public String toString() {
			String str =""; 
			Node temp = header;
			while (temp != null) {
				str = str + "-->[" + temp.value.toString() + "]";
				temp = temp.next;
			}
			str = str + "-->[" + "NULL" + "]";
			return str;
		}

		public void printReverse() {
			String str =""; 
			Node temp = findLast();
			while (temp != null) {
				str = str + "==>[" + temp.value.toString() + "]";
				temp = temp.previous;
			}
			str = str + "==>[" + "NULL" + "]";
			System.out.println(str);
		}
		public void removeFirst(){
			Node n=header;
			if (header != null&& n!=null) {
				if (n.next == null && n.previous == null) {
					// only one node
					header = null;
					n = null;
					

				} 
					// remove first node
				else if(n.next!=null)
					n.next.previous = null;
					header = n.next;
					n = null;
					}
			}
			
		
		public void removeLast(){
			Node n=findLast();
			if(n!=null){
				// remove last node
				n.previous.next = null;
				n = null;
			}
			
						}
		public void print(Node n) {
			System.out.println("I am Printing through Recursion:");
			//Node temp=n;
			if(n!=null&&n.next!=null)
			{
			System.out.println(n);
			removeFirst();
			print(getFirst());
			}
			}
		public Node getFirst(){
			if(header!=null)return header;
			else return null;
			
		}
		public Node getLast(){
			return findLast();
			
		}
		
		public class Node {
			String value;
			Node next;
			Node previous;

			Node(Node previous, String value, Node next) {
				this.previous = previous;
				this.value = value;
				this.next = next;
			}

			public String toString() {
				return value;
			}
			
			
			
}

		public static void main(String[] args) {
			MyStringLinkedList mySL = new MyStringLinkedList();
			System.out.println(mySL);
			mySL.printReverse();
			mySL.addFront("Carrot Cake");
			System.out.println(mySL);
			mySL.printReverse();
			mySL.addFront("Blueberry Muffin");
			System.out.println(mySL);
			mySL.printReverse();
			mySL.addFront("Apple Pie");
			System.out.println(mySL);
			mySL.printReverse();
			//Iterator it=mySL.Iterator();
			mySL.addLast("Orange Juice");
			System.out.println(mySL);
			mySL.printReverse();
			mySL.addLast("Peach Sauce");
			System.out.println(mySL);
			mySL.printReverse();
			mySL.deleteNode(mySL.findItem("Apple Pie"));
			System.out.println(mySL);
			mySL.printReverse();
			mySL.deleteNode(mySL.findItem("Peach Sauce"));
			System.out.println(mySL);
			mySL.printReverse();
			mySL.deleteNode(mySL.findItem("Carrot Cake"));
			System.out.println(mySL);
			mySL.printReverse();
			mySL.postAddNode(mySL.findItem("Blueberry Muffin"), "Carrot Cake");
			System.out.println(mySL);
			mySL.printReverse();
			mySL.preAddNode(mySL.findItem("Blueberry Muffin"), "Apple Pie" );
			System.out.println(mySL);
			mySL.printReverse();
			mySL.postAddNode(mySL.findItem("Carrot Cake"), "Danish Delight" );
			System.out.println(mySL);
			mySL.printReverse();
			mySL.preAddNode(mySL.findItem("Orange Juice"), "Mango Smoothie" );
			System.out.println(mySL);
			mySL.printReverse();
			mySL.postAddNode(mySL.findItem("Orange Juice"), "Peach Sauce" );
			System.out.println(mySL);
			mySL.printReverse();
			
			mySL.printReverse();
			mySL.removeFirst();
			mySL.removeLast();
			mySL.print(mySL.getFirst());
			mySL.deleteList();
			System.out.println(mySL);
		}

	}

