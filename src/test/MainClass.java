package test;

import java.util.Scanner;

import robot.RobotTravelHelper;

public class MainClass {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		System.out.print("Enter Size Of Rectangular as row and column format- "); 
		String area = sc.nextLine();
		System.out.print("Enter starting position cordinate as x&y  and direction- ");
		String positionAndDirection = sc.nextLine();
		System.out.print("Enter Moves- ");
		String moves = sc.nextLine();
		
		RobotTravelHelper robotTravelHelper = new RobotTravelHelper();
		robotTravelHelper.robotTravel(area, positionAndDirection, moves);
	}
}
