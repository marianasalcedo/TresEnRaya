package com.tresenraya.utils;


import com.tresenraya.Player;
import com.tresenraya.options.MovePieceOption;
import com.tresenraya.options.Option;
import com.tresenraya.options.QuitOption;
import com.tresenraya.options.SetPieceOption;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class GameUtils {

    public static void printInstructions() {
        System.out.println("Welcome to the 'Tres en Raya' game!");
        System.out.println("Rules:");
        System.out.println("\t1) You can only have 3 pieces set on the board");
        System.out.println("\t2) Once the the pieces has been set, you can move it anywhere you want");
        System.out.println("\t3) You have won the game once you line up the three pieces together in one line, " +
                "be it horizontal, vertical or diagonal");
        System.out.println("");
    }

    public static Option displayOptions(Player player) {
        List<Option> options = new ArrayList<>();
        options.add(new SetPieceOption());
        options.add(new MovePieceOption());
        options.add(new QuitOption());
        System.out.println(player.toString() + ", these are the options that you have right now:");
        for (int i = 0; i < options.size(); i++) {
            System.out.println("\t" + i + ") " + options.get(i));
        }
        System.out.println("Please select an option:");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        while (option > options.size()) {
            System.out.println("Invalid option, please try again:");
            option = scanner.nextInt();
        }
        return options.get(option);
    }

}
