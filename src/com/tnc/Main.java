package com.tnc;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jucatorul 1 este ");
        String player1 = scanner.nextLine();
        System.out.println("Jucatorul 2 este ");
        String player2 = scanner.nextLine();

        TncTacToe tncTacToe = new TncTacToe(3, player1, player2);
        tncTacToe.showBoard();
        tncTacToe.playGame();
    }
}
