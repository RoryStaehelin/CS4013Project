import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        int mode;
        System.out.println("Sign in as:");
        System.out.println("(1) Customer");
        System.out.println("(2) Staff");
        mode = Integer.parseInt(Restaurant.getInput());
        if (mode == 2)
        {
            System.out.println("Select role:");
            System.out.println("(1) Front of house");
            System.out.println("(2) Chef");
            mode += Integer.parseInt(Restaurant.getInput()) - 1;
        }
        else if (mode == 1)
        {
            CustomerUserInterface customerUI = new CustomerUserInterface();
        }
        if (mode == 2)
        {
            StaffUserInterface staffUI = new StaffUserInterface();
        }
        else if (mode == 3)
        {
            ChefUserInterface chefUI = new ChefUserInterface();
        }
    }
}
