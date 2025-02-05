package org.example;
import java.util.Scanner;

public class Dashboard {
    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();
    Prisoner prisoner = new Prisoner();

    public int chooseCell(){
        System.out.println("Enter the cell id : ");
        int cellId = scanner.nextInt();scanner.nextLine();

        return cellId;
    }



    public void showAdminLogin(){
        System.out.println("Enter the admin username : ");
        admin.setUsername(scanner.nextLine());
        System.out.println("Enter the admin password : ");
        admin.setPassword(scanner.nextLine());

        //validation to database
    }



    public void showPrisonerRegistrationDashboard(){
        System.out.println("Enter the first name : ");
        prisoner.setFirstName(scanner.nextLine());
        System.out.println("Enter the last name : ");
        prisoner.setLastName(scanner.nextLine());
        System.out.println("Enter the age : ");
        prisoner.setAge(scanner.nextInt());
        System.out.println("Enter the sex : ");
        prisoner.setSex(scanner.next().charAt(0));

        //put prisoner data into the database

    }
}
