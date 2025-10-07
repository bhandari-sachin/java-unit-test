import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    /**
     * Inner class to store price and quantity of each item
     */
    private static class Item {
        double price;
        int quantity;

        Item(double price) {
            this.price = price;
            this.quantity = 1;
        }

        void incrementQuantity() {
            this.quantity++;
        }

        void decrementQuantity() {
            if (this.quantity > 0) this.quantity--;
        }

        double totalPrice() {
            return price * quantity;
        }
    }

    private final Map<String, Item> items = new HashMap<>();

    /**
     * Add an item to the cart. If it already exists, increase quantity.
     */
    public void addItem(String name, double price) {
        if (items.containsKey(name)) {
            items.get(name).incrementQuantity();
        } else {
            items.put(name, new Item(price));
        }
    }

    /**
     * Remove an item from the cart. If quantity > 1, decrease quantity; else remove.
     */
    public void removeItem(String name) {
        if (items.containsKey(name)) {
            Item item = items.get(name);
            if (item.quantity > 1) {
                item.decrementQuantity();
            } else {
                items.remove(name);
            }
        }
    }

    /** Returns the number of unique items in the cart */
    public int getItemCount() {
        return items.size();
    }

    /** Returns the total quantity of all items in the cart */
    public int getTotalQuantity() {
        return items.values().stream().mapToInt(i -> i.quantity).sum();
    }

    /** Returns the total cost of all items in the cart */
    public double getTotalCost() {
        return items.values().stream().mapToDouble(Item::totalPrice).sum();
    }
}
