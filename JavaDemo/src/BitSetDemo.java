/*
* 一个Bitset类创建一种特殊类型的数组来保存位值。BitSet中数组大小会随需要增加。这和位向量（vector of bits）比较类似。
这是一个传统的类，但它在Java 2中被完全重新设计。
* */

import java.util.BitSet;

public class BitSetDemo {
    BitSetDemo() {
        // 创建BitSet实例 指定初始大小为16
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);

        for (int i = 0; i < 16; i++) {
            if ((i % 2) == 0)  bits1.set(i);
            if ((i % 5) == 0) bits2.set(i);
        }
        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("\n Initial pattern in bits2: ");
        System.out.println(bits2);

        // AND bits
        bits2.and(bits1);
        System.out.println("\n bits2 AND bits1: ");
        System.out.println(bits2);

        // OR bits
        bits2.or(bits1);
        System.out.println("\n bits2 OR bots1: ");
        System.out.println(bits2);

        // XOR bits
        bits2.xor(bits1);
        System.out.println("\n bits2 XOR bits1: ");
        System.out.println(bits2);
    }
}
