/*
Jacob Jerris
N01419995
3/1/20
 */




import java.util.Scanner;
import java.util.Random;
public class TestAccount {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account userAccount = null;
		boolean flag = false;
		
		Random rand = new Random();
		
		int[] ArrayList = {9801,2345,3025,1024,4096,6021,8192,5768,7113,1497};
		
		Account accounts[] = new Account[10];
		
		/*
		  This for loop loops through the accounts array and gives each account a random balance.

		  I used https://stackoverflow.com/questions/5887709/getting-random-numbers-in-java
		  along with slides to assist me in figuring this out.
		 */
		for(int i = 0; i < accounts.length; i++) {
			double randomNum = rand.nextInt(5001);
			accounts[i] = new Account(ArrayList[i], randomNum);
		}

		
		/*
		 * This infinite loop continuously loops until it finds the correct ID, once it has found 
		 * the correct ID it sets the boolean flag to true and continues on with the program.
		 */
		for(;;) {
			System.out.print("********Welcome********\n");
	        System.out.print("Please enter an ID: ");
			int userInput = input.nextInt();
			for(int i =0; i < accounts.length; i++) {
				if(userInput == accounts[i].getID()) {
					userAccount = accounts[i];
					flag = true;
				}
			}
			/*
			 * This if statement only continues if the flag is true, once the flag becomes true
			 * it loops through the menu and continues depending on what the user selects. Once it's
			 * finished the flag is set back to false and the loop breaks.
			 */
			if(flag == true) {
				for(;;) {
				System.out.print("\n***Main Menu***\n");
				System.out.print("1: balance\n");
				System.out.print("2: withdraw\n");
				System.out.print("3: deposit\n");
				System.out.print("4: exit\n");
				userAccount.setOption(input.nextInt());
			if(userAccount.getUserOption() == 1) {
            	System.out.println("This is your balance: " + userAccount.getBalance());
            } else if(userAccount.getUserOption() == 2) {
            	System.out.println("How much would you like to withdraw: ");
            	userInput = input.nextInt();
            	userAccount.withdraw(userInput);
            	System.out.println("This is your new balance: " + userAccount.getBalance());
            } else if(userAccount.getUserOption() == 3) {
            	System.out.println("How much would you like to deposit: ");
            	userInput = input.nextInt();
            	userAccount.deposit(userInput);
            	System.out.println("This is your new balance: " + userAccount.getBalance());
            } else if(userAccount.getUserOption() == 4) {
            	System.out.println("Thank you for using the ATM, have a good day!\n");
            	flag = false;
            	break;
            	}
			}
			}
		}
	}
}

class Account {
    private int ID;
    private double balance;
    private int option;

    Account() {

    }
    
    Account(int id, double balance) {
        this.ID = id;
        this.balance = balance;
    }
    
    /*
     * This method gets the user method so it may be evaluated by the program. 
     * Which then allows for the menu and other options to pop up.
     */
    int getUserOption() {
        return option;
    }
    
    /*
     * Whatever the users selects for the option is what the option is made, this is then 
     * set to option and returned in the method above.
     */
    void setOption(int option) {
        this.option = option;
    }
    
    /*
     * This method is used to return the ID of whatever the user selects so that the
     * program can evaluate and make sure the ID is correct 
     */
    int getID() {
        return ID;
    }

    double getBalance() {
        return balance;
    }

    void setID(int ID) {
        this.ID = ID;
    }

    void setBalance(double balance) {
        this.balance = balance;
    }

    void withdraw(double amount) {
        if((amount > balance) || (amount < 0)) {
            System.out.print("Amount is invalid, please retry\n");
        } else {
        	balance = balance - amount;
        }
    }

    void deposit(double amount) {
        if(amount < 0) {
            System.out.print("Amount is invalid, please retry\n");
        } else{
            balance = balance + amount;
        }
    }
}


