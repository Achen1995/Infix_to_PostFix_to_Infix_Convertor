/*
 * Addison Chen
 * ICSI 310
 * Assignment 5
 * This program is used to convert postfix to infix as a converter
*/
import java.util.Stack;
 
public class PostfixToInfix {

 //@param c input to be checked
 //@return true if operator
  
 private boolean isOperator(char c){
  if(c == '+' || c == '-' || c == '*' || c =='/' || c == '^')
   return true;
  return false;
 }
  
  //This converts any postfixexpression to infix expression. This becomes a convertor.
  //@param postfix String expression to be converted
  //@return String infix expression produced
  
 public String convert(String postfix){
  Stack<String> stack = new Stack<String>();
   
  for(int i = 0; i < postfix.length(); i++){
   char c = postfix.charAt(i);
   if(isOperator(c)){
    String b = stack.pop();
    String a = stack.pop();
    stack.push("("+a+c+b+")");
   }
   else
    stack.push(""+c);
  }
   
  return stack.pop();
 }
}