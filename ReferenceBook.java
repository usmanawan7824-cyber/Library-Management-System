package model;

public class ReferenceBook extends Book {
    private String readingArea;
    private String referenceType;
    private boolean staffOnly;

    public ReferenceBook(int id, String title, String author, String category,
                         String readingArea, String referenceType, boolean staffOnly) {
        super(id, title, author, category);
        this.readingArea = readingArea;
        this.referenceType = referenceType;
        this.staffOnly = staffOnly;
    }
    public String getReadingArea() { return readingArea; }
    public void setReadingArea(String readingArea) { this.readingArea = readingArea; }
    public String getReferenceType() { return referenceType; }
    public void setReferenceType(String referenceType) { this.referenceType = referenceType; }
    public boolean isStaffOnly() { return staffOnly; }
    public void setStaffOnly(boolean staffOnly) { this.staffOnly = staffOnly; }

    @Override
    public boolean canBeIssued() { return false; }
    public void displayReferenceInfo() {
        super.displayBook();
        System.out.println("Area: " + readingArea + ", Type: " + referenceType + ", Staff only: " + staffOnly);
    }
}
