
/*
 *Group 3: Najeebulla Hussaini, Andre Agrippa
 *2020-11-22
 * a Java version of the WorkTicket class that we previously created in C++.
 */
package ca.durhamcollege;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        // Scanner for user input
        Scanner keyboard = new Scanner(System.in);
        //sentinal variable for loop condition
        boolean isValid = false;
        //User input for ticket attributes
        int workTicketNumber = 0;
        String clientID = "";
        LocalDate workTicketDate = null;
        String issueDescription = "";
        //object of work ticket to store user input
        WorkTicket ticket = new WorkTicket();
        out.println("Default constructor used to create WorkTicket below:\n");
        out.println(ticket.toString());
        //User input
        out.println("\nYou will be making a Work Ticket Today. Please Enter Following Information to Process a Ticket\n");
        do
        {
            out.println("\nPlease Enter Ticket Number (Whole, Positive Number):");
            //Try and catch
            try
            {
                workTicketNumber = keyboard.nextInt();
                isValid = true;
                if (workTicketNumber <1){
                    isValid = false;
                    throw new IllegalArgumentException("Work ticket number must be integer greater than 0");
                }
            }
            catch (Exception e)
            {
                out.println("ERROR you must enter a valid whole number\n" + e);
                keyboard.nextLine();
                isValid = false;
            }
        }while (!isValid);
        ticket.setWorkTicketNumber(workTicketNumber);
        //Client id user input
        do
        {
            out.println("\nEnter your ticket ID (alpha-numeric):");
            //Try and catch
            try
            {
                clientID = keyboard.next();
                isValid = true;
                if (clientID.length() <1){
                    out.println("\nInvalid clientID");
                    isValid = false;
                }
            }
            catch (InputMismatchException inputMismatchException)
            {
                out.println("ERROR you must enter a valid client id");
                keyboard.nextLine();
                isValid = false;
            }
        }while (!isValid);
        ticket.setWorkTicketClientID(clientID);
        //Date Input
        do
        {
            out.println("\nEnter Work Ticket Date (yyyy-MM-dd) :");
            //Try and catch
            try
            {
                String tempDate = keyboard.next();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                workTicketDate = LocalDate.parse(tempDate, dateFormat);
                isValid = true;
                if (workTicketDate.getYear() < 2000 || workTicketDate.getYear() > 2099){
                    isValid = false;
                    throw new IllegalArgumentException(workTicketDate.getYear() + " must be year between 2000 and 2099");
                }
            }
            catch (Exception e)
            {
                out.println("ERROR you must enter a valid date\n" + e);
                keyboard.nextLine();
                isValid = false;
            }
        }while (!isValid);
        //FORMATTING
        keyboard.nextLine();
        //issue description user input
        do
        {
            out.println("\nEnter your work issue description:");
            //Try and catch
            try
            {
                issueDescription = keyboard.nextLine();
                isValid = true;
                if (issueDescription.length() <1){
                    out.println("\nInvalid issue description");
                    isValid = false;
                }
            }
            catch (InputMismatchException inputMismatchException)
            {
                out.println("ERROR you must enter a valid issue description");
                keyboard.nextLine();
                isValid = false;
            }
        }while (!isValid);
        ticket.setWorkTicketIssueDescription(issueDescription);
        ticket.setWorkTicketDate(workTicketDate);
        //Check to see if everything is valid
        if (ticket.SetWorkTicket(workTicketNumber, workTicketDate, clientID , issueDescription) == true){
            out.println("Congrats. You have just made a ticket\n");
            out.println(ticket.toString());
        }
    }
}