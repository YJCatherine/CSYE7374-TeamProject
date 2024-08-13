package src.LibraryCardManagement;

public class StudentFineStrategy implements FineStrategy {
    public double calculateFine(int daysLate) {
        return daysLate * 0.5;
    }
}
