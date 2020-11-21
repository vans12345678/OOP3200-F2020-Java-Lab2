package ca.durhamcollege;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    //Main begins here
    public Main()
    {
        int ticketNumber = 0;
        LocalDate date = null;
        String clientId ="";
        String issueDescription = "";

        final int MIN_DATE = 2000;
        final int MAX_DATE = 2099;

        WorkTicket ticket = new WorkTicket();
        Scanner keyboard = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String prompt = "";
        boolean isValid = true;

        System.out.print("Enter the work ticket client ID:");
        clientId = keyboard.nextLine();

        try
        {
            do
            {
                System.out.print("Enter the work ticket number:");
                ticketNumber = keyboard.nextInt();

                if(ticketNumber < 1)
                {
                    System.out.println("Error: You must enter a work ticket number greater than 0");
                    keyboard.nextLine();
                    isValid = false;
                }
                else
                {
                    System.out.print("Enter the work ticket date:");
                    prompt = keyboard.nextLine();
                    date = LocalDate.parse(prompt, dateFormat);
                    if(date.getYear() < MIN_DATE || date.getYear() > MAX_DATE)
                    {
                        throw new IllegalArgumentException(date.getYear() + " must be year between 2000 and 2099");
                    }
                    else
                    {
                        System.out.print("Enter the work ticket issue description:");
                        prompt = keyboard.nextLine();
                    }
                }
            }
            while(!isValid);
        }
        catch(DateTimeException |  IllegalArgumentException ex)
        {
            System.out.println("Date Error:");
            keyboard.nextLine();
            isValid = false;
        }

        ticket.SetWorkTicket(ticketNumber, date, clientId, issueDescription);
        System.out.print(ticket.toString());


    }

    public static void main(String[] args) {
	new Main();
    }
}
