package org.example.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class KaratsubaTest {
    private Karatsuba instance;

    @BeforeEach
    void setUp() {
        this.instance = new Karatsuba();
    }

    @Test
    void should_multiply_two_integers() {
        BigInteger multiplicand = new BigInteger("100");
        BigInteger multiplier = new BigInteger("100");
        BigInteger expected = new BigInteger("10000");

        BigInteger actual = instance.multiply(multiplicand, multiplier);

        assertEquals(expected, actual);
    }
}