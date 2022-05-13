package robot;

public class MoveEast implements Move{
	@Override
	public void move(Position curPos, int addX, Plane r) {
		int x = curPos.getX() + addX;
		int y = curPos.getY();
		if(!r.isInValidPosition(x,y)){
			curPos.setX(x);
			curPos.setY(y);
			r.updateVisited(x, y);
		}else {
			throw new RuntimeException("Move out of Rectangular Plane OR Already Visited OR Some partical in Plane");
		}
	}
}
