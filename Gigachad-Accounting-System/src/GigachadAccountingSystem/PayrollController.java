package GigachadAccountingSystem;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PayrollController {
    @FXML
    private Label showID;

    @FXML
    private Label showName;

    @FXML
    private Label showDate;

    @FXML
    private Label showDep;

    @FXML
    private Label showBal;

    @FXML
    private Label basicR;

    @FXML
    private Label overT;

    @FXML
    private Label allowance;

    @FXML
    private Label others;

    @FXML
    private Label total;

    @FXML
    private Label sss;

    @FXML
    private Label pagibig;

    @FXML
    private Label philhealth;

    @FXML
    private Label absent;

    @FXML
    private Label otherDeduc;

    @FXML
    private Label totalDeduc;

    @FXML
    private Label totalNet;

    @FXML
    private Button printButton;

    @FXML
    private TableView<PayrollModel> payrollTable;

    @FXML
    private TableColumn<PayrollModel, String> dateColumn;

    @FXML
    private TableColumn<PayrollModel, String> accountNameColumn;

    @FXML
    private TableColumn<PayrollModel, String> journalEntryReferenceColumn;

    @FXML
    private TableColumn<PayrollModel, String> descriptionColumn;

    @FXML
    private TableColumn<PayrollModel, Double> debitColumn;

    @FXML
    private TableColumn<PayrollModel, Double> creditColumn;

    @FXML
    private TableColumn<PayrollModel, Double> balanceColumn;

    @FXML
    private TableColumn<PayrollModel, String> postingReferenceColumn;

    @FXML
    private TableColumn<PayrollModel, String> currencyColumn;

    @FXML
    private TableColumn<PayrollModel, String> departmentColumn;

    @FXML
    private TableColumn<PayrollModel, String> approvalStatusColumn;

    @FXML
    private TableColumn<PayrollModel, String> notesColumn;

    private ObservableList<PayrollModel> payrollData = FXCollections.observableArrayList();

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

        // Add listener for table row selection
        payrollTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showDetails(newValue)
        );
    }

    private void loadDataFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/accounting_sys"; // Update with your database URL
        String user = "root"; // Update with your database username
        String password = ""; // Update with your database password

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ledger")) {

            while (resultSet.next()) {
                PayrollModel payrollModel = new PayrollModel(
                        resultSet.getInt("id"),
                        resultSet.getDouble("overTime"),
                        resultSet.getDouble("allowances"),
                        resultSet.getDouble("absences"),
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
                payrollData.add(payrollModel);
            }

            payrollTable.setItems(payrollData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to show details in the labels
    private void showDetails(PayrollModel payrollModel) {
        if (payrollModel != null) {
            showID.setText(String.valueOf(payrollModel.getid()));
            showName.setText(payrollModel.getAccountName());
            showDate.setText(payrollModel.getDate());
            showDep.setText(payrollModel.getDepartment());
            showBal.setText(String.valueOf(payrollModel.getBalance()));

            double basicRate = payrollModel.getBalance(); 
            double overtime = payrollModel.getoverTime(); 
            double allowances = payrollModel.getAllowances(); 
            double otherPayments = 0; 

            basicR.setText(String.valueOf(basicRate));
            overT.setText(String.valueOf(overtime));
            allowance.setText(String.valueOf(allowances));
            others.setText(String.valueOf(otherPayments));

            double totalPayment = basicRate + overtime + allowances + otherPayments;
            total.setText(String.valueOf(totalPayment));
            
            double sssAmount = 2500;
            double pagibigAmount = 3000;
            double philhealthAmount = 4000;
            double absentDeductions = payrollModel.getAbsences();
            double otherDeductions = 0;

            sss.setText(String.valueOf(sssAmount));
            pagibig.setText(String.valueOf(pagibigAmount));
            philhealth.setText(String.valueOf(philhealthAmount));
            absent.setText(String.valueOf(absentDeductions));
            otherDeduc.setText(String.valueOf(otherDeductions));

            double totalDeductions = sssAmount + pagibigAmount + philhealthAmount + absentDeductions + otherDeductions;
            totalDeduc.setText(String.valueOf(totalDeductions));

            double netTotalAmount = totalPayment - totalDeductions;
            totalNet.setText(String.valueOf(netTotalAmount));
        } else {
            clearLabels();
        }
    }

    private void clearLabels() {
        showID.setText("");
        showName.setText("");
        showDate.setText("");
        showDep.setText("");
        showBal.setText("");
        basicR.setText("");
        overT.setText("");
        allowance.setText("");
        others.setText("");
        total.setText("");
        sss.setText("");
        pagibig.setText("");
        philhealth.setText("");
        absent.setText("");
        otherDeduc.setText("");
        totalDeduc.setText("");
        totalNet.setText("");
    }

     @FXML
    private void handlePrintAction() {
        File pdfFile = savePayslipAsPDF(); // Save the payslip as PDF
        if (pdfFile != null && pdfFile.exists()) {
            showPDF(pdfFile); // Show the PDF after it's saved
        }
    }

    private File savePayslipAsPDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Payslip as PDF");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        File file = fileChooser.showSaveDialog(null);

        if (file != null) {
            Document document = new Document();

            try {
                PdfWriter.getInstance(document, new FileOutputStream(file));
                document.open();

                document.add(new Paragraph("Employee ID: " + showID.getText()));
                document.add(new Paragraph("Employee Name: " + showName.getText()));
                document.add(new Paragraph("Date: " + showDate.getText()));
                document.add(new Paragraph("Department: " + showDep.getText()));
                document.add(new Paragraph("Basic Rate: " + basicR.getText()));
                document.add(new Paragraph("Overtime: " + overT.getText()));
                document.add(new Paragraph("Allowances: " + allowance.getText()));
                document.add(new Paragraph("Other Payments: " + others.getText()));
                document.add(new Paragraph("Total Payment: " + total.getText()));
                document.add(new Paragraph("SSS: " + sss.getText()));
                document.add(new Paragraph("Pag-IBIG: " + pagibig.getText()));
                document.add(new Paragraph("PhilHealth: " + philhealth.getText()));
                document.add(new Paragraph("Absent Deductions: " + absent.getText()));
                document.add(new Paragraph("Other Deductions: " + otherDeduc.getText()));
                document.add(new Paragraph("Total Deductions: " + totalDeduc.getText()));
                document.add(new Paragraph("Net Total: " + totalNet.getText()));

                document.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    private void showPDF(File pdfFile) {
        if (pdfFile != null && pdfFile.exists()) {
            try {
                Desktop.getDesktop().open(pdfFile); // Open the PDF file
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}