package Recursion;

public class Factorial {
    // method to find factorial of given number
    static int factorial_rec(int n)
    {
        if (n == 0)
            return 1;

        return n * factorial_rec(n - 1);
    }

    static int factorial_it(int n ){
        // Method to find factorial of the given number
            int res = 1, i;
            for (i = 2; i <= n; i++)
                res *= i;
            return res;
        }


    static int factorial_it_while(int n){
        if(n == 0){
            return 1;
        }
        int i = n, fact = 1;
        while (n / i != n){
            fact = fact * i;
            i--;
        }
        return fact;
    }

    // Driver method
    public static void main(String[] args)
    {
        int num = 5;
        System.out.println(
                "Factorial of " + num
                        + " is " + factorial_rec(5));

        System.out.println("The iterative factorial of " + num + " also is " + factorial_it(num));

        System.out.println("The same goes for the factorial calculated by useing a while loop: "
        + factorial_it_while(num));

    }
}
