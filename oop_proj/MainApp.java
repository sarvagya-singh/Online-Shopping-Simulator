// import javafx.application.Application;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.control.Label;
// import javafx.scene.layout.GridPane;
// import javafx.scene.layout.BorderPane;
// import javafx.stage.Stage;
// import javafx.scene.control.ListView;
// import javafx.scene.layout.VBox;
// import javafx.scene.layout.HBox;
// import com.inventory.Book;
// import com.inventory.Journal;
// import com.inventory.NonFiction;
// import com.inventory.Novel;


// public class MainApp extends Application {

//     private ListView<Book> cartList = new ListView<>();
//     private ShoppingCart shoppingCart = new ShoppingCart();
//     private Catalogue catalogue = new Catalogue();
//     private Label totalLabel; // Label for displaying the total
//     private VBox cartListVBox; // This will hold the cart ListView and its label

//     @Override
//     public void start(Stage primaryStage) {
//         // Button to show the cart
//         Button showCartButton = new Button("Show Cart");
//         showCartButton.setOnAction(e -> {
//             updateCartListView(); // Update the cart list view before showing it
//             updateCartTotal(); // Update the cart total
//             cartListVBox.setVisible(!cartListVBox.isVisible()); // Toggle visibility
//         });
        

//         // Initialize the total label and the VBox for the cart list
//         totalLabel = new Label("Total: $0.00");
//         cartListVBox = new VBox(new Label("Shopping Cart:"), cartList, totalLabel);
//         cartListVBox.setVisible(false); // Set the cart list VBox to be invisible initially

//         // Main layout that holds both the product list and the cart list side by side
//         BorderPane mainLayout = new BorderPane();
//         mainLayout.setBottom(showCartButton);
//         mainLayout.setTop(new Label("PRODUCT CATALOGUE"));

//         int row = 1;
//         int col = 0;

//         for (Book product : catalogue.getProducts()) 
//         {
//             Button addToCartButton = new Button("Add to Cart");
//             addToCartButton.setOnAction(e -> {
//                 shoppingCart.addProduct(product);
//                 updateCartTotal(); // Update total when a new item is added
//             });

           
//             GridPane productGrid = new GridPane();
//             productGrid.add(new Label(product.display()), 0, 0);
//             productGrid.add(new Label(" "), 0, 1);
//             productGrid.add(addToCartButton, 0, 2);

//             productGridPane.add(productGrid, col, row);

//             col++;
//             if (col == 3) {
//                 col = 0;
//                 row++;
             
//         }
//         mainLayout.setCenter(productGridPane);
       

//         // Add the show cart button to the main layout
//         mainLayout.setRight(cartListVBox);
//         row++;

//         Scene scene = new Scene(mainLayout, 800, 800);
//         primaryStage.setTitle("Shopping Platform");
//         primaryStage.setScene(scene);
//         primaryStage.centerOnScreen(); // Center on screen
//         primaryStage.show();
//     }

//     private void updateCartListView() {
//         cartList.getItems().addAll(shoppingCart.getCartItems());
//     }

//     private void updateCartTotal() {
//         double total = shoppingCart.calculateTotal();
//         String display="Total: "+total;
//         totalLabel.setText(display);
//     }

//     public static void main(String[] args) {
//         launch(args);
//     }
// }

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import com.inventory.Book;
import com.inventory.Journal;
import com.inventory.NonFiction;
import com.inventory.Novel;


public class MainApp extends Application {

    private ListView<Book> cartList = new ListView<>();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private Catalogue catalogue = new Catalogue();
    private Label totalLabel;
    private VBox cartListVBox;

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainLayout = new BorderPane();

        Button showCartButton = new Button("Show Cart");
        showCartButton.setOnAction(e -> {
            updateCartListView();
            updateCartTotal();
            cartListVBox.setVisible(!cartListVBox.isVisible());
        });

        totalLabel = new Label("Total: $0.00");
        cartListVBox = new VBox(new Label("Shopping Cart:"), cartList, totalLabel);
        cartListVBox.setVisible(false);

        Label catalogueLabel = new Label("PRODUCT CATALOGUE");

        catalogueLabel.setFont(new Font(16)); 
        mainLayout.setTop(catalogueLabel);

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
            productGrid.setHgap(3); // Replace 10 with your desired horizontal gap
            productGrid.setVgap(3);
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

        mainLayout.setCenter(productGridPane);
        mainLayout.setRight(cartListVBox);

        mainLayout.setBottom(showCartButton);

        Scene scene = new Scene(mainLayout, 800, 800);
        primaryStage.setTitle("Shopping Platform");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private void updateCartListView() {
        cartList.getItems().setAll(shoppingCart.getCartItems());
    }

    private void updateCartTotal() {
        double total = shoppingCart.calculateTotal();
        String display = "Total: $" + String.format("%.2f", total);
        totalLabel.setText(display);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
