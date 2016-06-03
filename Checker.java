
public class Checker {
	private int[][] board;
	private int links;
	
	public Checker(int[][] theBoard, int winningLinks){
		board = theBoard;
		links = winningLinks;
	}
	
	/**
	 * checkWinner - checks to see is there is a winner
	 * @return if there is a winner or not
	 * 
	 */
	public boolean checkWinner(){
		if(checkColumns()) return true;
		if(checkRows()) return true;
		if(checkDiagRight()) return true;
		if(checkDiagLeft()) return true;
		return false;
	}
	
	/**
	 * checkTie - checks to see if there is a tie
	 * @return if there is a tie or not
	 * 
	 */
	public boolean checkTie(){
		for(int i = 0; i <board.length; i++){
			for(int j = 0; j<board.length; j++){
				if(board[i][j]==0) return false;
			}
		}
		
		return true;
	}
	
	/**
	 * checkRows- checks the rows of the board for a winning link
	 * @return if there is a winning link horizontally
	 * 
	 */
	public boolean checkRows(){
		boolean firstElement = true;
		int count =0;
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length-1; j++){
				if(firstElement){
					count++;
					firstElement = false;
				}
				if((board[i][j]==board[i][j+1]) && (board[i][j]!=0) && (board[i][j+1]!=0)){
					count++;
				}				
				else{
					if(count == links){
						return true;
					}
					firstElement = true;
					count = 0;
				}
				if(count == links){
					return true;
				}
			}
			firstElement = true;
			count = 0;
		}
		return false;
	}
	
	/**
	 * checkColumns - checks the columns for a winning link
	 * @return if there is a winner going vertically
	 */
	public boolean checkColumns(){
		boolean firstElement = true;
		int count =0;
		
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board.length-1; j++){
				if(firstElement){
					count++;
					firstElement = false;
				}
				if((board[j][i]==board[j+1][i]) && (board[j][i]!=0) && (board[j+1][i]!=0)){
					count++;
				}
				else{
					if(count == links){
						return true;
					}
					firstElement = true;
					count = 0;
				}
				if(count == links){
					return true;
				}
			}
			firstElement = true;
			count = 0;
		}
		return false;
	}
	
	/**
	 * checkDiagRight- checks for a winning link going \
	 * @return if there is a winner going \
	 * 
	 */
	public boolean checkDiagRight(){
		int count =0;
		int i =0;
		int j =0;
				
		for(i =0; i<board.length; i++){
			j=0;
			if(board[i][j]!=0) count =1;
			while(j<board.length){
				int x = i;
				int y = j;
				if(count==0 && board[i][j] !=0) count =1;
				while(j<board.length-1 && i<board.length-1){
					if(board[i][j] == board[i+1][j+1]&& board[i][j]!=0 && board[i+1][j+1]!=0){
						count++;
						if(count == links) return true;
				}
				
				else if(board[i][j]==0 || board[i+1][j+1]==0) {
					if(count == links) return true;
					count =0;
				}
				else if (board[i+1][j+1]!=0) {
					if(count == links) return true;
					count =1;
				}
				i++;
				j++;
			}
			i = x;
			j = y+1;
			count =0;
		}
		}
		return false;
	}

	/**
	 * checkDiagRight- checks for a winning link going /
	 * @return if there is a winner going /
	 * 
	 */
	public boolean checkDiagLeft(){
		int count =0;
		int i =0;
		int j =0;
		
		for(i =board.length-1; i>=0; i--){
			j =0;
			if(board[i][j]!=0) count =1;
			while(j<board.length){
				int x = i;
				int y = j;
				if(count==0 && board[i][j] !=0) count =1;
				while(j<board.length-1 && i>0){
					if(board[i][j] == board[i-1][j+1]&& board[i][j]!=0 && board[i-1][j+1]!=0){
						count++;
						if(count == links) return true;
				}
				
				else if(board[i][j]==0 || board[i-1][j+1]==0) {
					if(count == links) return true;
					count =0;
				}
				else if (board[i-1][j+1]!=0) {
					if(count == links) return true;
					count =1;
				}
				i--;
				j++;
			}
			
			i = x;
			j = y+1;
			count =0;
		}
		}
		return false;
	}
}

