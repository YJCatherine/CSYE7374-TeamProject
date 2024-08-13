import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    private List<InventoryItem> inventoryItems = new ArrayList<>();
    private List<InventoryObserver> observers = new ArrayList<>();

    private InventoryManager() {}

    public static synchronized InventoryManager getInstance() {
        if (instance == null) {
            instance = new InventoryManager();
        }
        return instance;
    }

    public void addItem(InventoryItem item) {
        inventoryItems.add(item);
        notifyObservers("Item added: " + item.getDescription());
    }

    public void removeItem(InventoryItem item) {
        inventoryItems.remove(item);
        notifyObservers("Item removed: " + item.getDescription());
    }

    public InventoryItem searchItem(String keyword, SearchStrategy strategy) {
        return strategy.search(inventoryItems, keyword);
    }

    public void registerObserver(InventoryObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (InventoryObserver observer : observers) {
            observer.update(message);
        }
    }

    public List<InventoryItem> getItems() {
        return inventoryItems;
    }
}
