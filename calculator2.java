class NegAnsInSub extends Exception
{
    public String toString()
    {
        return "Answer is Negative";
    }
    public String getMessage()
    {
        return "Re-Enter Second number less than First Number";
    }
}
class DivbyZero extends Exception
{
    public String toString()
    {
        return "Answer is Undefined";
    }
    public String getMessage()
    {
        return "Dont Enter the Second number as Zero";
    }
}
public class calculator2
{
    public static void main(String args[])
    {
        System.out.println("Hello guys");
        java.util.Scanner sc=new java.util.Scanner(System.in);
        int a,b;
        try
        { 
            System.out.println("Enter a First number");
            a=sc.nextInt();
            
            try
            {
                System.out.println("Enter the Operation you wants to perform from(+,-,*,/)");
            char c=sc.next().charAt(0);
            switch(c)
            {
                case '+':
                    System.out.println("Enter Second number");
                    b=sc.nextInt();
                    System.out.println("Press equalto To know Answer");
                    char i=sc.next().charAt(0);
                    if(i=='=')
                    {
                        System.out.println("The sum is:"+(a+b));
                        
                    }
                    break;
                case '-':
                    System.out.println("Enter Second number");
                    b=sc.nextInt();
                    if((a-b)<0)
                    {
                        throw new NegAnsInSub();
                    }
                    else
                    {
                        System.out.println("Press equalto To know Answer");
                        char x=sc.next().charAt(0);
                        if(x=='=')
                        {
                        System.out.println("The result is:"+(a-b));

                        }
                        else
                        {
                            System.out.println("What else you wants?");
                        }
                    }
                    break;
                case '*':
                    System.out.println("Enter Second number");
                    b=sc.nextInt();
                    System.out.println("Press equalto To know Answer");
                    char u=sc.next().charAt(0);
                    if(u=='=')
                    {
                        System.out.println("The sum is:"+(a*b));
                        
                    }
                    
                    break;
                case '/':
                    System.out.println("Enter the Second Number");
                    b=sc.nextInt();
                    if(b==0)
                    {
                        throw new DivbyZero();
                    }
                    
                    else 
                    {
                        System.out.println("Press equalto To know Answer");
                        char h=sc.next().charAt(0);
                        if(h=='=')
                        {
                        System.out.println("The result is:"+(a/b));

                        }
                        else
                        {
                            System.out.println("What else you wants?");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid Operation you have Entered");

            }
            
            }
            catch(java.util.InputMismatchException e)
            {
                System.out.println("Invalid Second Number");
            }        
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Invalid First Number");
        }
        catch(NegAnsInSub e)
        {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        catch(DivbyZero e)
        {
            System.out.println(e);
            System.out.println(e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}