import com.inventory.Book;
import com.inventory.Journal;
import com.inventory.NonFiction;
import com.inventory.Novel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Catalogue {
    private ObservableList<Book> products = FXCollections.observableArrayList();

    public Catalogue() {
        
        products.add(new Journal("Scientific Discoveries", 29.99, "Dr. John Smith", "ISBN123", 1));
        products.add(new Journal("Mind Matters",29.99, "Dr. Leo Lenz", "ISBN123", 6));
        products.add(new Journal("Tech Trends",24.99, "Sarah Engineer", "ISBN456", 2));
        products.add(new Journal("Medical Breakthroughs",34.99, "Dr. Emily Brown", "ISBN789", 3));
        products.add(new Journal("Nature Insights", 27.99, "Dr. Robert Johnson", "ISBN101", 4));
        products.add(new NonFiction("The Universe and Beyond", 19.99, "Dr. Alice Smith", "ISBN111", "Cosmology"));
        products.add(new NonFiction("Economics of the 21st Century", 24.99, "Professor James Brown", "ISBN222", "Economics"));
        products.add(new NonFiction("Healthy Living Guide", 14.99, "Dr. Emily White", "ISBN333", "Health & Wellness"));
        products.add(new NonFiction("Computer Science Fundamentals ", 29.99, "Professor John Lee", "ISBN444", "Computer Science"));
        products.add(new NonFiction("History of Ancient Civilizations ",22.99, "Historian Sarah Adams", "ISBN555", "History"));
        products.add(new Novel("Mystery at Moonlight Mansion ", 12.99, "Jane Smith", "ISBN111", "Mystery"));
        products.add(new Novel("The Lost Kingdom", 14.99, "John Doe", "ISBN222", "Fantasy"));
        products.add(new Novel("Space Odyssey", 11.99, "David Johnson", "ISBN333", "Science Fiction"));
        products.add(new Novel("The Hidden Treasure", 13.99, "Emily White", "ISBN444", "Historical Fiction"));
        products.add(new Novel("Romantic Escapade: Love in Paris", 10.99, "Sarah Adams", "ISBN555", "Romance"));
    }

    public ObservableList<Book> getProducts() {
        return products;
    }

}


