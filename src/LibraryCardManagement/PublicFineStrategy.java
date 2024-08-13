package src.LibraryCardManagement;


public class PublicFineStrategy implements FineStrategy {
    public double calculateFine(int daysLate) {
        return daysLate * 1.0;
    }
}
