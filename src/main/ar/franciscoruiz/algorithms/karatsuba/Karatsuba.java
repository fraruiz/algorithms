package ar.franciscoruiz.algorithms.karatsuba;

import java.math.BigInteger;

/**
 * Karatsuba algorithm
 * Description: The Karatsuba algorithm is a fast multiplication algorithm that uses a divide and conquer approach to multiply two numbers.
 * <break>
 * Steps: X * Y
 * 1. A = X1 * Y1
 * 2. B = X2 * Y2
 * 3. C = (X1 + X2) * (Y1 + Y2)
 * 4. K = C - A + B
 * 5. Result = A * 10^(2m) + K * 10^M + B
 *
 */
public final class Karatsuba {
    public BigInteger multiply(BigInteger x, BigInteger y) {
        int max = Math.max(x.bitLength(), y.bitLength());

        if (max <= 100){
            return x.multiply(y);
        }

        BigInteger x1 = x.shiftRight(max);
        BigInteger y1 = y.shiftRight(max);

        BigInteger x2 = x.subtract(x1.shiftLeft(max));
        BigInteger y2 = y.subtract(y1.shiftLeft(max));

        BigInteger a = multiply(x1, y1);
        BigInteger b = multiply(x2, y2);
        BigInteger c = multiply(x1.add(x2), y1.add(y2));

        BigInteger k = c.subtract(a).add(b);

        return (a.shiftLeft(2 * max)).add((k.shiftLeft(max)).add(b));
    }
}
