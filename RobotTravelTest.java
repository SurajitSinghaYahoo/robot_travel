package robot;

import java.util.Scanner;

public class RobotTravelTest {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		System.out.print("Enter Size Of Rectangular as row and column format- "); 
		String str= sc.nextLine();
		int row = Integer.parseInt(str.substring(0,1));
		int col = Integer.parseInt(str.substring(2));
		RobotTravel rt = new RobotTravel(row,col);
		
		System.out.print("Enter number of partical in plane- "); 
		int pNo = Integer.parseInt(sc.nextLine());
		while(pNo>0) {
			System.out.print("Enter partical in plane by cordinate as x&y- "); 
			str= sc.nextLine();
			int px = Integer.parseInt(str.substring(0,1));
			int py = Integer.parseInt(str.substring(2));
			rt.updateVisited(px,py);
			pNo--;
		}
		System.out.print("Enter starting position cordinate as x&y  and direction- ");
		str= sc.nextLine();
		int x = Integer.parseInt(str.substring(0,1));
		int y = Integer.parseInt(str.substring(2,3));
		char dir = str.charAt(4);
		rt.setPosition(x, y);
		rt.setDirectionValue(dir);
		
		System.out.print("Enter Moves- ");
		String move = sc.nextLine();
		for(int i=0;i<move.length();i++) {
			rt.move(move.charAt(i));
		}
		System.out.println();
		System.out.print(rt.getPosition().getX()+ " "+ rt.getPosition().getY()+ " ");
		System.out.println(rt.getCurrentDirection());
		System.out.println();
		rt.printTravel();
	}
}
