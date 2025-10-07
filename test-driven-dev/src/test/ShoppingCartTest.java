import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ShoppingCartTest
 * Tests adding items, removing items, and calculating total price in the ShoppingCart class.
 * Cases considered:
 * - Adding multiple items
 * - Removing items (existing and non-existing)
 * - Calculating total cost
 * - Edge cases (empty cart)
 * - Handling duplicate items and total quantity
 */
class ShoppingCartTest {

    @Test
    @DisplayName("Add items increases cart size")
    void shouldIncreaseCartSizeWhenItemsAreAdded() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        assertEquals(2, cart.getItemCount(), "Cart should contain 2 unique items");
    }

    @Test
    @DisplayName("Remove item decreases cart size")
    void shouldDecreaseCartSizeWhenItemIsRemoved() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.removeItem("Apple");
        assertEquals(1, cart.getItemCount(), "Cart should contain 1 item after removal");
    }

    @Test
    @DisplayName("Calculate total cost correctly")
    void shouldCalculateTotalCostCorrectly() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Banana", 0.5);
        cart.addItem("Orange", 0.75);
        assertEquals(2.25, cart.getTotalCost(), 0.001, "Total cost should be sum of all items");
    }

    @Test
    @DisplayName("Removing non-existent item does not change cart size")
    void shouldNotChangeCartSizeWhenRemovingNonExistentItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.removeItem("Banana"); // Banana not in cart
        assertEquals(1, cart.getItemCount(), "Cart size should remain unchanged");
    }

    @Test
    @DisplayName("Total cost of empty cart is zero")
    void shouldReturnZeroTotalCostForEmptyCart() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost(), 0.001, "Empty cart should have total cost of 0.0");
    }

    @Test
    @DisplayName("Adding duplicate items increases total quantity")
    void shouldIncreaseQuantityWhenAddingDuplicateItems() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Apple", 1.0);

        // Only 1 unique item
        assertEquals(1, cart.getItemCount(), "Cart should have 1 unique item");

        // Total quantity = 2
        assertEquals(2, cart.getTotalQuantity(), "Total quantity should reflect duplicates");

        // Total cost = 2.0
        assertEquals(2.0, cart.getTotalCost(), 0.001, "Total cost should account for quantity");
    }

    @Test
    @DisplayName("Removing one quantity of duplicate item decreases total quantity")
    void shouldDecreaseQuantityWhenRemovingDuplicateItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Apple", 1.0);
        cart.addItem("Apple", 1.0);

        cart.removeItem("Apple"); // Should decrease quantity from 2 -> 1
        assertEquals(1, cart.getItemCount(), "Cart still has 1 unique item");
        assertEquals(1, cart.getTotalQuantity(), "Total quantity should decrease after removing one");
        assertEquals(1.0, cart.getTotalCost(), 0.001, "Total cost should reflect decreased quantity");
    }
}
