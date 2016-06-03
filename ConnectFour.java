
public class ConnectFour {

	public static void main(String[] args) {
		int gridSize = 0; //size of the board
		int links = 0;	//size of the winning link
		
		if(args.length != 2){		//checks if there are the right amount of arguments
			Board board = new Board(0,0);
			board.mismatchArguments();
		}
		//checks to make sure there is a valid board size and winning link size
		else if(Integer.parseInt(args[0]) > 20 || Integer.parseInt(args[0])<3 || Integer.parseInt(args[1])<3){
			Board board = new Board(0,0);
			board.unplayable();
		}
		//checks to make sure the winning links is less than the board size
		else if(Integer.parseInt(args[0]) < Integer.parseInt(args[1])){
			Board board = new Board(0,0);
			board.unwinnable();
		}
		// game begins
		else{
			gridSize = Integer.parseInt(args[0]);
			links = Integer.parseInt(args[1]);
			if(links == 1){
				
			}
			Board board = new Board(gridSize, links);
			board.drawBoard();
		}
	}

}
