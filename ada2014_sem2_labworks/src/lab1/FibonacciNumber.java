package lab1;

public class FibonacciNumber {

	public int fib(int n) {
		if (n < 2)
			return 1;
		else
			return fib(n - 2) + fib(n - 1);
	}

	public static void main(String[] args) {
		FibonacciNumber fn = new FibonacciNumber();
		long[] fibonaccis = new long[40];

		for (int i = 0; i < fibonaccis.length; i++) {
			fibonaccis[i] = fn.fib(i);
		}

		for (long l : fibonaccis) {
			System.out.println(l);
		}
	}
}
