package robot;

import ds.CircularLinkedList;
import ds.Node;

public class LeftDirection implements Direction{

	@Override
	public Node changeDirection(CircularLinkedList cll, Node curDirection) {
		return cll.getPreviousNode(curDirection);
	}
}
