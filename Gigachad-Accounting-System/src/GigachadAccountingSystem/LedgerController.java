package GigachadAccountingSystem;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LedgerController {

    @FXML
    private TableView<LedgerModel> ledgerTable;

    @FXML
    private TableColumn<LedgerModel, String> dateColumn;

    @FXML
    private TableColumn<LedgerModel, String> accountNameColumn;

    @FXML
    private TableColumn<LedgerModel, String> journalEntryReferenceColumn;

    @FXML
    private TableColumn<LedgerModel, String> descriptionColumn;

    @FXML
    private TableColumn<LedgerModel, Double> debitColumn;

    @FXML
    private TableColumn<LedgerModel, Double> creditColumn;

    @FXML
    private TableColumn<LedgerModel, Double> balanceColumn;

    @FXML
    private TableColumn<LedgerModel, String> postingReferenceColumn;

    @FXML
    private TableColumn<LedgerModel, String> currencyColumn;

    @FXML
    private TableColumn<LedgerModel, String> departmentColumn;

    @FXML
    private TableColumn<LedgerModel, String> approvalStatusColumn;

    @FXML
    private TableColumn<LedgerModel, String> notesColumn;

    @FXML
    private Button addEntryButton;

    @FXML
    private Button removeEntryButton;

    private ObservableList<LedgerModel> ledgerData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Initialize the columns with appropriate data
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        accountNameColumn.setCellValueFactory(cellData -> cellData.getValue().accountNameProperty());
        journalEntryReferenceColumn.setCellValueFactory(cellData -> cellData.getValue().journalEntryReferenceProperty());
        descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        debitColumn.setCellValueFactory(cellData -> cellData.getValue().debitProperty().asObject());
        creditColumn.setCellValueFactory(cellData -> cellData.getValue().creditProperty().asObject());
        balanceColumn.setCellValueFactory(cellData -> cellData.getValue().balanceProperty().asObject());
        postingReferenceColumn.setCellValueFactory(cellData -> cellData.getValue().postingReferenceProperty());
        currencyColumn.setCellValueFactory(cellData -> cellData.getValue().currencyProperty());
        departmentColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        approvalStatusColumn.setCellValueFactory(cellData -> cellData.getValue().approvalStatusProperty());
        notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());

        // Load data from the database
        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/accounting_sys"; // Update with your database URL
        String user = "root"; // Update with your database username
        String password = ""; // Update with your database password

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ledger")) {

            while (resultSet.next()) {
                LedgerModel ledgerModel = new LedgerModel(
                        resultSet.getString("date"),
                        resultSet.getString("accountName"),
                        resultSet.getString("journalEntryReference"),
                        resultSet.getString("description"),
                        resultSet.getDouble("debit"),
                        resultSet.getDouble("credit"),
                        resultSet.getDouble("balance"),
                        resultSet.getString("postingReference"),
                        resultSet.getString("currency"),
                        resultSet.getString("department"),
                        resultSet.getString("approvalStatus"),
                        resultSet.getString("notes")
                );
                ledgerData.add(ledgerModel);
            }

            ledgerTable.setItems(ledgerData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addEntry() {
        // Handle adding a new entry
    }

    @FXML
    private void removeEntry() {
        // Handle removing an entry
    }
}