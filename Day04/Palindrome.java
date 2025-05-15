package Day04;
import java.util.Scanner;
class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        int sum=0;
        if(x<0){
            return false;
        };
        while(x>0){
           int r = x%10;
           sum = sum*10+r; 
           x= x/10;
        }
        return temp == sum;    
    } 
}

public class Palindrome{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
    }
}