package com.tresenraya.options;


import com.tresenraya.Board;
import com.tresenraya.Player;

public interface Option {
    Boolean execute(Player player, Board board);
    String toString();
}
