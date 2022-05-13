package robot;

public class MoveNorth implements Move{
	@Override
	public void move(Position curPos, int addY, Plane r) {
		int x = curPos.getX();
		int y = curPos.getY() + addY;
		if(!r.isInValidPosition(x,y)){
			curPos.setX(x);
			curPos.setY(y);
			r.updateVisited(x, y);
		}else {
			throw new RuntimeException("Move out of Rectangular Plane OR Already Visited OR Some partical in Plane");
		}
	}
}
