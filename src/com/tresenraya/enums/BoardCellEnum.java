package com.tresenraya.enums;

public enum BoardCellEnum {
    EMPTY(" ", 0),
    X("X", 1),
    O("O", -1);

    private String identifier;
    private int value;

    BoardCellEnum(String identifier, int value) {
        this.identifier = identifier;
        this.value = value;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return identifier;
    }
}
