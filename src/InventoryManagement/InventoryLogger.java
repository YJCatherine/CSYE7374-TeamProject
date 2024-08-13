public class InventoryLogger implements InventoryObserver {
    public void update(String message) {
        System.out.println("Logging action: " + message);
    }
}

