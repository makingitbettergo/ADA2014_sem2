package lab2;

import java.math.BigInteger;
import java.util.Random;

public class FermatLittleTheorem {

	public static boolean checkPrime(BigInteger n, int iter) {
		Random rng = new Random();
		if (n.equals(BigInteger.ONE))
			return false;
		for (int i = 0; i < iter; i++) {
			// Create an integer within the interval [1,n-1]
			BigInteger a = new BigInteger(n.bitLength(), rng);
			while (BigInteger.ONE.compareTo(a) > 0 || a.compareTo(n) >= 0) {
				a = new BigInteger(n.bitLength(), rng);
			}
			// a^(n-1)
			// Repeated until a!=1, thus proving it cannot be prime
			a = a.modPow(n.subtract(BigInteger.ONE), n);
			if (!a.equals(BigInteger.ONE))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		if (checkPrime(new BigInteger(Integer.toString(341)), 1)) {
			System.out.println("prime");
		} else {
			System.out.println("not prime");
		}
	}
}