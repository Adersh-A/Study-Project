package com.adersh.RPS;

import java.util.Random;
import java.util.Scanner;

public class RPS {

	static int userPoint = 0;
	static int cmpPoint = 0;
	static boolean flag = true;

	public static void main(String[] args) {

		String[] rps = { "rock", "paper", "scissor" };

		Scanner inp = new Scanner(System.in);

		while (flag) {

		System.out.println("r : Rock");
		System.out.println("p : paper");
		System.out.println("s : scissor");
		System.out.println("Enter your choice:");
//		System.out.println();

		char choice = inp.next().charAt(0);
		String usrChoice = getChoice(choice);
		if (usrChoice.equals("Wrong Choice")) {
			System.out.println("Enter a valid input!!");
			continue;
		}
		Random r = new Random();
		String cmpChoice = rps[r.nextInt(3)];
		play(usrChoice, cmpChoice);


	}
	inp.close();

	}

	public static void play(String usr, String cmp) {

		if (!(usr.equals(cmp))) {
			if (usr.equals("rock") && cmp.equals("paper")) {
				cmpPoint += 1;
				checkWinner();
			} else if (usr.equals("rock") && cmp.equals("scissor")) {
				userPoint += 1;
				checkWinner();
			} else if (usr.equals("paper") && cmp.equals("rock")) {
				userPoint += 1;
				checkWinner();
			} else if (usr.equals("paper") && cmp.equals("scissor")) {
				cmpPoint += 1;
				checkWinner();
			} else if (usr.equals("scissor") && cmp.equals("rock")) {
				cmpPoint += 1;
				checkWinner();
			} else if (usr.equals("scissor") && cmp.equals("paper")) {
				userPoint += 1;
				checkWinner();
			}

			System.out.format("You Choose: %s | Computer Choose: %s %n", usr, cmp);
			System.out.println("-----Score Board-------");
			System.out.format("User : %d | Computer : %d %n", userPoint, cmpPoint);
		} else {
			System.out.format("You Choose: %s | Computer Choose: %s %n", usr, cmp);
			System.out.println("oops... No Score");
			System.out.println("-----Score Board-------");
			System.out.format("User : %d | Computer : %d %n", userPoint, cmpPoint);
		}
	}



	public static void checkWinner() {
		if (userPoint >= 5) {
			System.out.println("yay!! User Wins....");
			flag = false;
		} else if (cmpPoint >= 5) {
			System.out.println("yay!! Computer Wins....");
			flag = false;
		}
	}

	public static String getChoice(char c) {
		
		switch(c) {
		case 'r': return "rock";
		case 'p': return "paper";
		case 's': return "scissor";
		default:
			return "Wrong Choice";
		}
	}
}
