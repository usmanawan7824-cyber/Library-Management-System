package model;

public class Librarian extends User {
    private String employeeCode;
    private String shift;
    private String deskNumber;

    public Librarian(int id, String name, String email, String password,
                     String employeeCode, String shift, String deskNumber) {
        super(id, name, email, password);
        this.employeeCode = employeeCode;
        this.shift = shift;
        this.deskNumber = deskNumber;
    }
    public String getEmployeeCode() { return employeeCode; }
    public void setEmployeeCode(String employeeCode) { this.employeeCode = employeeCode; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public String getDeskNumber() { return deskNumber; }
    public void setDeskNumber(String deskNumber) { this.deskNumber = deskNumber; }

    @Override
    public boolean checkPermission(String action) {
        return action.equalsIgnoreCase("search") || action.equalsIgnoreCase("issue")
                || action.equalsIgnoreCase("return") || action.equalsIgnoreCase("manage");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Employee Code: " + employeeCode + ", Shift: " + shift + ", Desk: " + deskNumber);
    }
}
