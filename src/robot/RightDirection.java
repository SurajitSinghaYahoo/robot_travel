package robot;

import ds.CircularLinkedList;
import ds.Node;

public class RightDirection implements Direction{

	@Override
	public Node changeDirection(CircularLinkedList cll, Node curDirection) {
		return cll.getNextNode(curDirection);
	}
}
