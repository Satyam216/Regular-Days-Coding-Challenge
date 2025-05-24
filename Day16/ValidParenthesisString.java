package Day16;   //problem 678
import java.util.Scanner;
import java.util.Stack;

class Solution{
    public static boolean validParenthesis(String str){
        Stack<Integer> FirstStack = new Stack<>();
        Stack<Integer> StarStack = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                FirstStack.push(i);
            }else if(c == '*'){
                StarStack.push(i);
                }else{      // for c == ')'
                    if(!FirstStack.isEmpty()){
                        FirstStack.pop();
                    }else if(!StarStack.isEmpty()){
                        StarStack.pop();
                    }else{
                        return false;
                    }
                }
            }

        while(!FirstStack.isEmpty() && !StarStack.isEmpty()){  //for the conditon if elements remians in stacks
            if(FirstStack.pop() > StarStack.pop()){ // for closing the '(' index value of '*' should be greater
                return false;
            }
        }

        return FirstStack.isEmpty();
    }
}

public class ValidParenthesisString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution ob = new Solution();
        boolean output = ob.validParenthesis(str);
        System.out.println(output);
        sc.close();
    }
}
