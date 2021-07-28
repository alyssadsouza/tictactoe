package main.java.ticTacToe;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class TicTacToeApplication extends Application {

    private String turn;
    private TicTacToeBoard board;
    private boolean gameOver;

    @Override
    public void start(Stage window) {
        // Current turn
        this.turn = "X";
        this.board = new TicTacToeBoard();
        this.gameOver = false;

        // Create the turn label and grid for the board
        Label turnLabel = new Label("Turn: " + this.turn);
        GridPane grid = new GridPane();

        // Make the grid 3x3
        for (int x = 1; x <= 3; x++) {
            for (int y = 1; y <= 3; y++) {
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));

                // When the button is clicked, play
                btn.setOnAction(event -> {
                    play((Node) event.getSource(), btn, turn, turnLabel, grid);
                });
                
                grid.add(btn, x, y);
            }
        }

        // Add both components
        BorderPane layout = new BorderPane();
        layout.setTop(turnLabel);
        layout.setCenter(grid);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    public void play(Node node, Button btn, String turn, Label turnLabel, GridPane grid) {
        if (this.gameOver == true) {
            return;
        }
        int row = grid.getRowIndex(node) - 1;
        int column = grid.getColumnIndex(node) - 1;
        
        this.turn = board.play(turn, row, column);
        turnLabel.setText("Turn: " + this.turn);
        btn.setText(turn);
        
        if (board.isWinner(turn)) {
            turnLabel.setText("Winner: " + turn);
            this.gameOver = true;
        }
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }
}