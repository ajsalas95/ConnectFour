import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame{
	private int theGridSize;
	private int theLinks;
	private JFrame theFrame;
	private int[][] board;
	private JButton[][] circles;
	private int player;
	private JButton[] buttons;
	
	public Board(int gridSize, int links){
		buttons = new JButton[gridSize];
		player = 1;
		theGridSize = gridSize;
		theLinks = links;
		theFrame = new JFrame("Connect Four");
		board = new int[gridSize][gridSize];
		circles = new JButton[gridSize][gridSize];
		for(int i=0;i<gridSize; i++){
			for(int j =0; j<gridSize; j++){
				board[i][j] = 0;
				circles[i][j] = new JButton(new Circle());
				circles[i][j].setContentAreaFilled(false);
				circles[i][j].setOpaque(true);
				circles[i][j].setBackground(Color.YELLOW);
				circles[i][j].setBorderPainted(false);
			}
		}
	}
	
	/**
	 * unwinnable- reports a message that has a winning link that is larger than the grid size
	 */
	public void unwinnable(){
		theFrame = new JFrame("UNWINNABLE GAME");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new FlowLayout());
		theFrame.add(new JLabel("It appears the number of connections or links you entered to win is larger than the possible connections in the board size."));
		theFrame.add(new JLabel(" Please close the program and try again with a board size that is equal to or greater than the connection size."));
		theFrame.pack();
		theFrame.setVisible(true);
	}
	/**
	 * mismatchArguments-reports a message when there is an incorrect number of arguments
	 */
	public void mismatchArguments(){
		theFrame = new JFrame("Wrong Arguments");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new FlowLayout());
		theFrame.add(new JLabel("It appears that you either have too many or too few arguemnts "));
		theFrame.add(new JLabel("You need two arguments: grid size and winning link size"));
		theFrame.pack();
		theFrame.setVisible(true);
	}
	
	/**
	 * unplayable- reports a message when there is a to big or too small board size
	 */
	public void unplayable(){
		theFrame = new JFrame("UNPLAYABLE GAME");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new FlowLayout());
		theFrame.add(new JLabel("Sorry but the values you entered to make the board are not supported. Please close the program and try again with reasonable values."));
		theFrame.pack();
		theFrame.setVisible(true);
	}
	
	/**
	 * drawBoard- draws the connect 4 board
	 */
	public void drawBoard(){
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(theGridSize+1,theGridSize);
		theFrame.setLayout(layout);
		drawTopButtons(theGridSize);
		drawGrid(theGridSize * theGridSize);
		theFrame.pack();
		theFrame.setVisible(true);	
	}
	
	/**
	 * drawBoard- draws the user input buttons
	 * @param the row size
	 */
	public void drawTopButtons(int rowSize) {
		class buttonTracker implements ActionListener{
				private int theLocation;
				public buttonTracker(int location){
				theLocation = location;
			}
				
			/**
			 * actionPerformed- changes the game pieces when there is a move
			 * @param the action event
			 */
			public void actionPerformed(ActionEvent e) {
					boolean filled = false;
					int i = board.length-1;
					if( e.getSource() instanceof JButton) {
						while(!filled && i>=0 ){
								if(board[i][theLocation]==0){
									if(player % 2 == 0){
										circles[i][theLocation].setIcon(new RedCircle());
										board[i][theLocation] = 2;
										filled = true;
										player = player + 1;
									}
								else{
										circles[i][theLocation].setIcon(new BlackCircle());
										board[i][theLocation] = 1;
										filled = true;
										player = player + 1;
								}
						}
								i--;
								Checker check = new Checker(board, theLinks);
								if(check.checkWinner()){
									endGame();
								}
								
								if(check.checkTie()){
									tieGame();
								}
						}
					}
			}
		}
			
		for(int i =0; i<rowSize; i++){
				buttons[i] = new JButton("DROP HERE");
				buttons[i].addActionListener(new buttonTracker(i));
				theFrame.add(buttons[i]);
			}
	}

	/**
	 * endGame-ends the game when there is a winner
	 */
	public void endGame() {
		
		JFrame winner = new JFrame("WINNER");
		winner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		winner.setLayout(new FlowLayout());
		
		if(player % 2 == 0){
			winner.add(new JLabel("We Have a Winner Player Black"));
		}
		else{
			winner.add(new JLabel("We Have a Winner Player RED"));
		}
		
		for(int i = 0; i < buttons.length;i++){
			theFrame.getContentPane().remove(buttons[i]);
		}
		
		winner.pack();
		winner.setVisible(true);
	}
	
	/**
	 * tieGame- ends the game when there is a tie
	 */
	public void tieGame() {
		for(int i = 0; i < buttons.length;i++){
			theFrame.getContentPane().remove(buttons[i]);
		}
		JFrame tie = new JFrame("Tie Game");
		tie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tie.setLayout(new FlowLayout());
		tie.add(new JLabel("We Have a Tie Game"));
		tie.pack();
		tie.setVisible(true);
	}
	
	/**
	 * drawGrid- draws the connect 4 board
	 * @param the board size
	 */
	public void drawGrid(int gridSize) {
		
		for(int i=0;i<theGridSize; i++){
			for(int j =0; j<theGridSize; j++){
				theFrame.add(circles[i][j]);
			}
		}		
	}
}