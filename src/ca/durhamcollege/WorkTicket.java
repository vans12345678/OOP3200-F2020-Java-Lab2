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

    public void SetWorkTicket(int ticketNumber, LocalDate date, String clientId, String issueDescription)
    {
        this.workTicketNumber = ticketNumber;
        this.workTicketDate = date;
        this.workTicketClientID = clientId;
        this.workTicketIssueDescription = issueDescription;
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
