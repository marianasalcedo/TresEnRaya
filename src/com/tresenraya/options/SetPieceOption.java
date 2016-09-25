package com.tresenraya.options;


import com.tresenraya.Board;
import com.tresenraya.Coordinate;
import com.tresenraya.Player;

import java.util.Scanner;

public class SetPieceOption implements Option {

    public Coordinate promptInput() {
        System.out.println("Please input the row and column on the format 'row,column':");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] coordinates = input.trim().split(",");
        return new Coordinate(Integer.parseInt(coordinates[0].trim()), Integer.parseInt(coordinates[1].trim()));
    }


    @Override
    public Boolean execute(Player player, Board board) {
        if ( player.canSetPieces() ) {
            if (board.setPiece(promptInput(), player)) {
                return true;
            } else {
                System.out.println("You entered an invalid cell, please try again.");
            }
        } else {
            System.out.println("You cannot set more pieces, please select another option.");
        }
        return false;
    }

    @Override
    public String toString() {
        return "Set a piece on the board";
    }
}
