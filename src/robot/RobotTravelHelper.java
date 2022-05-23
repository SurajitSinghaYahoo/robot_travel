package robot;

public class RobotTravelHelper {
	public void robotTravel(String area, String positionAndDirection, String moves) {
		
		int row = Integer.parseInt(area.substring(0,1));
		int col = Integer.parseInt(area.substring(2));
		
		int x = Integer.parseInt(positionAndDirection.substring(0,1));
		int y = Integer.parseInt(positionAndDirection.substring(2,3));
		char dir = positionAndDirection.charAt(4);
		
		Robot rt = new Robot.Builder()
				.setM(row)
				.setN(col)
				.setX(x)
				.setY(y)
				.setDir(dir)
				.setMoves(moves)
				.build();
		System.out.print(rt.getPosition().getX()+ " "+ rt.getPosition().getY()+ " ");
		System.out.println(rt.getCurrentDirection());
		System.out.println("Total left count is: " + rt.getLeftCount());
	}
}
