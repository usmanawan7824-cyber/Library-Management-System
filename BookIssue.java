package model;
public class BookIssue {
 private int issueId,bookId,memberId; private String issueDate,dueDate; private Fine fine;
 public BookIssue(int i,int b,int m,String d,String due){issueId=i;bookId=b;memberId=m;issueDate=d;dueDate=due;fine=new Fine(10.0);}
 public int getIssueId(){return issueId;} public void setIssueId(int v){issueId=v;}
 public int getBookId(){return bookId;} public void setBookId(int v){bookId=v;}
 public int getMemberId(){return memberId;} public void setMemberId(int v){memberId=v;}
 public String getIssueDate(){return issueDate;} public void setIssueDate(String v){issueDate=v;}
 public String getDueDate(){return dueDate;} public void setDueDate(String v){dueDate=v;}
 public Fine getFine(){return fine;}
 public void createIssue(){System.out.println("Issue created. Due: "+dueDate);}
 public double calculateFine(int days){return fine.calculateFine(days);}
}
