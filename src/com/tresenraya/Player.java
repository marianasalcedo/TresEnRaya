package com.tresenraya;


import com.tresenraya.enums.BoardCellEnum;

public class Player {
    private static final int MAX_PIECES = 3;

    private String playerName;
    private int piecesNumber;
    private BoardCellEnum cellIdentifier;

    public Player(String playerName, BoardCellEnum cellIdentifier) {
        this.playerName = playerName;
        this.cellIdentifier = cellIdentifier;
    }

    public Boolean canSetPieces() {
        return piecesNumber < MAX_PIECES;
    }

    public void addPiece() {
        this.piecesNumber++;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPiecesNumber() {
        return piecesNumber;
    }

    public BoardCellEnum getCellIdentifier() {
        return cellIdentifier;
    }

    public void setCellIdentifier(BoardCellEnum cellIdentifier) {
        this.cellIdentifier = cellIdentifier;
    }

    public String toString() {
        return playerName;
    }

}
