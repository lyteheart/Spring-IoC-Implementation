package com.example.Cinemaxify;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class CinemaxifyApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Cinemaxify Application");
        while (true) {
            // Select member
            System.out.println("Please select the member you want the plan for:");
            System.out.println("1. Self\n2. Spouse");
            String userType = "";

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    userType = "self";
                    break;
                case 2:
                    userType = "spouse";
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    return;
            }

            /**
             a. Print the below message into console:

             Please select your plan:
             1. Normal
             2. Premium
             **/
            // Select plan
            System.out.println("Please select your plan:");
            System.out.println("1. Normal");
            System.out.println("2. Premium");
            int planChoice = scanner.nextInt();
            scanner.nextLine();
            String beanName = "";
            switch (planChoice) {
                case 1:
                    beanName = userType + "Normal";
                    break;
                case 2:
                    beanName = userType + "Premium";
                    break;
                default:
                    System.out.println("Invalid Choice");
                    return;
            }


            /**  e. Pick the user bean using context.getBean() and use 'userType' + 'planChoice'
             in combination to call the required bean.                                 **/

            // Get combination bean
            User user = (User) context.getBean(beanName);


            // User details
            System.out.println("Please enter your name:");
            String name = scanner.nextLine();

            System.out.println("Please enter your age:");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Please enter your contact:");
            Long contact = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Please enter your address:");
            String address = scanner.nextLine();

            user.setUserDetails(name, age, contact, address);
            user.getUserDetails();

            /**

             f. Input details for selected user

             g. Take input for User details i.e. name , age, address etc.

             h. Set the above fetched details into the user by using appropriate method.

             i. Lastly print the following message into console

             Do you want to purchase plan for someone else
             1. Yes
             2. No
             **/

            // Ask whether to continue
            System.out.println("Do you want to purchase plan for someone else");
            System.out.println("1. Yes");
            System.out.println("2. No");

            int input = scanner.nextInt();

            if (input == 2) {
                break;
            }
        }

    }

}
