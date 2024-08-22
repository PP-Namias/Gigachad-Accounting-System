package GigachadAccountingSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class HomeController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private Label ledgerLabel;
    
    @FXML
    private VBox pnl_scroll;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshNodes();
        
        // Add event handler for ledgerLabel
        ledgerLabel.setOnMouseClicked(this::handleLedgerLabelClick);
    }    
    
    private void refreshNodes() {
        pnl_scroll.getChildren().clear();
        
        Node[] nodes = new Node[15];
        
        for (int i = 0; i < 10; i++) {
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource("/GigachadAccountingSystem/Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
    private void handleLedgerLabelClick(MouseEvent event) {
        try {
            String fxmlPath = "/GigachadAccountingSystem/Ledger.fxml";
            System.out.println("Loading FXML: " + fxmlPath);
            Node ledgerNode = FXMLLoader.load(getClass().getResource(fxmlPath));
            pnl_scroll.getChildren().clear();
            pnl_scroll.getChildren().add(ledgerNode);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}