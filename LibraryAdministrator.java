package model;

public class LibraryAdministrator extends User {
    private String office;
    private String accessLevel;
    private String contactNumber;

    public LibraryAdministrator(int id, String name, String email, String password,
                                String office, String accessLevel, String contactNumber) {
        super(id, name, email, password);
        this.office = office;
        this.accessLevel = accessLevel;
        this.contactNumber = contactNumber;
    }
    public String getOffice() { return office; }
    public void setOffice(String value) { office = value; }
    public String getAccessLevel() { return accessLevel; }
    public void setAccessLevel(String value) { accessLevel = value; }
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String value) { contactNumber = value; }
    @Override
    public boolean checkPermission(String action) {
        return action.equalsIgnoreCase("search") || action.equalsIgnoreCase("manage")
                || action.equalsIgnoreCase("history") || action.equalsIgnoreCase("overdue");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Office: " + office + ", Access: " + accessLevel + ", Contact: " + contactNumber);
    }
}
