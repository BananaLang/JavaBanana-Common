package io.github.bananalang;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

import io.github.bananalang.common.ByteCodeFile;
import io.github.bananalang.common.ByteCodes;
import io.github.bananalang.common.NoCollisionsConstantTable;
import io.github.bananalang.common.constants.CharsConstant;
import io.github.bananalang.common.constants.DoubleConstant;
import io.github.bananalang.common.constants.IntegerConstant;
import io.github.bananalang.common.constants.StringConstant;

public class ByteCodeFileTest {
    public static void main(String[] args) throws IOException {
        ByteCodeFile bbc = new ByteCodeFile();
        NoCollisionsConstantTable constantTable = new NoCollisionsConstantTable();
        constantTable.add(new IntegerConstant(BigInteger.valueOf(504)));
        constantTable.add(new DoubleConstant(35.2));
        constantTable.add(new CharsConstant(" is a number"));
        constantTable.add(new StringConstant(2));
        bbc.getConstantTable().addAll(constantTable.getTable());
        bbc.putLoadConstant(0);
        bbc.putLoadConstant(1);
        bbc.putCode(ByteCodes.MUL);
        bbc.putLoadConstant(3);
        bbc.putCode(ByteCodes.ADD);
        bbc.putCode(ByteCodes.DEBUG_PRINT);
        bbc.putCode(ByteCodes.POP);
        bbc.write("example.bbc");

        ByteCodeFile bbc2 = ByteCodeFile.read("example.bbc");
        System.out.println(bbc.getConstantTable().equals(bbc2.getConstantTable()) && Arrays.equals(bbc.getBytecode(), bbc2.getBytecode()));

        bbc.disassemble();
    }
}
