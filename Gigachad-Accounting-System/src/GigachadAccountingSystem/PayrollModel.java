package GigachadAccountingSystem;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PayrollModel {
    private final int id;
    private final DoubleProperty allowances;
    private final DoubleProperty overTime;
    private final DoubleProperty absences;
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

    public PayrollModel(int id,  Double overTime, Double allowances, Double absences, String date, String accountName, String journalEntryReference, String description,
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
        this.overTime = new SimpleDoubleProperty(overTime);
        this.allowances = new SimpleDoubleProperty(allowances);
        this.absences = new SimpleDoubleProperty(absences);
        this.id = id;
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

    
    public DoubleProperty overTimeProperty() {
        return overTime;
    }

    public DoubleProperty allowancesProperty() {
        return allowances;
    }

    public DoubleProperty absencesProperty() {
        return absences;
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
    public int getid() {
      return id;
    }
    public String getDate() {
        return date.get();
    }

    public String getAccountName() {
        return accountName.get();
    }

    public String getJournalEntryReference() {
        return journalEntryReference.get();
    }

    public String getDepartment() {
        return department.get();
    }

    public double getBalance() {
        return balance.get();
    }

    public double getoverTime() {
        return overTime.get();
    }

     public double getAllowances() {
        return allowances.get();
    }

      public double getAbsences() {
        return absences.get();
    }

}
