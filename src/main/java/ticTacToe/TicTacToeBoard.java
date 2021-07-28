package main.java.ticTacToe;

//import java.util.Arrays;
import java.util.ArrayList;

public class TicTacToeBoard {
    private String[][] board;

    public TicTacToeBoard() {
        this.board = new String[][]{{"","",""},{"","",""},{"","",""}};
    }

    public String play(String marker, int row, int column) {
        // returns marker for next turn
        
        if (this.board[row][column].equals("")) {
            this.board[row][column] = marker;

            if (marker.equals("X")) {
                return "O";
            } else {
                return "X";
            }
        }

        return marker;
    }

    public boolean isWinner(String marker) {
        // Check horizontal wins
        if (
            this.board[0][0].equals(marker) && this.board[0][1].equals(marker) && this.board[0][2].equals(marker) ||
            this.board[1][0].equals(marker) && this.board[1][1].equals(marker) && this.board[1][2].equals(marker) ||
            this.board[2][0].equals(marker) && this.board[2][1].equals(marker) && this.board[2][2].equals(marker)
        ) {return true;} 

        // Check vertical wins
        else if (
            this.board[0][0].equals(marker) && this.board[1][0].equals(marker) && this.board[2][0].equals(marker) ||
            this.board[0][1].equals(marker) && this.board[1][1].equals(marker) && this.board[2][1].equals(marker) ||
            this.board[0][2].equals(marker) && this.board[1][2].equals(marker) && this.board[2][2].equals(marker)
        ) {return true;} 

        // Check diagonal wins
        else if (
            this.board[0][0].equals(marker) && this.board[1][1].equals(marker) && this.board[2][2].equals(marker) ||
            this.board[0][2].equals(marker) && this.board[1][1].equals(marker) && this.board[2][0].equals(marker)
        ) {return true;}

        return false;
    }

    public String toString() {
        ArrayList<ArrayList<String>> rows = new ArrayList<>();
        
        for (int y=0; y<3; y++) {
            ArrayList<String> row = new ArrayList<>();

            for (int x=0; x<3; x++) {
                row.add(this.board[y][x]);
            }

            rows.add(row);
        }
        
        // Print each row on a new line
        return rows.get(0).toString() + "\n" + rows.get(1).toString() + "\n" + rows.get(2).toString();
    }

}