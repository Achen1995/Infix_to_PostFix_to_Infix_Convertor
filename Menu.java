/** Addison Chen
  * Conversions of infixtopostfix and postfixtoinfix.  This is the menu linking these conversions
  */
import java.util.*; //import Scanner class
import java.util.Scanner; //import Scanner class

public class Menu
{
  public static void main(String []arg)
  {
    //Use to print out the different types of choices 
    System.out.println("Please select what type of conversion you would like to do:");
    System.out.println("1) Infix to postfix");
    System.out.println("2) Postfix to infix");
    System.out.println("3) Print Equations");
    System.out.println("4) Exit");
    
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println(" ");
    int choices; //declaring the choices 
    LinkedList<String> outputList = new LinkedList<String>();
    
    do{
    System.out.println("Enter \"1\", \"2\", \"3\" or \"4\"");
    choices = keyboard.nextInt();
    
    switch (choices)
    {
      case 1:{ // Infix to Postfix
      String input;
      String output;
      System.out.println("Please enter the Infix equation");
        input = keyboard.next();
      InfixToPostfix theTrans = new InfixToPostfix(input);  //input
      output = theTrans.Trans(); //pass to method & output 
      outputList.add("Infix:   " + input); //save
      outputList.add("Postfix:   "+ output); //save
      //System.out.println( is " + output);
   }
        break;
      case 2: { // Postfix to Infix
        PostfixToInfix obj = new PostfixToInfix();
        System.out.println("Please enter the Postfix equation");
        String postfix = keyboard.next(); //input
        outputList.add("Postfix:   "+ postfix);  //save
        //System.out.println("Infix is "+ obj.convert(postfix));
        outputList.add("Infix:   "+ obj.convert(postfix)); //save
        
 }
        break;
      case 3:
        //Print equation
        //print the link list 'outputList'
        String finalPrint = "Here's the final output";
       
        for(int i=0; i<outputList.size(); i+=2)
        {
             finalPrint += "\n\n\n" + outputList.get(i) + "\n\n" + outputList.get(i+1) +"\n\n\n";
        }
        
        System.out.println(finalPrint);
        break;
      case 4:
        //Exit
      break;
      default:
        System.out.println("Value must be between 1 and 4");
    }
    }while (choices != 4);
    keyboard.close();
  }
}


