package model;
public class BookReturn {
 private int returnId,issueId; private String returnDate; private double fineAmount;
 public BookReturn(int r,int i,String d){returnId=r;issueId=i;returnDate=d;fineAmount=0;}
 public int getReturnId(){return returnId;} public void setReturnId(int v){returnId=v;}
 public int getIssueId(){return issueId;} public void setIssueId(int v){issueId=v;}
 public String getReturnDate(){return returnDate;} public void setReturnDate(String v){returnDate=v;}
 public double getFineAmount(){return fineAmount;} public void setFineAmount(double v){fineAmount=v;}
 public void recordReturn(){System.out.println("Return recorded: "+returnDate);}
}
