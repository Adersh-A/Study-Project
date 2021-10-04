package tictactoe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class tictactoe {
	
	static ArrayList<Integer> playerpos = new ArrayList<>();
	static ArrayList<Integer> computerpos = new ArrayList<>();

	public static void main(String[] args) {

		
		Scanner inp = new Scanner(System.in);
		boolean flag = true;
		char[][] board = { { '1', '|', '2', '|', '3' },
				{ '-', '+', '-', '+', '-' },
				{ '4', '|', '5', '|', '6' },
				{ '-', '+', '-', '+', '-' },
				{ '7', '|', '8', '|', '9' }
		};
		printBoard(board);
		while (flag) {

			System.out.println("Enter X (1-9): [10 to exit]");
		int val = inp.nextInt();

		if (val == 10) {
//			flag = false;
//			continue;
			return;
		}
		while (playerpos.contains(val) || computerpos.contains(val)) {
			System.out.println("sorry already taken!!!");
			val = inp.nextInt();
		}
		putXO(val, board, "user");
		if (checkWinner(board, 'X')) {
			System.out.println("User Wins!!!!");
			return;
		}

		Random r = new Random();
		int cmppos = r.nextInt(9) + 1;
		while (playerpos.contains(cmppos) || computerpos.contains(cmppos)) {
			cmppos = r.nextInt(9) + 1;

		}
		putXO(cmppos, board, "cmp");
		if (checkWinner(board, 'O')) {
			System.out.println("Computer Wins!!!!");
			break;
		}

	}
	inp.close();
	}

	public static void printBoard(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	public static void putXO(int value, char[][] board, String player) {

		char symbol;
		if (player.equals("user")) {
			symbol = 'X';
			playerpos.add(value);
		} else {
			symbol = 'O';
			computerpos.add(value);
		}
		switch (value) {
		case 1:
			board[0][0] = symbol;
			break;
		case 2:
			board[0][2] = symbol;
			break;
		case 3:
			board[0][4] = symbol;
			break;
		case 4:
			board[2][0] = symbol;
			break;
		case 5:
			board[2][2] = symbol;
			break;
		case 6:
			board[2][4] = symbol;
			break;
		case 7:
			board[4][0] = symbol;
			break;
		case 8:
			board[4][2] = symbol;
			break;
		case 9:
			board[4][4] = symbol;
			break;
		}
		printBoard(board);
		System.out.println();
	}

	public static boolean checkWinner(char[][] board, char symbol) {
		if (board[0][0] == symbol && board[0][2] == symbol && board[0][4] == symbol) {
			return true;
		} else if (board[2][0] == symbol && board[2][2] == symbol && board[2][4] == symbol) {
			return true;
		} else if (board[4][0] == symbol && board[4][2] == symbol && board[4][4] == symbol) {
			return true;
		} else if (board[0][0] == symbol && board[2][0] == symbol && board[4][0] == symbol) {
			return true;
		} else if (board[0][2] == symbol && board[2][2] == symbol && board[4][2] == symbol) {
			return true;
		} else if (board[0][4] == symbol && board[2][4] == symbol && board[4][4] == symbol) {
			return true;
		} else if (board[0][0] == symbol && board[2][2] == symbol && board[4][4] == symbol) {
			return true;
		} else if (board[0][4] == symbol && board[2][2] == symbol && board[4][0] == symbol) {
			return true;
		} else {
			checkDraw();
			return false;
		}

	}

	public static void checkDraw() {
		if (playerpos.size() + computerpos.size() == 9) {
			System.out.println("Draw!!!!!");

		}
	}

}
