
public class Position {
	int row; 
	int colone; 
	char direction;
	
	public Position(int row, int colone, char direction) {
		this.row = row;
		this.colone = colone;
		this.direction = direction;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColone() {
		return colone;
	}

	public void setColone(int colone) {
		this.colone = colone;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

}
