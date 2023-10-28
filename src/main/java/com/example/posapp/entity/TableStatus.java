package com.example.posapp.entity;

public enum TableStatus {
    AVAILABLE, OCCUPIED, PAID;

    public TableStatus getNextValue() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}