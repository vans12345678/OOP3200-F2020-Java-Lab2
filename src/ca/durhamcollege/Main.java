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
        boolean isValid = false;

        System.out.print("Enter the work ticket client ID:");
        clientId = keyboard.nextLine();
        while(!isValid)
        {
            try
            {
                System.out.print("Enter the work ticket number:");
                ticketNumber = keyboard.nextInt();

                if(ticketNumber < 1)
                {
                    throw new IllegalArgumentException("Work ticket number must be integer greater than 0");
                }
                keyboard.nextLine();

                System.out.print("Enter the work ticket date(dd/MM/yyyy):");
                String tempDate = keyboard.next();
                date = LocalDate.parse(tempDate, dateFormat);
                if(date.getYear() < MIN_DATE || date.getYear() > MAX_DATE)
                {
                    throw new IllegalArgumentException(date.getYear() + " must be year between 2000 and 2099");
                }
                keyboard.nextLine();

                System.out.print("Enter the work ticket issue description:");
                issueDescription = keyboard.nextLine();

                isValid = true;
            }
            catch(Exception ex)
            {
                System.out.println("Exception Error:" + ex );
                keyboard.nextLine();
                isValid = false;
            }
        }


        ticket.SetWorkTicket(ticketNumber, date, clientId, issueDescription);
        System.out.print(ticket.toString());


    }

    public static void main(String[] args) {
	new Main();
    }
}
