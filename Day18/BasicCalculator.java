package Day18;

import java.util.Scanner;
import java.util.Stack;

class Solution{
    public int calculator(String s){
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                number = ch - '0';
                    while((i+1) < s.length() && Character.isDigit(s.charAt(i+1))){
                        number = number * 10 + (s.charAt(++i) -'0');
                    }
                result = result + sign *number ;
            }else if(ch == '+'){
                sign = 1;
            }else if(ch == '-'){
                sign = -1;
            }else if(ch == '('){
                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }else if(ch == ')'){
                int prevSign = stack.pop();
                int prevResult = stack.pop();

                result = prevResult + prevSign * result;
            }
        }
        return result;
    }
}

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution ob = new Solution();
        int result = ob.calculator(str);
        System.out.println(result);
        sc.close();
    }
}
