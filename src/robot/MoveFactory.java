package robot;

import java.util.Stack;

import ds.Node;

public class MoveFactory {
	
	private Object updateCurrentPosition(Stack<Node> storeDirection) {
		Object obj = null;
		switch(storeDirection.peek().getData()) {
			case 'N': obj = new MoveNorth();
				break;
			case 'E': obj = new MoveEast();
				break;
			case 'S': obj = new MoveSouth();
				break;
			case 'W': obj = new MoveWest();
			break;
		}
		return obj;
	}
	
	public Object getFactoryObject(char ch, Stack<Node> storeDirection) {
		Object obj = null;
		switch(ch) {
			case 'L': obj = new LeftDirection();
				break;
			case 'R': obj = new RightDirection();
				break;
			case 'M': obj = updateCurrentPosition(storeDirection);
				break;
		}
		return obj;
	}

}
