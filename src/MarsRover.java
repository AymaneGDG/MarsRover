import java.util.HashMap;

public class MarsRover {
	
	private static Position pos;
	static HashMap<Character, Integer> directions;
    static HashMap<Character, Integer> moves;
    static private MarsRover marsRover;
    static char[][] plateauMatrix;
    static Position position;
    static int[][] space;
	
	public static void main(String args[]) {
		marsRover = new MarsRover();
        space = new int[5][5];
        marsRover.mappingDirections();
        marsRover.mappingMoves();
        position = new Position(1, 2, 'N');
        
        // TODO : writting a matrix for indexing the plateau
        // TODO : writing tests 
        
        // To be written in Test 
        char[] commands = new char[]{'L', 'M', 'L', 'M', 'L', 'M', 'L', 'M', 'M'};
        for (char c : commands) {
        	marsRover.moveRover(c);
        }
        System.out.println("The position is : " + position.getColone());
        // Should be 0
        System.out.println("The row is : " + position.getRow());
        // Should be 2
        System.out.println("The colone is : " + position.getColone());
	}
	
	private int[] moveRover(int row, int col, char direction) {
		switch (direction) {
	        case 'N':
	            row -= 1;
	            break;
	        case 'S':
	            row += 1;
	            break;
	        case 'E':
	            col += 1;
	            break;
	        case 'W':
	            col -= 1;
	            break;
		}
		// TODO : should throws an exception if the row and colone are bigger than 
		// the upper-right coordinates
		int[] newLoc = new int[2];
		newLoc[0] = row;
		newLoc[1] = col;
		// just for quick test
		System.out.println("The new row is " + newLoc[0] + " The new colone is " + newLoc[1]);
        return newLoc;
	}
	
	private void moveRover(char command) {
        char updateDirection = getNewDirection(command, pos.getDirection());
        int[] updatePosition;
        if (command == 'M') {
            updatePosition = moveRover(position.getRow(), position.getColone(), updateDirection);
            pos.setRow(updatePosition[0]);
            pos.setColone(updatePosition[1]);
        }
        pos.setDirection(updateDirection);
    }
	
	private char getNewDirection(char movement, char oldDirection) {
        char newDirection = plateauMatrix[moves.get(movement)][directions.get(oldDirection)];
        return newDirection;
    }
	
	private void mappingMoves() {
        moves = new HashMap<>();
        moves.put('L', 0);
        moves.put('R', 1);
        moves.put('M', 2);
    }

    private void mappingDirections() {
        directions = new HashMap<>();
        directions.put('N', 0);
        directions.put('S', 1);
        directions.put('E', 2);
        directions.put('W', 3);
    }
	
}
