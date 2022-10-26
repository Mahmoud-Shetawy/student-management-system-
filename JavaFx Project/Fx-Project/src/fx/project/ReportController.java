/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 *
 * @author ok
 */
public class ReportController implements Initializable {
@FXML
private void handleButtonAction3(ActionEvent event) {
    try {
        // close current
        Node p=(Node) event.getSource();
        Stage p1=(Stage) p.getScene().getWindow();
        p1.close();
        // open new
        Stage st=new Stage();
        Parent pr = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
        Scene scene = new Scene(pr);
        st.setScene(scene);
        st.setTitle("Home Page");  
        st.show();
    } catch (IOException ex) {
        Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
}
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }

}
