public class ArmstrongNumbers {
    public static void main(String[] args) {
    	
        for (int i = 100; i <= 1000; i++) {
        	
            if (isArmstrongNumber(i)) {
            	
                System.out.println(i);
            }
        }
    }

    private static boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int result = 0;
        int n = String.valueOf(number).length();

        while (number != 0) {
            int remainder = number % 10;
            result += Math.pow(remainder, n);
            number /= 10;
        }

        return originalNumber == result;
    }
}






