/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ok
 */
public class ScoreFXMLController implements Initializable {
    @FXML

    TextField s1,s2,s3,s4,s5,s6,g1,g2,g3,g4,g5,g6,n,gn,gl;
    Connection con;
 ConDataBase oC = new ConDataBase();


  @FXML
    private void handleButton2Action(ActionEvent event) {
        try {
            // close current
            Node p = (Node) event.getSource();
            Stage p1 = (Stage) p.getScene().getWindow();
            p1.close();
            // open new
            Stage st = new Stage();
            Parent pr = FXMLLoader.load(getClass().getResource("HomeFXML.fxml"));
            Scene scene = new Scene(pr);
            st.setScene(scene);
            st.setTitle("Home Page");
            st.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 @FXML
 public void search() {
        int idx = Integer.parseInt(n.getText());
        String sql2 = "select * from student where id = " + idx;
        ResultSet obj;
        String name = "";
         String lev="";
        try {
            con = oC.open();
            Statement stat = con.createStatement();
            obj = stat.executeQuery(sql2);

            obj.toString();

            while (obj.next()) {
                name = obj.getString(2);
                lev=obj.getString(7);
            }

            con.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Student Is Not Found");

        }
        if (name != "") {
             gn.setDisable(false); gl.setDisable(false);
      s1.setDisable(false); s2.setDisable(false);s3.setDisable(false);
      s4.setDisable(false);s5.setDisable(false);s6.setDisable(false);
      g1.setDisable(false); g2.setDisable(false); g3.setDisable(false);
      g4.setDisable(false); g5.setDisable(false); g6.setDisable(false);
            gn.setText(name); gl.setText(lev);




        }


        else {
            JOptionPane.showMessageDialog(null, "Error Student Is Not Found");
            n.setText("");
        }
    }

    @FXML
 public void insert() throws SQLException {
      int name=Integer.parseInt(n.getText());
      String id=n.getText();
     String su1=s1.getText();
         String su2=s2.getText();
           String su3=s3.getText();
         String su4=s4.getText();
         String su5=s5.getText();
         String su6=s6.getText();

  int gr1 = Integer.parseInt(g1.getText().substring(0, g1.getText().indexOf("%")));//
        int gr2 = Integer.parseInt(g2.getText().substring(0, g2.getText().indexOf("%")));//
        int gr3 = Integer.parseInt(g3.getText().substring(0, g3.getText().indexOf("%")));//
        int gr4 = Integer.parseInt(g4.getText().substring(0, g4.getText().indexOf("%")));//
        int gr5 = Integer.parseInt(g5.getText().substring(0, g5.getText().indexOf("%")));//
        int gr6 = Integer.parseInt(g6.getText().substring(0, g6.getText().indexOf("%")));//
        String G1=g1.getText();
        String G2=g2.getText();
        String G3=g3.getText();
        String G4=g4.getText();
        String G5=g5.getText();
        String G6=g6.getText();

           int arr[]={0,0,0,0,0,0};
        arr[0]=gr1; arr[1]=gr2; arr[2]=gr3; arr[3]=gr4; arr[4]=gr5; arr[5]=gr6;
            int x=6;
    double sum=0.0,s=0;
  for(int i=0;i<x;i++){

        if (arr[i] >= 90)
            sum+= 4;
        else if (arr[i] >= 85)
            sum+= 3.7;
        else if (arr[i] >= 80)
            sum+= 3.3;
        else if (arr[i] >= 75)
            sum+= 3;
        else if (arr[i]  >= 70)
            sum+= 2.7;
        else if (arr[i]  >= 65)
            sum+= 2.4;
        else if (arr[i] >= 60)
            sum+= 2.2;
        else if (arr[i] >= 50)
            sum+= 2;
        else
            sum+= 0;
    }
    double GPAsum = (3 * sum) / (18);

/*
        String sql7 = "update student set "
                + "gpa=" + GPAsum
                + " where id=" + n;
        try {
            con = oC.open();
            Statement stat1 = con.createStatement();
            stat1.executeUpdate(sql7);

            con.close();
            JOptionPane.showMessageDialog(null, "These Data updated successfully");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Data Not updated");
        }

 */


        String sqlg ="insert into gpa  values ("+" "+name +", "+GPAsum+")";

        try{
            con=oC.open();
            Statement stat=con.createStatement();
            stat.executeUpdate(sqlg);

            con.close();


        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error Student Not Found Can't inserted");
        }



        String sql ="insert into grade  values ("+" '"+id +"', '"+su1+"', '"+G1+"')";

        try{
        con=oC.open();
        Statement stat=con.createStatement();
        stat.executeUpdate(sql);

        con.close();


        }
         catch(SQLException ex){
              JOptionPane.showMessageDialog(null,"Error Student Not Found Can't inserted");
         }



        String sql2 ="insert into grade  values ("+" '"+id +"', '"+su2+"', '"+G2+"')";

        try{
            con=oC.open();
            Statement stat=con.createStatement();
            stat.executeUpdate(sql2);

            con.close();


        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error Student Not Found Can't inserted");
        }


        String sql3 ="insert into grade  values ("+" '"+id +"', '"+su3+"', '"+G3+"')";

        try{
            con=oC.open();
            Statement stat=con.createStatement();
            stat.executeUpdate(sql3);

            con.close();


        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error Student Not Found Can't inserted");
        }


        String sql4 ="insert into grade  values ("+" '"+id +"', '"+su4+"', '"+G4+"')";

        try{
            con=oC.open();
            Statement stat=con.createStatement();
            stat.executeUpdate(sql4);

            con.close();



        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error Student Not Found Can't inserted");
        }


        String sql5 ="insert into grade  values ("+" '"+id +"', '"+su5+"', '"+G5+"')";

        try{
            con=oC.open();
            Statement stat=con.createStatement();
            stat.executeUpdate(sql5);

            con.close();


        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error Student Not Found Can't inserted");
        }



        String sql6 ="insert into grade  values ("+" '"+id +"', '"+su6+"', '"+G6+"')";

        try{
            con=oC.open();
            Statement stat=con.createStatement();
            stat.executeUpdate(sql6);

            con.close();


        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error Student Not Found Can't inserted");
        }

        JOptionPane.showMessageDialog(null,"OK inserted");
        s1.setText("");
        s2.setText("");
        s3.setText("");
        s4.setText("");
        s5.setText("");
        s6.setText("");

        g1.setText("");
       g2.setText("");
        g3.setText("");
       g4.setText("");
       g5.setText("");
      g6.setText("");


       n.setText("");
        gn.setText("");
        gl.setText("");




        /*
        String sql2 = "update student set "
                + "gpa=" + GPAsum
                + " where id=" + n;
        try {
            con = oC.open();
            Statement stat1 = con.createStatement();
            stat1.executeUpdate(sql2);

            con.close();
            JOptionPane.showMessageDialog(null, "These Data updated successfully");


        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Data Not updated");
        }
*/

    }


    /**
     * Initializes the controller class.
     */
 //s1,s2,s3,s4,s5,s6,g1,g2,g3,g4,g5,g6,n,gn,gl
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      gn.setDisable(true); gl.setDisable(true);
      s1.setDisable(true); s2.setDisable(true);s3.setDisable(true);
      s4.setDisable(true);s5.setDisable(true);s6.setDisable(true);
      g1.setDisable(true); g2.setDisable(true); g3.setDisable(true);
      g4.setDisable(true); g5.setDisable(true); g6.setDisable(true);

    }

}
