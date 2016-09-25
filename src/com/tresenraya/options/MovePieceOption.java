package com.tresenraya.options;

import com.tresenraya.Board;
import com.tresenraya.Coordinate;
import com.tresenraya.Player;

import java.util.Scanner;

public class MovePieceOption implements Option {

    public Coordinate promptInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] coordinates = input.trim().split(",");
        return new Coordinate(Integer.parseInt(coordinates[0].trim()), Integer.parseInt(coordinates[1].trim()));
    }

    @Override
    public Boolean execute(Player player, Board board) {
        Coordinate oldCoord = promptInput("Please input the old coordinates on the format 'row,column':");
        Coordinate newCoord = promptInput("Please input the new coordinates on the format 'row,column':");
        return board.movePiece(oldCoord, newCoord, player);
    }

    @Override
    public String toString() {
        return "Move a piece that is on the board";
    }
}
