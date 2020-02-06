package com.tnc;

import java.util.Scanner;

public class TncTacToe {

    static char SYMBOL_X = 'X';
    static char SYMBOL_0 = '0';

    Player player1;
    Player player2;
    private char[][] board;
    private int size;

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
                System.out.print(board[i][j] + "  |  ");
            }
            System.out.println("\n" + "....................");
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

    public boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }

    public boolean isWinLine() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinCol() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinDiag1() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[1][1], board[2][2])) {
                return true;
            }
        }
        return false;
    }

    public boolean isWinDiag2() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][2], board[1][1], board[i][2])) {
                return true;
            }
        }
        return false;
    }

    public boolean isWin() {
        return isWinLine() || isWinCol() || isWinDiag1() || isWinDiag2();
    }

    public void playGame() {

        int nrMoves = 0;
        Player currentPlayer = player1;
        boolean win = false;
        while (nrMoves < (size * size) && !win) {

            int move = readPlayer(currentPlayer);
            makeMove(currentPlayer, move);
            nrMoves++;

            showBoard();
            //nu testeaza primele 4 mutari in 3 * 3
            if (nrMoves >= 2 * size - 1) {
                win = isWin();
            }
            if (!win) {
                //schimb jucatorii
                if (currentPlayer == player1) {
                    currentPlayer = player2;
                } else {
                    currentPlayer = player1;
                }
            }
        }
        if (!win) {
            System.out.println("remiza");
        } else {
            System.out.println("castigator: " + currentPlayer.name);
        }
    }
}
