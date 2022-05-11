package robot;

class CircularLinkedList{
	
	class Node{
		private char data;
		private Node next;  
		private Node prev;
		
		public char getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
		public Node getPrev() {
			return prev;
		}
	}
	Node head;
	void printList(){
		Node node = head;
        while (node != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	void addNode(char value) {  
        if (head == null) {  
            Node node = new Node();  
            node.data = value;  
            node.next = node.prev = node;  
            head = node; 
        }else {
	        Node last = head.prev; 
	        Node node = new Node();  
	        node.data = value;  
	        node.next = head; 
	        head.prev = node;  
	        node.prev = last;
	        last.next = node;  
        }
    }
	Node getNodeByValue(char ch) {
		Node node = head;
		
        while (node != null){
        	if(node.data == ch) {
        		return node;
        	}
            node = node.next;
        }
        return null;
	}
	Node getPreviousNode(Node node) {
		return node.prev;
	}
	Node getNextNode(Node node) {
		return node.next;
	}
	
}