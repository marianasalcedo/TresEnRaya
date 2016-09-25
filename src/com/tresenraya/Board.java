package com.tresenraya;


import com.tresenraya.enums.BoardCellEnum;

public class Board {
    private static final int BOARD_SIZE = 3;
    private BoardCellEnum board[][] = new BoardCellEnum[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                board[row][column] = BoardCellEnum.EMPTY;
            }
        }
    }

    public Boolean violatesRestrictions(Coordinate coordinate) {
        int coordX = coordinate.getCoordX();
        int coordY = coordinate.getCoordY();
        if ( coordX > BOARD_SIZE || coordY >BOARD_SIZE || board[coordX][coordY] != BoardCellEnum.EMPTY) {
            return true;
        }
        return false;
    }

    public Boolean setPiece(Coordinate coordinate, Player player) {
        if ( violatesRestrictions(coordinate) ) {
            return false;
        }

        board[coordinate.getCoordX()][coordinate.getCoordY()] = player.getCellIdentifier();
        player.addPiece();
        return true;
    }

    public Boolean movePiece(Coordinate oldCoord, Coordinate newCoord, Player player) {
        if ( violatesRestrictions(newCoord) ) {
            return false;
        }

        if ( oldCoord.getCoordX() > BOARD_SIZE || oldCoord.getCoordY() >BOARD_SIZE || board[oldCoord.getCoordX()][oldCoord.getCoordY()] != player.getCellIdentifier()) {
            return false;
        }

        board[newCoord.getCoordX()][newCoord.getCoordY()] = player.getCellIdentifier();
        board[oldCoord.getCoordX()][oldCoord.getCoordY()] = BoardCellEnum.EMPTY;
        return true;
    }

    public void printBoard() {
        System.out.println("   0    1    2");
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.print(row + " ");
            for (int column = 0; column < BOARD_SIZE; column++) {
                if ( column != (BOARD_SIZE-1) ) {
                    System.out.print(" " + board[row][column].toString() + " | ");
                } else {
                    System.out.println(" " + board[row][column].toString());
                }
            }
            if ( row != (BOARD_SIZE-1) ) {
                System.out.println("  -------------");
            }
        }
        /* This empty line is only for formatting */
        System.out.println("");
    }

    public Boolean gameFinished(Player player1, Player player2) {
        int sumOfRow=0;
        int sumOfColumns=0;
        int sumOfPrimaryDiagonal=0;
        int sumOfSecondaryDiagonal=0;
        Player winningPlayer = null;
        for (int row = 0; row < BOARD_SIZE; row++) {
            sumOfRow = 0;
            sumOfColumns = 0;
            for (int column = 0; column < BOARD_SIZE; column++) {
                sumOfRow = sumOfRow + board[row][column].getValue();
                sumOfColumns = sumOfColumns + board[column][row].getValue();
            }
            sumOfPrimaryDiagonal = sumOfPrimaryDiagonal + board[row][row].getValue();
            sumOfSecondaryDiagonal = sumOfPrimaryDiagonal + board[row][BOARD_SIZE - row - 1].getValue();

            if (sumOfRow == 3 || sumOfColumns == 3) {
                winningPlayer = player1;
                break;
            }

            if (sumOfRow == -3 || sumOfColumns == -3) {
                winningPlayer = player2;
                break;
            }
        }

        if (sumOfPrimaryDiagonal == 3 || sumOfPrimaryDiagonal == 3) {
            winningPlayer = player1;
        }

        if (sumOfSecondaryDiagonal == -3 || sumOfSecondaryDiagonal == -3) {
            winningPlayer = player2;
        }

        if ( winningPlayer != null ) {
            System.out.println(winningPlayer.getPlayerName() + " has Won!");
            return true;
        }

        return false;
    }
}
