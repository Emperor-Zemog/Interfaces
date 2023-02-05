import java.util.Scanner;

public class VMGMule {
    static Scanner owl;
    public VMGMule(Scanner owl){
        this.owl=owl;
    }
    public static String getUserString( String pfUser)
    {
        String outString = "";
        while(outString.length() == 0); {
            System.out.print("\n" + pfUser + ": ");
            outString = owl.nextLine();
        }

        return outString;

    }
    public static boolean getUserConfirm(String pfUser)
    {
        boolean outVal = true;
        String userRes = "";
        boolean done = false;
        while(done!=true){
            System.out.print("\n" + pfUser + " (Y/N): ");
            userRes = owl.nextLine();
            if(userRes.equalsIgnoreCase("Y"))
            {
                done = true;
                outVal = true;
            }
            else if(userRes.equalsIgnoreCase("N"))
            {
                done = true;
                outVal = false;
            }
            else
            {
                System.out.println("Answer must be a Y or a N! " + userRes );
            }

        }

        return outVal;
    }
    public static int getIndexSelect(String pfUser, int low, int high)
    {
        int outVal = 0;
        String junk = "";
        boolean done = false;

        while(done!=true) {
            System.out.print("\n" + pfUser + "(" + low + "<>" + high + "): ");
            if(owl.hasNextInt())
            {
                outVal = owl.nextInt();
                owl.nextLine();
                if(outVal >= low && outVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nIndex is Invalid (" + low + "<>" + high + "): " + outVal);
                }
            }
            else
            {
                junk = owl.nextLine();
                System.out.println(junk +" isn't an Int please try again ");
            }
        }

        return outVal;
    }
    public static double getStuntedDouble(String pfUser, double low)
    {
        double outVal = 0;
        String junk = "";
        boolean done = false;

        while(done!=true) {
            System.out.print("\n" + pfUser + " Lower Limit of (" + low + "): ");
            if(owl.hasNextDouble())
            {
                outVal = owl.nextDouble();
                owl.nextLine();
                if(outVal >= low )
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nInput is Invalid (" + low + " Is the Lowest Limit): " + outVal);
                }
            }
            else
            {
                junk = owl.nextLine();
                System.out.println(junk +" isn't an number please try again ");
            }
        }

        return outVal;
    }
    public static int getStuntedInt(String pfUser, int low)
    {
        int outVal = 0;
        String junk = "";
        boolean done = false;

        while(done!=true) {
            System.out.print("\n" + pfUser + " Input must be greater or equal to(" + low + "): ");
            if(owl.hasNextInt())
            {
                outVal = owl.nextInt();
                owl.nextLine();
                if(outVal >=low )
                {
                    done = true;
                }
                else
                {
                    System.out.println("\nInput is Invalid it is less then (" + low + "): " + outVal);
                }
            }
            else
            {
                junk = owl.nextLine();
                System.out.println(junk +" isn't an Int please try again ");
            }
        }

        return outVal;
    }

}
