package io.compiler.types;

public enum Types {
    NUMBER(1),
    TEXT(2);

    private final int value;

    Types(int valueNumber) {
        this.value = valueNumber;
    }

    public int getValue() {
        return this.value;
    }
}
