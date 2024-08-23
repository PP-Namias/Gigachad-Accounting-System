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

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class HomeController implements Initializable {
    
    @FXML
    private Label label;

    @FXML
    private Label ledgerLabel;
    
    @FXML
    private Label payrollLabel;
    
    @FXML
    private VBox pnl_scroll;
    
    @FXML
    private Label nameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private ImageView profileImageView;

    @FXML
    private void handleButtonAction(MouseEvent event) {        
       refreshNodes();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refreshNodes();
        
        // Add event handler for ledgerLabel
        ledgerLabel.setOnMouseClicked(this::handleLedgerLabelClick);
        payrollLabel.setOnMouseClicked(this::handlePayrollLabelClick);
    }    

    private static final String DEFAULT_PROFILE_IMAGE = "default-profile.jpg";

    public void setUserDetails(String username) {
        try {
            switch (username) {
                case "PP Namias":
                    nameLabel.setText("Jhon Keneth Namias");
                    usernameLabel.setText("@PP-Namias");
                    break;
                case "Marky":
                    nameLabel.setText("Mark Relan Acedo");
                    usernameLabel.setText("@mawrk19");
                    break;
                case "Aya Ay":
                    nameLabel.setText("Lyniel Aya-ay");
                    usernameLabel.setText("@Lynlcrz");
                    break;
                case "Maki":
                    nameLabel.setText("Beltran Markchristian A");
                    usernameLabel.setText("@UrMaki");
                    break;
                case "Junfrance":
                    nameLabel.setText("Junfrance Fillarca");
                    usernameLabel.setText("@fillarcaj02");
                    break;
                default:
                    nameLabel.setText("Default Name");
                    usernameLabel.setText("@DefaultUser");
                    break;
            }
            //Image image = new Image(getClass().getResource(username + ".jpg").toExternalForm());
            //profileImageView.setImage(image);
        } catch (Exception e) {
            // Handle the error, e.g., log the exception or show a default image
            e.printStackTrace();
            //profileImageView.setImage(new Image(getClass().getResource(DEFAULT_PROFILE_IMAGE).toExternalForm()));
        }
    }

    private void refreshNodes()
    {
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

    private void handlePayrollLabelClick(MouseEvent event) {
        try {
            String fxmlPath = "/GigachadAccountingSystem/Payroll.fxml";
            System.out.println("Loading FXML: " + fxmlPath);
            Node payrollNode = FXMLLoader.load(getClass().getResource(fxmlPath));
            pnl_scroll.getChildren().clear();
            pnl_scroll.getChildren().add(payrollNode);
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

