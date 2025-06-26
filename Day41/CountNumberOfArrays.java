package Day41;  //problem 3405. Count the Number of Arrays with K Matching Adjacent Elements
import java.util.Scanner;

class Solution {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];
    static {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[MAX - 1] = modInverse(fact[MAX - 1]);
        for (int i = MAX - 2; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }
    static long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
    static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return (((fact[n] * invFact[k]) % MOD) * invFact[n - k]) % MOD;
    }
    public int countGoodArrays(int n, int m, int k) {
        long ways = comb(n - 1, k);
        ways = (ways * m) % MOD;
        ways = (ways * modPow(m - 1, n - 1 - k)) % MOD;
        return (int) ways;
    }
}

public class CountNumberOfArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        Solution ob = new Solution();
        int result = ob.countGoodArrays(n, m, k);
        System.out.println(result);
    }
    
}
