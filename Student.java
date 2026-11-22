package model;

public class Student extends User {
    private String degree;
    private int semester;
    private String department;

    public Student(int id, String name, String email, String password,
                   String degree, int semester, String department) {
        super(id, name, email, password);
        this.degree = degree;
        this.semester = semester;
        this.department = department;
    }
    public String getDegree() { return degree; }
    public void setDegree(String degree) { this.degree = degree; }
    public int getSemester() { return semester; }
    public void setSemester(int semester) { this.semester = semester; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public boolean checkPermission(String action) {
        return action.equalsIgnoreCase("search") || action.equalsIgnoreCase("history")
                || action.equalsIgnoreCase("availability");
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Degree: " + degree + ", Semester: " + semester + ", Department: " + department);
    }
}
