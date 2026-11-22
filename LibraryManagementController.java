package model;

public class LibraryManagementController {
    private Book[] books;
    private LibraryMember[] members;
    private BookIssue[] issues;
    private BookReturn[] returns;
    private int nextIssueId;
    private int nextReturnId;
    private int issueCount;
    private int returnCount;

    public LibraryManagementController(Book[] books, LibraryMember[] members) {
        this.books = books;
        this.members = members;
        this.issues = new BookIssue[100];
        this.returns = new BookReturn[100];
        this.nextIssueId = 1;
        this.nextReturnId = 1;
    }
    public Book[] getBooks() { return books; }
    public void setBooks(Book[] books) { this.books = books; }
    public LibraryMember[] getMembers() { return members; }
    public void setMembers(LibraryMember[] members) { this.members = members; }
    public BookIssue[] getIssues() { return issues; }
    public void setIssues(BookIssue[] issues) { this.issues = issues; }
    public BookReturn[] getReturns() { return returns; }
    public void setReturns(BookReturn[] returns) { this.returns = returns; }
    public int getIssueCount() { return issueCount; }
    public int getReturnCount() { return returnCount; }

    public Book searchBook(Book[] list, int id) {
        for (int i = 0; i < list.length; i++)
            if (list[i] != null && list[i].getBookId() == id) return list[i];
        return null;
    }
    public Book searchBook(String title) {
        for (int i = 0; i < books.length; i++)
            if (books[i] != null && books[i].getTitle().equalsIgnoreCase(title)) return books[i];
        return null;
    }
    public int countAvailableBooks(Book[] list) {
        int count = 0;
        for (int i = 0; i < list.length; i++)
            if (list[i] != null && list[i].checkAvailability()) count++;
        return count;
    }
    public boolean isRegistered(int id) {
        for (int i = 0; i < members.length; i++)
            if (members[i] != null && members[i].isRegistered(id)) return true;
        return false;
    }
    public void issueBook(int memberId, int bookId) {
        Book book = searchBook(books, bookId);
        if (!isRegistered(memberId)) System.out.println("Member not found. Issue cancelled.");
        else if (book == null) System.out.println("Book not found. Issue cancelled.");
        else if (!book.canBeIssued()) System.out.println("This book is unavailable or cannot be issued.");
        else if (issueCount >= issues.length) System.out.println("Issue record capacity reached.");
        else {
            book.updateStatus("Issued");
            BookIssue issue = new BookIssue(nextIssueId++, bookId, memberId, "Today", "After 14 days");
            issues[issueCount++] = issue;
            issue.createIssue();
            System.out.println("Book issued successfully.");
        }
    }
    public void returnBook(int bookId, int lateDays) {
        Book book = searchBook(books, bookId);
        if (book == null) { System.out.println("Book not found."); return; }
        if (!book.getStatus().equalsIgnoreCase("Issued")) { System.out.println("Book is not currently issued."); return; }
        if (returnCount >= returns.length) { System.out.println("Return record capacity reached."); return; }
        BookIssue activeIssue = null;
        for (int i = issueCount - 1; i >= 0; i--) {
            if (issues[i] != null && issues[i].getBookId() == bookId) { activeIssue = issues[i]; break; }
        }
        if (activeIssue == null) { System.out.println("Active issue record not found."); return; }
        double fineAmount = lateDays > 0 ? activeIssue.calculateFine(lateDays) : 0.0;
        BookReturn returned = new BookReturn(nextReturnId++, activeIssue.getIssueId(), "Today");
        returned.setFineAmount(fineAmount);
        returned.recordReturn();
        returns[returnCount++] = returned;
        book.updateStatus("Available");
        System.out.println("Book returned successfully. Fine: Rs. " + fineAmount);
    }
    public void showBooks() {
        for (int i = 0; i < books.length; i++) if (books[i] != null) books[i].displayBook();
    }
    public void showMember(int id) {
        for (int i = 0; i < members.length; i++)
            if (members[i] != null && members[i].getMemberId() == id) {
                System.out.println(members[i].getSearchInfo()); return;
            }
        System.out.println("Member not found.");
    }
    public void showBorrowingRecords() {
        if (issueCount == 0) { System.out.println("No borrowing records."); return; }
        for (int i = 0; i < issueCount; i++)
            if (issues[i] != null)
                System.out.println("Issue #" + issues[i].getIssueId() + " | Book: " + issues[i].getBookId()
                        + " | Member: " + issues[i].getMemberId() + " | Due: " + issues[i].getDueDate());
    }
}
