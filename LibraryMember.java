package model;
public class LibraryMember implements Searchable {
 private int memberId; private String name,email,memberType;
 public LibraryMember(int id,String n,String e,String type){memberId=id;name=n;email=e;memberType=type;}
 public int getMemberId(){return memberId;} public void setMemberId(int v){memberId=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getMemberType(){return memberType;} public void setMemberType(String v){memberType=v;}
 public boolean isRegistered(int id){return memberId==id;}
 public String getSearchInfo(){return name+" ("+memberType+"), "+email;}
}
