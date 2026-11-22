package model;

public class LoanableBook extends Book {
    private int loanDays;
    private String shelfNumber;
    private boolean renewable;

    public LoanableBook(int id, String title, String author, String category,
                        int loanDays, String shelfNumber, boolean renewable) {
        super(id, title, author, category);
        this.loanDays = loanDays;
        this.shelfNumber = shelfNumber;
        this.renewable = renewable;
    }
    public int getLoanDays() { return loanDays; }
    public void setLoanDays(int loanDays) { this.loanDays = loanDays; }
    public String getShelfNumber() { return shelfNumber; }
    public void setShelfNumber(String shelfNumber) { this.shelfNumber = shelfNumber; }
    public boolean isRenewable() { return renewable; }
    public void setRenewable(boolean renewable) { this.renewable = renewable; }

    @Override
    public boolean canBeIssued() { return super.canBeIssued(); }
    public void displayLoanInfo() {
        super.displayBook();
        System.out.println("Loan days: " + loanDays + ", Shelf: " + shelfNumber + ", Renewable: " + renewable);
    }
}
