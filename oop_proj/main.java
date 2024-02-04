import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane; // Import BorderPane
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import com.inventory.Book;
import com.inventory.Journal;
import com.inventory.NonFiction;
import com.inventory.Novel;

public class main extends Application {

    private ListView<Book> cartList = new ListView<>();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private Catalogue catalogue = new Catalogue();
    private Label totalLabel;
    private VBox cartListVBox;

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainLayout = new BorderPane(); // Create a BorderPane

        // Create the top region with the "Show Cart" button
        Button showCartButton = new Button("Show Cart");
        showCartButton.setOnAction(e -> {
            updateCartListView();
            updateCartTotal();
            cartListVBox.setVisible(!cartListVBox.isVisible());
        });
        mainLayout.setTop(showCartButton); // Set the "Show Cart" button in the top region

        // Create the center region to display the product catalogue
        GridPane productGridPane = new GridPane();
        int row = 1;
        int col = 0;

        for (Book product : catalogue.getProducts()) {
            Button addToCartButton = new Button("Add to Cart");
            addToCartButton.setOnAction(e -> {
                shoppingCart.addProduct(product);
                updateCartTotal();
            });

            GridPane productGrid = new GridPane();
            productGrid.add(new Label(product.display()), 0, 0);
            productGrid.add(new Label(" "), 0, 1);
            productGrid.add(addToCartButton, 0, 2);

            productGridPane.add(productGrid, col, row);

            col++;
            if (col == 3) {
                col = 0;
                row++;
            }
        }

        mainLayout.setCenter(productGridPane); // Set the product catalogue in the center region

        // Create the right region for the cart list
        totalLabel = new Label("Total: $0.00");
        cartListVBox = new VBox(new Label("Shopping Cart:"), cartList, totalLabel);
        cartListVBox.setVisible(false);
        mainLayout.setRight(cartListVBox); // Set the cart list in the right region

        Scene scene = new Scene(mainLayout, 800, 800);
        primaryStage.setTitle("Shopping Platform");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    // Other methods remain the same
}
