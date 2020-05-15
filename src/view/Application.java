package view;

import view.clients.ClientsManager;
import view.companymember.CompanyMemberUse;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ClientsManager clientsManager= new ClientsManager();
        CompanyMemberUse companyMemberUse= new CompanyMemberUse();
        System.out.println("Wellcome to our application. Please choose your position");
        System.out.println("1. Company member ");
        System.out.println("2. Customer ");
        System.out.println("3.Exit application");
        System.out.println("Choose: ");
        Scanner scanner= new Scanner(System.in);
        int choose= scanner.nextInt();
        scanner.nextLine();
        do{
            switch (choose){
                case 1:
                    companyMemberUse.showProgrameForCompany();
                    break;
                case 2:
                    clientsManager.showPrograme();
                    break;
                case 3:
                    System.out.println("Thank for your visiting");
                    break;
                default:
                    System.out.println("Wrong number choose.Please input choose again");
                    break;
            }
        } while (choose!=3);

    }
}
