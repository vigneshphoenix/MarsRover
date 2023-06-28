package marsrovers;

public class MarsRovers {
	
	public static final Integer N = 1;
	public static final Integer E = 2;
	public static final Integer S = 3;
	public static final Integer W = 4;
	Integer x = 0;
	Integer y = 0;
	Integer facing = N;
	
	public MarsRovers() {
		
	}
	
	//Here we are setting the rover position according to the input  
	public void setPosition(Integer x, Integer y, Integer facing) {
		this.x = x;
		this.y = y;
		this.facing = facing;
	}
	
	
	//Its printing the output
	public void printPosition() {
		char dir = 'N';
		if (facing == 1) {
			dir = 'N';
		} else if (facing == 2) {
			dir = 'E';
		} else if (facing == 3) {
			dir = 'S';
		} else if (facing == 4) {
			dir = 'W';
		}
		
		System.out.println(x+" "+y+" "  +dir);
	}
	
	
	
	//These Two Methods process the series of commands from Input.  
	public void process(String commands) {
		for (int idx = 0; idx < commands.length(); idx++  ) {
			process(commands.charAt(idx));
		}
	}
	
	private void process(Character command) {
		if (command.equals('L')) {
			turnLeft();
		} else if (command.equals('R')) {
			turnRight();
		} else if (command.equals('M')) {
			move();
		} else {
			throw new IllegalArgumentException(
					"Unexpected Input");
		}
	}
	
	//Method that handles the Move command 
	private void move() {
		if (facing == N) {
			this.y++ ;
		} else if (facing == E) {
			this.x++ ;
		} else if (facing == S) {
			this.y--;
			
			// this prevents rover to move beyond lowest Y-axis which is 0
			y = y < 0 ? 0 : y;
		} else if (facing == W) {
			this.x--;
			// this prevents rover to move beyond lowest X-axis which is 0
			x = x < 0 ? 0 : x;
		}
	}
	
	
	//Method that handles the "Turn left" command 
	private void turnLeft() {
		facing = facing == N ? W : facing - 1;
	}
	
	//Method that handles the "Turn Right" command
	private void turnRight() {
		facing = facing == W ? N : facing + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarsRovers rover = new MarsRovers();
		rover.setPosition(1, 2, N);
		rover.process("LMLMLMLMM");
		rover.printPosition(); // prints 1 3 N
		rover.setPosition(3, 3, E);
		rover.process("MMRMMRMRRM");
		rover.printPosition(); // prints 5 1 E
		rover.setPosition(0, 0, N);
		rover.process("LLMMMLLMM"); // prints 0 2 N
		rover.printPosition();
		
	}

}
