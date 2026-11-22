package main;

import java.util.Scanner;
import model.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Book[] books = {
            new LoanableBook(101, "Object Oriented Programming", "Ali", "Computer Science", 14, "A-01", true),
            new LoanableBook(102, "Data Structures", "Ahmed", "Computer Science", 14, "A-02", true),
            new ReferenceBook(103, "Encyclopedia", "Khan", "Reference", "Reading Hall", "General", false),
            new Book(104, "Database Systems", "Sara", "Computer Science")
        };
        LibraryMember[] members = {
            new LibraryMember(1, "Usman", "usman@email.com", "Student"),
            new LibraryMember(2, "Ayesha", "ayesha@email.com", "Faculty")
        };
        LibraryManagementController controller = new LibraryManagementController(books, members);

        // Runtime polymorphism using a parent-class array.
        User[] users = {
            new Student(1, "Ali", "ali@email.com", "1234", "BSCS", 4, "Computing"),
            new Librarian(2, "Sara", "sara@email.com", "1234", "LIB01", "Morning", "Desk-1"),
            new FacultyMember(3, "Hina", "hina@email.com", "1234", "Computer Science", "Lecturer", 10),
            new LibraryAdministrator(4, "Admin", "admin@email.com", "1234", "Main Office", "Full", "03000000000")
        };
        System.out.println("=== Runtime Polymorphism Demonstration ===");
        for (int i = 0; i < users.length; i++) {
            users[i].displayInfo();
            System.out.println("Permission to issue: " + users[i].checkPermission("issue"));
        }

        int choice;
        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. View all books");
            System.out.println("2. Search a book (UC-02)");
            System.out.println("3. Check book availability (UC-03)");
            System.out.println("4. Issue a book (UC-05)");
            System.out.println("5. Return a book (UC-06)");
            System.out.println("6. View member details");
            System.out.println("7. View borrowing records (UC-09)");
            System.out.println("8. Count available books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            while (!input.hasNextInt()) { System.out.print("Enter a number: "); input.next(); }
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    controller.showBooks();
                    break;
                case 2: {
                    System.out.print("Enter book ID: ");
                    int id = input.nextInt();
                    Book found = controller.searchBook(books, id);
                    if (found != null) found.displayBook();
                    else System.out.println("Book not found.");
                    break;
                }
                case 3: {
                    System.out.print("Enter book ID: ");
                    int id = input.nextInt();
                    Book found = controller.searchBook(books, id);
                    if (found == null) System.out.println("Book not found.");
                    else if (found.checkAvailability()) System.out.println(found.getTitle() + " is available.");
                    else System.out.println(found.getTitle() + " is not available. Status: " + found.getStatus());
                    break;
                }
                case 4:
                    System.out.print("Enter member ID: ");
                    int memberId = input.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = input.nextInt();
                    controller.issueBook(memberId, bookId);
                    break;
                case 5:
                    System.out.print("Enter book ID: ");
                    int returnBookId = input.nextInt();
                    System.out.print("Enter overdue days (0 if on time): ");
                    int lateDays = input.nextInt();
                    controller.returnBook(returnBookId, lateDays);
                    break;
                case 6:
                    System.out.print("Enter member ID: ");
                    controller.showMember(input.nextInt());
                    break;
                case 7:
                    controller.showBorrowingRecords();
                    break;
                case 8:
                    System.out.println("Available books: " + controller.countAvailableBooks(books));
                    break;
                case 0:
                    System.out.println("Thank you for using the Library Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        input.close();
    }
}
