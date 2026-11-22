package model;
public abstract class User {
 private int userId; private String name,email,password;
 public User(int id,String n,String e,String p){userId=id;name=n;email=e;password=p;}
 public User(int id,String n){this(id,n,"unknown@email.com","1234");}
 public int getUserId(){return userId;} public void setUserId(int v){userId=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public void displayInfo(){System.out.println(userId+" - "+name+" - "+email);}
 public abstract boolean checkPermission(String action);
}
