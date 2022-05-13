package robot;

import java.util.Arrays;

import ds.CircularLinkedList;
import ds.Node;

public class Plane {
	
	private boolean[][] isVisited;
	private int m;
	private int n;
	CircularLinkedList allDirection;

	public Plane(boolean[][] isVisited, int m, int n, CircularLinkedList cll) {
		this.m=m;
		this.n=n;
		this.isVisited=isVisited;
		this.allDirection = cll;
	}

	public boolean[][] getIsVisited() {
		return isVisited;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}
	
	public CircularLinkedList getCll() {
		return allDirection;
	}
	
	public void updateVisited(int x, int y) {
		isVisited[x][y] = true;
	}
	
	public boolean isInValidPosition(int x, int y) {
		return x<0 || y<0 || x>m || y>n || isVisited[x][y] ;
	}
	
	protected void printTravel() {
		for(int i=0;i<isVisited.length;i++) {
			for(int j=0;j<isVisited[0].length;j++) {
				System.out.print(isVisited[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public Node getCurrentDirection(char ch) {
		return allDirection.getNodeByValue(ch);
	}
	public void printList() {
		allDirection.printList();
	}
	@Override
	public String toString() {
		return "RobotUtils [isVisited=" + Arrays.toString(isVisited) + ", m=" + m + ", n=" + n + ", cll=" + allDirection + "]";
	}
	
	public static class Builder {
		private boolean[][] isVisited;
		private int m;
		private int n;
		CircularLinkedList cll;
		public Builder setM(int m) {
            this.m = m;
            return this;
        }
		
		public Builder setN(int n) {
            this.n = n;
            return this;
        }

		public Plane build() {
			this.cll = new CircularLinkedList();
			this.cll.addNode('N');
			this.cll.addNode('E');
			this.cll.addNode('S');
			this.cll.addNode('W');
			this.isVisited = new  boolean[m+1][n+1];
			return new Plane(isVisited, m, n, cll);
		}
		
	}
}
