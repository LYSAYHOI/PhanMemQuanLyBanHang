/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author minhh
 */
public class PourDataOnComboBox {
    private String[] Params;
    private int[] TypeParam; String variable;
    public static ResultSet rs=null;//Kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu 
    public  Connect con;//Lấy từ lớp cơ bản kết nối Data
    DefaultComboBoxModel defaultcomboBox ;
  
    //Contructors
    public PourDataOnComboBox(String variable) {
        this.variable=variable;
    }
   
    public DefaultComboBoxModel defaultcomboBox(){
        defaultcomboBox =new DefaultComboBoxModel();
        con = new Connect();
        Params = new String[]{variable};
        TypeParam = new int[]{1};
        try{
        rs=con.myExecuteSP("{call getComboBox(?)}",Params, TypeParam);     
        if(variable=="1") //combobox NPP
            while(rs.next()){
               defaultcomboBox.addElement(new ClassComboBox(rs.getString("IDNPP"),rs.getString("TenNPP")));//id được lấy từ csdl
            }
        else
            while(rs.next()){
                defaultcomboBox.addElement(new ClassComboBox(rs.getString("IDLoaiHang"),rs.getString("TenLoaiHang")));//id được lấy từ csdl
            }
    }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu ComboBox","Bao Loi query",1);
        }        
    return defaultcomboBox;
    }
}
