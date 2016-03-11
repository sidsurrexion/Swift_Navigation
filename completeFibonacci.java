import java.util.*;
import java.math.BigInteger;
public class completeFibonacci {

	public static void main(String[] args) {
		// Computing Fibonacci Sequence 
		System.out.println("Enter the Fibonacci Index: ");
		Scanner scanner = new Scanner(System.in);
		int fibonacciIndex = scanner.nextInt();
		
		final int firstIndexValue = 0;
		final int secondIndexValue = 1;
		
		BigInteger[] fibonacciMatrix = new BigInteger[fibonacciIndex + 1];
		
		for (int i = 0; i <= fibonacciIndex; i++){			
			if (i == 0){
				fibonacciMatrix[0] = BigInteger.valueOf(firstIndexValue);
			} else if (i == 1){
				fibonacciMatrix[1] = BigInteger.valueOf(secondIndexValue);
			} else {
				fibonacciMatrix[i] = fibonacciMatrix[i-1];
				fibonacciMatrix[i] = fibonacciMatrix[i].add(fibonacciMatrix[i-2]);			
			}
		}
		
		computeFizzBuzzForAll(fibonacciMatrix, fibonacciIndex);
		computeFizzBuzzLastIndex(fibonacciMatrix[fibonacciIndex]);
		scanner.close();
	}
	
	// Compute Prime Number
	private static boolean isPrime (BigInteger biginteger){
		
		BigInteger bigintegerLoop = BigInteger.valueOf(2);
		BigInteger[] bigInteger;
		
		if (biginteger.equals(BigInteger.valueOf(0))
				|| biginteger.equals(BigInteger.valueOf(1))){
			return false;
		}
		
		while(biginteger.max(bigintegerLoop.multiply(BigInteger.valueOf(2))) == biginteger){
			bigintegerLoop = bigintegerLoop.add(BigInteger.valueOf(1));
			bigInteger = biginteger.divideAndRemainder(bigintegerLoop);
			if (bigInteger[1].intValue() == 0){
				return false;
			}			
		}
		
		return true;
	}
	
	// Fizz Buzz Test on the Fibonacci Array
	private static void computeFizzBuzzForAll(BigInteger[] fibonacciMatrix, int fibonacciIndex){
		
		for (int i = 0; i <= fibonacciIndex; i++){
			boolean isDivisible = false;
			BigInteger[] bigValue = fibonacciMatrix[i].divideAndRemainder(BigInteger.valueOf(3));
			if (bigValue[1].intValue() == 0
					&& (fibonacciMatrix[i].max(BigInteger.valueOf(3)) == fibonacciMatrix[i])
					|| fibonacciMatrix[i].equals(BigInteger.valueOf(3))){
				System.out.println("Buzz");
				isDivisible = true;
			}
			
			if (!isDivisible){
				bigValue = fibonacciMatrix[i].divideAndRemainder(BigInteger.valueOf(5));
				if (bigValue[1].intValue() == 0
						&& (fibonacciMatrix[i].max(BigInteger.valueOf(5)) == fibonacciMatrix[i])
						|| fibonacciMatrix[i].equals(BigInteger.valueOf(5))){
					System.out.println("Fizz");
					isDivisible = true;
				}
			}
			
			if (!isDivisible){
				if (isPrime(fibonacciMatrix[i])){
					System.out.println("BuzzFizz");
				} else {
					System.out.println(fibonacciMatrix[i]);
				}
			}
		
		}
		
	}
	
	// Fizz Buzz Test on the Fibonacci Index
	private static void computeFizzBuzzLastIndex (BigInteger biginteger){
		boolean isDivisible = false;
		BigInteger[] bigValue = biginteger.divideAndRemainder(BigInteger.valueOf(3));
		if (bigValue[1].intValue() == 0
				&& (biginteger.max(BigInteger.valueOf(3)) == biginteger)
				|| biginteger.equals(BigInteger.valueOf(3))){
			System.out.println("Buzz");
			isDivisible = true;
		}
		
		if (!isDivisible){
			bigValue = biginteger.divideAndRemainder(BigInteger.valueOf(5));
			if (bigValue[1].intValue() == 0
					&& (biginteger.max(BigInteger.valueOf(5)) == biginteger)
					|| biginteger.equals(BigInteger.valueOf(5))){
				System.out.println("Fizz");
				isDivisible = true;
			}
		}
		
		
		if (!isDivisible){
			if (isPrime(biginteger)){
				System.out.println("BuzzFizz");
			} else {
				System.out.println(biginteger);
			}
		}
	}
	
}
