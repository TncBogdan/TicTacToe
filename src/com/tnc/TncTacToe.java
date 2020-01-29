package com.tnc;

import java.util.Scanner;

public class TncTacToe {

    static char SYMBOL_X = 'X';
    static char SYMBOL_0 = '0';
    static char[] SYMBOL = new char[]{SYMBOL_X, SYMBOL_0};

    Player player1;
    Player player2;
    char[][] board;
    int size;

    public TncTacToe(int size, String player1, String player2) {
        this.player1 = new Player(player1, SYMBOL_X);
        this.player2 = new Player(player2, SYMBOL_0);
        this.board = new char[size][size];
        this.size = size;
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = (char) (48 + size * i + 1 + j);
            }
        }
    }

    public void showBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "    ");
            }
            System.out.println("\n");
        }
    }

    public int readPlayer(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Jucatorul " + player.name + " muta");
        return scanner.nextInt();
    }

    public void makeMove(Player player, int move) {
        int i = (move - 1) / size;
        int j = (move - 1) % size;
        board[i][j] = player.symbol;
    }

    public boolean isWinLine(Player player, int line) {
        boolean win = true;
        int i = 0;
        while (i < size && win) {
            if (board[line][i] != player.symbol) {
                win = false;
            }
            i++;
        }
        return win;
    }

    public boolean isWinCol(Player player, int col) {
        boolean win = true;
        int i = 0;
        while (i < size && win) {
            if (board[col][i] != player.symbol) {
                win = false;
            }
            i++;
        }
        return win;
    }

    public boolean winDiag1(Player player) {
        boolean win = true;
        int i = 0;
        while (i < size && win) {
            if (board[i][i] != player.symbol) {
                return false;
            }
            i++;
        }
        return win;
    }
}
