package model;

public class FacultyMember extends User {
    private String facultyDepartment;
    private String designation;
    private int borrowingLimit;

    public FacultyMember(int id, String name, String email, String password,
                         String facultyDepartment, String designation, int borrowingLimit) {
        super(id, name, email, password);
        this.facultyDepartment = facultyDepartment;
        this.designation = designation;
        this.borrowingLimit = borrowingLimit;
    }
    public String getFacultyDepartment() { return facultyDepartment; }
    public void setFacultyDepartment(String value) { facultyDepartment = value; }
    public String getDesignation() { return designation; }
    public void setDesignation(String value) { designation = value; }
    public int getBorrowingLimit() { return borrowingLimit; }
    public void setBorrowingLimit(int value) { borrowingLimit = value; }
    @Override
    public boolean checkPermission(String action) {
        return action.equalsIgnoreCase("search") || action.equalsIgnoreCase("availability")
                || action.equalsIgnoreCase("history");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + facultyDepartment + ", Designation: " + designation
                + ", Borrowing limit: " + borrowingLimit);
    }
}
