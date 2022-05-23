package robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ds.Node;

public class Robot {
	private Position curPos;
	private Stack<Node> storeDirection;
	private Plane plane;
	private List<Character> dirComments;
	private MoveFactory moveFactory;
	Robot(int m, int n, int x, int y, char dir, String moves){
		this.dirComments = new ArrayList<>();
		moveFactory = new MoveFactory();
		this.plane = new Plane.Builder().setM(m).setN(n).build();
		storeDirection = new Stack<>();
		setPosition(x, y);
		setDirection(dir);
		moves(moves);
	}
	
	private void setPosition(int x, int y) {
		curPos = new Position(x,y);
		plane.updateVisited(x,y);
	}
	
	private void setDirection(char dir) {
		Node curNode = plane.getCurrentDirection(dir);
		storeDirection.add(curNode);
	}
	private void move(char ch) {
		Object obj = moveFactory.getFactoryObject(ch, storeDirection);
		if(obj instanceof Direction) {
			dirComments.add(ch);
			storeDirection.add(((Direction) obj).changeDirection(plane.getCll(), storeDirection.peek()));
		}else if(obj instanceof Move) {
			((Move) obj).move(curPos, 1, plane);
		}
	}
	
	protected char getCurrentDirection() {
		return storeDirection.peek().getData();
	}
	
	protected Position getPosition() {
		return curPos;
	}
	
	private void moves(String str) {
		for(int i=0;i<str.length();i++) {
			move(str.charAt(i));
		}
	}
	
	public int getLeftCount() {
		int res=0;
		for(char ch:dirComments) {
			if('L' == ch) {
				res++;
			}
		}
		return res;
	}
	
	public int getRightCount() {
		int res=0;
		for(char ch:dirComments) {
			if('R' == ch) {
				res++;
			}
		}
		return res;
	}
	
	public static class Builder {
		private int m,n,x,y;
		char dir;
		String moves;
		
		public Builder setM(int m) {
            this.m = m;
            return this;
        }
		
		public Builder setN(int n) {
            this.n = n;
            return this;
        }
		
		public Builder setX(int x) {
            this.x = x;
            return this;
        }
		
		public Builder setY(int y) {
            this.y = y;
            return this;
        }
		
		public Builder setDir(char dir) {
            this.dir = dir;
            return this;
        }
		
		public Builder setMoves(String moves) {
            this.moves = moves;
            return this;
        }

		public Robot build() {
			return new Robot(m, n, x, y, dir, moves);
		}
		
	}
	
}
