package model;
public class Book implements Searchable {
 private int bookId; private String title,author,category,status;
 public Book(int id,String t,String a,String c){bookId=id;title=t;author=a;category=c;status="Available";}
 public Book(int id,String t,String a,String c,String s){this(id,t,a,c);status=s;}
 public int getBookId(){return bookId;} public void setBookId(int v){bookId=v;}
 public String getTitle(){return title;} public void setTitle(String v){title=v;}
 public String getAuthor(){return author;} public void setAuthor(String v){author=v;}
 public String getCategory(){return category;} public void setCategory(String v){category=v;}
 public String getStatus(){return status;} public void setStatus(String v){status=v;}
 public boolean checkAvailability(){return status.equalsIgnoreCase("Available");}
 public boolean canBeIssued(){return checkAvailability();}
 public void updateStatus(String s){status=s;}
 public void displayBook(){System.out.println(bookId+" | "+title+" | "+author+" | "+category+" | "+status);}
 public void displayBook(boolean showStatus){if(showStatus)displayBook();else System.out.println(bookId+" | "+title+" | "+author+" | "+category);}
 public String getSearchInfo(){return title+" by "+author+" ("+category+")";}
}
