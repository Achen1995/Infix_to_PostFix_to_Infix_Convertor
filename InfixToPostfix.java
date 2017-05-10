/**
 * Addison Chen
 * Creating infix to postfix converter and linking it to the menu
*/

public class InfixToPostfix {
   private Stack theStacks;
   private String input;
   private String output = "";
   public InfixToPostfix(String in) {
      input = in;
      int stackSize = input.length();
      theStacks = new Stack(stackSize);
   }
   //Using the case statement to create the char c to unput the signs and creating pranthesis
   public String Trans() {
      for (int j = 0; j < input.length(); j++) {
         char c = input.charAt(j);
         switch (c) {
            case '+': 
            case '-':
            gotOper(c, 1); 
            break; 
            case '*': 
            case '/':
            gotOper(c, 2); 
            break; 
            case '(': 
            theStacks.push(c);
            break;
            case ')': 
            gotParen(c); 
            break;
            default: 
            output = output + c; 
            break;
         }
      }
      while (!theStacks.isEmpty()) {
         output = output + theStacks.pop();
      }
      System.out.println(output);
      return output; 
   }
   public void gotOper(char opThis, int prec1) {
      while (!theStacks.isEmpty()) {
         char opTop = theStacks.pop();
         if (opTop == '(') {
            theStacks.push(opTop);
            break;
         }
         else {
            int prec2;
            if (opTop == '+' || opTop == '-')
            prec2 = 1;
            else
            prec2 = 2;
            if (prec2 < prec1) { 
               theStacks.push(opTop);
               break;
            }
      else
            output = output + opTop;
         }
      }
      theStacks.push(opThis);
   }
   public void gotParen(char ch){ 
      while (!theStacks.isEmpty()) {
         char chx = theStacks.pop();
         if (chx == '(') 
         break; 
         else
         output = output + chx; 
      }
   }
 
   class Stack {
      private int maxSize;
      private char[] stackArray;
      private int top;
      public Stack(int max) {
         maxSize = max;
         stackArray = new char[maxSize];
         top = -1;
      }
      public void push(char j) {
         stackArray[++top] = j;
      }
      public char pop() {
         return stackArray[top--];
      }
      public char peek() {
         return stackArray[top];
      }
      public boolean isEmpty() {
         return (top == -1);
     }
   }
}
