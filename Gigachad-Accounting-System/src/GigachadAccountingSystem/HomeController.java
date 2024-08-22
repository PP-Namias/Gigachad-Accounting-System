/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GigachadAccountingSystem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
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
        // TODO
        
         refreshNodes();
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
        
        Node [] nodes = new  Node[15];
        
        for(int i = 0; i<10; i++)
        {
            try {
                nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
               pnl_scroll.getChildren().add(nodes[i]);
                
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
}
