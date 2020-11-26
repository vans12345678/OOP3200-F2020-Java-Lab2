package ca.durhamcollege;
import java.time.LocalDate;

public class WorkTicket
{
    //Private data members
    private int workTicketNumber;
    private LocalDate workTicketDate;

    private String workTicketClientID;
    private String workTicketIssueDescription;

    //Mutators (Getters and Setters)
    public int getWorkTicketNumber() { return workTicketNumber; }
    public void setWorkTicketNumber(int workTicketNumber) { this.workTicketNumber = workTicketNumber; }

    public LocalDate getWorkTicketDate() { return workTicketDate; }
    public void setWorkTicketDate(LocalDate workTicketDate) { this.workTicketDate = workTicketDate; }

    public String getWorkTicketClientID() { return workTicketClientID; }
    public void setWorkTicketClientID(String workTicketClientID) { this.workTicketClientID = workTicketClientID; }

    public String getWorkTicketIssueDescription() { return workTicketIssueDescription; }
    public void setWorkTicketIssueDescription(String workTicketIssueDescription) { this.workTicketIssueDescription = workTicketIssueDescription; }

    public boolean SetWorkTicket(int workTicketNumber, LocalDate date, String clientID,  String issueDescription)
    {
        if (workTicketNumber >= 1) {
            setWorkTicketNumber(workTicketNumber);
            if (clientID.length() >= 1) {
                setWorkTicketClientID(clientID);
                if (date.getYear() >= 2000 && date.getYear() <=2099) {
                    setWorkTicketDate(date);
                    if (issueDescription.length() >= 1) {
                        setWorkTicketIssueDescription(issueDescription);
                        return true;
                    }
                    else {
                        System.out.println("\nInvalid issue description");
                        return false;
                    }
                }
                else {
                    System.out.println("\nERROR, Year is out of range, must be between 2000 and 2099");
                    return false;
                }
            }
            else {
                System.out.println("\nInvalid clientID");
                return false;
            }
        }
        else {
            System.out.println(" \nInvalid ticket number. Ticket number must be a whole, positive number");
            return false;
        }
    }

    //Constructors

    //Default
    WorkTicket()
    {
        SetWorkTicket(0, null,null,null);
    }
    WorkTicket(int ticketNumber, LocalDate date, String clientId, String issueDescription)
    {
        SetWorkTicket(ticketNumber, date,clientId,issueDescription);
    }

    //Private methods
    @Override
    public String toString() {
    return "Work Ticket Number : " + workTicketNumber + "\nClientID : " + workTicketClientID +
            "\nWork Ticket Date : " + workTicketDate +
            "\nIssue Description : " + workTicketIssueDescription + "\n";
    }

}
