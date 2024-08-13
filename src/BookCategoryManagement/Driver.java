package src.BookCategoryManagement;

import src.LibraryCardManagement.*;

public class Driver {
    public static void main(String[] args) {
        System.out.println("########### Book Category Management System Starts ###############\n");

        // Create the library facade
        LibraryFacade library = new LibraryFacade();

        // Add some books to the library
        library.addBook("Effective Java", "Joshua Bloch", "A programming book for Java developers", "2008-05-28", "Technical");
        library.addBook("Clean Code", "Robert C. Martin", "A guide to writing clean and maintainable code", "2008-08-01", "Technical");
        library.addBook("The Lean Startup", "Eric Ries", "A book on modern entrepreneurship and management", "2011-09-13", "Management");
        library.addBook("To Kill a Mockingbird", "Harper Lee", "A classic of modern American literature", "1960-07-11", "Literature");
        library.addBook("The Catcher in the Rye", "J.D. Salinger", "A novel about teenage alienation and rebellion", "1951-07-16", "Literature", "Entertainment");

        // Show all books in the Technical category
        System.out.println("Technical Books:");
        library.showBooksByCategory("Technical");

        // Show all books in the Literature category
        System.out.println("\nLiterature Books:");
        library.showBooksByCategory("Literature");

        // Create a serial package suitable for graduate students
        System.out.println("\nCreating a Serial for Graduate Students:");
        library.createSerial("Books a Professional Programmer Needs to Read", "Technical", "Management");

        // Add a new book to the library
        library.addBook("The Pragmatic Programmer", "Andrew Hunt", "A book for software developers on programming and best practices", "1999-10-30", "Technical", "Literature");

        // Show all books in the Technical category after adding the new book
        System.out.println("\nTechnical Books After Adding New Book:");
        library.showBooksByCategory("Technical");

        System.out.println("\n########### Book Category Management System Ends ###############");


    }
}
