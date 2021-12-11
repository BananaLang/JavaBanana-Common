package io.github.bananalang.common;

public final class ByteCodes {
    public static final short

    EOF = 0,

    DEBUG_PRINT = 1,
    LOAD_CONSTANT = 2,
    LOAD_BYTE = 3,
    LOAD_SBYTE = 4,

    ADD = 128,
    SUB = 129,
    MUL = 130,
    DIV = 131;

    // Disable instantiation
    private ByteCodes() {
    }
}
