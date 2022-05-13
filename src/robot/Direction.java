package robot;

import ds.CircularLinkedList;
import ds.Node;

public interface Direction {

	public Node changeDirection(CircularLinkedList cll, Node curDirection);
}
