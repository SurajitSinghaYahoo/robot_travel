package ds;

public class Node{
		protected char data;
		protected Node next;  
		protected Node prev;
		
		public char getData() {
			return data;
		}
		public Node getNext() {
			return next;
		}
		public Node getPrev() {
			return prev;
		}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
	}
}
