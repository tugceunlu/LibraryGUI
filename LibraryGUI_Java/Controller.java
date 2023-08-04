import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Controller {

    private ObservableList<Item> catalog = FXCollections.observableArrayList();

    @FXML
    private ListView<Item> itemListView;

    @FXML
    private void initialize() {
        Book book = new Book("The Great Gatsby", 1925, "F. Scott Fitzgerald");
        catalog.add(book);

        Magazine magazine = new Magazine("National Geographic", 1888, "National Geographic Society");
        catalog.add(magazine);

        itemListView.setItems(catalog);
    }

    @FXML
    private void addItem() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Item");
        dialog.setHeaderText(null);
        dialog.setContentText("Enter the item title:");
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(title -> {
            TextInputDialog yearDialog = new TextInputDialog();
            yearDialog.setTitle("Add Year");
            yearDialog.setHeaderText(null);
            yearDialog.setContentText("Enter the item year:");
            Optional<String> yearResult = yearDialog.showAndWait();
            yearResult.ifPresent(yearStr -> {
                int year;
                try {
                    year = Integer.parseInt(yearStr);
                    TextInputDialog typeDialog = new TextInputDialog();
                    typeDialog.setTitle("Add Type");
                    typeDialog.setHeaderText(null);
                    typeDialog.setContentText("Enter the item type (Book/Magazine):");
                    Optional<String> typeResult = typeDialog.showAndWait();
                    typeResult.ifPresent(type -> {
                        if (type.equalsIgnoreCase("Book")) {
                            TextInputDialog authorDialog = new TextInputDialog();
                            authorDialog.setTitle("Add Author");
                            authorDialog.setHeaderText(null);
                            authorDialog.setContentText("Enter the author name:");
                            Optional<String> authorResult = authorDialog.showAndWait();
                            authorResult.ifPresent(author -> {
                                Book newBook = new Book(title, year, author);
                                catalog.add(newBook);
                            });
                        } else if (type.equalsIgnoreCase("Magazine")) {
                            TextInputDialog publisherDialog = new TextInputDialog();
                            publisherDialog.setTitle("Add Publisher");
                            publisherDialog.setHeaderText(null);
                            publisherDialog.setContentText("Enter the publisher name:");
                            Optional<String> publisherResult = publisherDialog.showAndWait();
                            publisherResult.ifPresent(publisher -> {
                                Magazine newMagazine = new Magazine(title, year, publisher);
                                catalog.add(newMagazine);
                            });
                        }
                    });
                } catch (NumberFormatException e) {
                    // Handle invalid year input
                }
            });
        });
    }

    @FXML
    private void deleteItem() {
        Item selectedItem = itemListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            catalog.remove(selectedItem);
        }
    }
}
