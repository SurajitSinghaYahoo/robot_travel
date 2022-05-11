package robot;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RobotTravel {
	
	class Position{
		private int x;
		private int y;
		Position(int x, int y){
			this.x=x;
			this.y=y;
		}
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		@Override
		public String toString() {
			return "Position [x=" + x + ", y=" + y + "]";
		}
	}
	
	private char[] dir; 
	private Map<Character, ArrayList<Integer>> map;
	private int m,n;
	private Position curPos;
	CircularLinkedList ddl;
	private CircularLinkedList.Node curDirection;
	private boolean[][] isVisited;
	
	RobotTravel(int m, int n){
		this.m=m;
		this.n=n;
		isVisited = new boolean[m+1][n+1];
		ddl = new CircularLinkedList();
		ddl.addNode('N');
		ddl.addNode('E');
		ddl.addNode('S');
		ddl.addNode('W');
		map = new HashMap<Character,ArrayList<Integer>>(){{
            put('N', new ArrayList<Integer>(){{add(0);add(1);}});
            put('E', new ArrayList<Integer>(){{add(1);add(0);}});
            put('S', new ArrayList<Integer>(){{add(0);add(-1);}});
            put('W', new ArrayList<Integer>(){{add(-1);add(0);}});
        }};
	}
	
	protected void setPosition(int x, int y) {
		curPos = new Position(x,y);
		updateVisited(x,y);
	}
	
	protected void setDirectionValue(char ch) {
		curDirection = ddl.getNodeByValue(ch);
	}
	
	private void updateDirectionByMove(char ch) {
		if(ch == 'L') {
			curDirection = ddl.getPreviousNode(curDirection);
		}else if(ch == 'R') {
			curDirection = ddl.getNextNode(curDirection);
		}
	}
	
	private void updateCurrentPositionByMove() {
		List<Integer> val = map.get(curDirection.getData());
		int x = curPos.getX() + val.get(0);
		int y = curPos.getY() + val.get(1);
		if(!isInValidPosition(x,y)){
			curPos.setX(x);
			curPos.setY(y);
			updateVisited(x,y);
		}else {
			throw new RuntimeException("Move out of Rectangular Plane OR Already Visited OR Some partical in Plane");
		}
		
	}
	
	private boolean isInValidPosition(int x, int y) {
		return x<0 || y<0 || x>m || y>n || isVisited[x][y] ;
	}

	protected void move(char ch) {
		if(ch == 'L' || ch == 'R') {
			updateDirectionByMove(ch);
		}else {
			updateCurrentPositionByMove();
		}
	}
	
	protected char getCurrentDirection() {
		return curDirection.getData();
	}
	
	protected Position getPosition() {
		return curPos;
	}
	
	protected void updateVisited(int x, int y) {
		isVisited[x][y] = true;
	}
	
	protected void printTravel() {
		for(int i=0;i<isVisited.length;i++) {
			for(int j=0;j<isVisited[0].length;j++) {
				System.out.print(isVisited[i][j] + " ");
			}
			System.out.println();
		}
	}
}
