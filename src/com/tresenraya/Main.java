package com.tresenraya;

import com.tresenraya.enums.BoardCellEnum;
import com.tresenraya.options.Option;
import com.tresenraya.utils.GameUtils;

public class Main {

    public static void main(String[] args) {
        Boolean firstPlayerTurn = true;
        Player player1 = new Player("Player 1 (X piece)", BoardCellEnum.X);
        Player player2 = new Player("Player 2 (O piece)", BoardCellEnum.O);
        Board board = new Board();
        GameUtils.printInstructions();
        while (true) {
            board.printBoard();
            Player player = firstPlayerTurn ? player1 : player2;
            Option option = GameUtils.displayOptions(player);
            if ( option.execute(player, board) ) {
                firstPlayerTurn = !firstPlayerTurn;
            }
            if ( board.gameFinished(player1, player2) ) {
                break;
            }
        }
    }
}
