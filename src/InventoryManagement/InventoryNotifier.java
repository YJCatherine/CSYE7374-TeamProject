public class InventoryNotifier implements InventoryObserver {
    public void update(String message) {
        System.out.println("Sending notification: " + message);
    }
}
