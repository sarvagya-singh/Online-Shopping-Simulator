import java.util.ArrayList;
import java.util.List;
import com.inventory.Book;
import com.inventory.Journal;
import com.inventory.Novel;
import com.inventory.NonFiction;

public class ShoppingCart {
    private final List<Book> cartItems = new ArrayList<>();

    public void addProduct(Book item) {
        cartItems.add(item);
    }

    public List<Book> getCartItems() {
        return cartItems;
    }

    public double calculateTotal() {
        double total = 0;
        for (Book item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }
}
