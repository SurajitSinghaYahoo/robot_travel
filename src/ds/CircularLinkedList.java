package ds;

public class CircularLinkedList{
	Node head;
	public void printList(){
		Node node = head;
		int count =0;
        while (count++ < 5){
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
	public void addNode(char value) {  
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
	public Node getNodeByValue(char ch) {
		Node node = head;
		
        while (node != null){
        	if(node.data == ch) {
        		return node;
        	}
            node = node.next;
        }
        return null;
	}
	public Node getPreviousNode(Node node) {
		return node.prev;
	}
	public Node getNextNode(Node node) {
		return node.next;
	}
	
}