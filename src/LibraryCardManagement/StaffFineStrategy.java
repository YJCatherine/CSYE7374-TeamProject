package src.LibraryCardManagement;

public class StaffFineStrategy implements FineStrategy {
    public double calculateFine(int daysLate) {
        return daysLate * 0.3;
    }
}
