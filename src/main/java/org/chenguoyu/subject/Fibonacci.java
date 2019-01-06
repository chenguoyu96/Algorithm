package org.chenguoyu.subject;

public class Fibonacci {
    public int Fibonacci(int n) {
        if (n <= 2) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

}
