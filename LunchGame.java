package NewTicTack;

import java.util.*;
import java.util.Scanner;

//Board & row, col, diag, dispaly, space;
class TicTacToe{
	static char[][]board;

	public TicTacToe(){
		board=new char[3][3];
		initBoard();
	}
//Add space in table
	void initBoard() {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
			board[i][j]=' ';	
			}		
		}
	}
//	Display board
static	void dispBoard() {
		System.out.println("-------------");
		for(int i=0;i<board.length;i++) {
			System.out.print("| ");
			for(int j=0;j<board[i].length;j++) {
			System.out.print(board[i][j]+" | ");
			}	
			System.out.println();
			System.out.println("-------------");
		}
	}	
//	place mark
	static void placeMark(int row,int col,char mark) {
		if(row>=0 && row<=2 && col>=0 && col<=2)
		{
		board[row][col]=mark;
		}
		else {
			System.out.println("Invalid position");
		}
	}
//	win conditions logic
//	checkcolWin Condition
static	boolean checkColWin() {
		for(int i=0;i<=2;i++) {
			if(board[0][i] !=' '&& board[0][i]==board[1][i]&& board[1][i]==board[2][i]){
			return true;
			}
		}
		return false;
	}
//checkRow win condition logic
static 	boolean checkRowWin() {
		for(int i=0;i<=2;i++) {
			if( board[i][0]!=' '&& board[i][0]==board[i][1]&&board[i][1]==board[i][2]){
			return true;
			}
		}
		return false;
	}
//check condition Diagonal
static	boolean checkDiagWin() {
	if(board[0][0]!=' ' &&board[0][0]==board[1][1] && board[1][1]==board[2][2]
			|| board[0][2]!=' ' &&board[0][2]==board[1][1] && board[1][1]==board[2][0]) {
	return true;
	}
	else {
		return false;
	}
		
	}

static boolean checkDraw() {
	for(int i=0;i<=2;i++) {
		for(int j=0;j<=2;j++) 
		{
			if(board[i][j]==' ') 
			{
			return false;	
			}
		}
		
	}
	return true;
}
}

//Player
abstract class Player{
	String name;
	 char mark;
	
	abstract void makeMove();
	boolean isValidMove(int row ,int col) {
		if(row >=0 && row<=2 && col>=0 && col<=2)
		{
			if(TicTacToe.board[row][col]==' ') 
			{
				return true;
			}
		}
		return false;
	 }
}


// Human Class
class HumanPlayer extends Player {
//	String name;
//	char mark;
	HumanPlayer(String name,char mark){
		this.name=name;
		this. mark=mark;
	}
//makeMove method
void makeMove() {
	Scanner scan=new Scanner(System.in);
	int row;
	int col;
	do {
		
		System.out.println("Entre the row and col");
		 row=scan.nextInt();
	     col=scan.nextInt();
	}while(!isValidMove(row,col));
	TicTacToe.placeMark(row, col, mark);
	
	
}
//isValidMove method check while is empty or not
//boolean isValidMove(int row ,int col) {
//	if(row >=0 && row<=2 && col>=0 && col<=2)
//	{
//		if(TicTacToe.board[row][col]==' ') 
//		{
//			return true;
//		}
//	}
//	return false;
// }

}

//AI Player Class
class AIPlayer extends Player {
//	String name;
//	char mark;
	AIPlayer(String name,char mark){
		this.name=name;
		this. mark=mark;
	}
//makeMove method
void makeMove() {
	
	int row,col;
	do {
		Random r=new Random();
		row =r.nextInt(3);
		col =r.nextInt(3);
	}while(!isValidMove(row,col));
	TicTacToe.placeMark(row, col, mark);
	
	
}
//isValidMove method check while is empty or not
//boolean isValidMove(int row ,int col) {
//	if(row >=0 && row<=2 && col>=0 && col<=2)
//	{
//		if(TicTacToe.board[row][col]==' ') 
//		{
//			return true;
//		}
//	}
//	return false;
// }

}

public class LunchGame {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 TicTacToe t=new TicTacToe();
 HumanPlayer p1=new HumanPlayer("Bob",'0');
 AIPlayer p2=new  AIPlayer("AI",'o');

 
 Player cp;
 cp=p1;
 while(true) {
	 System.out.println(cp.name+"turn");
	 cp.makeMove();
	 TicTacToe.dispBoard();
	 if(TicTacToe.checkColWin()||TicTacToe.checkRowWin() || TicTacToe.checkDiagWin()) 
	 {
		 System.out.println(cp.name+"has win");
		 break;
	 }
	 else if(TicTacToe.checkDraw()) {
		 System.out.println("Game is draw");
		 break;
	 }
	 else {
		 if(cp==p1)
		 {
			cp=p2; 
		 }else 
		 {
			 cp=p1;
		 }
	 }
 }
 
	}

}
