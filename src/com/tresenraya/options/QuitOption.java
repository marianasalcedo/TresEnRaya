package com.tresenraya.options;

import com.tresenraya.Board;
import com.tresenraya.Player;

public class QuitOption implements Option {


    @Override
    public Boolean execute(Player player, Board board) {
        System.exit(0);
        return true;
    }

    @Override
    public String toString() {
        return "Quit";
    }

}
