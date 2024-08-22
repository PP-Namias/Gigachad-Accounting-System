package GigachadAccountingSystem;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LedgerModel {
    private final StringProperty date;
    private final StringProperty accountName;
    private final StringProperty journalEntryReference;
    private final StringProperty description;
    private final DoubleProperty debit;
    private final DoubleProperty credit;
    private final DoubleProperty balance;
    private final StringProperty postingReference;
    private final StringProperty currency;
    private final StringProperty department;
    private final StringProperty approvalStatus;
    private final StringProperty notes;

    public LedgerModel(String date, String accountName, String journalEntryReference, String description,
                       Double debit, Double credit, Double balance, String postingReference, String currency,
                       String department, String approvalStatus, String notes) {
        this.date = new SimpleStringProperty(date);
        this.accountName = new SimpleStringProperty(accountName);
        this.journalEntryReference = new SimpleStringProperty(journalEntryReference);
        this.description = new SimpleStringProperty(description);
        this.debit = new SimpleDoubleProperty(debit);
        this.credit = new SimpleDoubleProperty(credit);
        this.balance = new SimpleDoubleProperty(balance);
        this.postingReference = new SimpleStringProperty(postingReference);
        this.currency = new SimpleStringProperty(currency);
        this.department = new SimpleStringProperty(department);
        this.approvalStatus = new SimpleStringProperty(approvalStatus);
        this.notes = new SimpleStringProperty(notes);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public StringProperty accountNameProperty() {
        return accountName;
    }

    public StringProperty journalEntryReferenceProperty() {
        return journalEntryReference;
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public DoubleProperty debitProperty() {
        return debit;
    }

    public DoubleProperty creditProperty() {
        return credit;
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public StringProperty postingReferenceProperty() {
        return postingReference;
    }

    public StringProperty currencyProperty() {
        return currency;
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public StringProperty approvalStatusProperty() {
        return approvalStatus;
    }

    public StringProperty notesProperty() {
        return notes;
    }
}