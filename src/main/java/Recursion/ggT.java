package Recursion;

// Source Code: https://www.geeksforgeeks.org/c-program-find-gcd-hcf-two-numbers/

public class ggT {
    // Recursive function to return gcd of a and b
    static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }

    // Recursive function to return gcd of a and b
    static int gcd2(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd2(b, a % b);
    }

    // Driver method
    public static void main(String[] args)
    {
        int a = 98, b = 56;
        System.out.println("GCD of " + a +" and " + b + " is " + gcd(a, b));
    }
}
