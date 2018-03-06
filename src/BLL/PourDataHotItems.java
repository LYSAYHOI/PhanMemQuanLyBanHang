/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minhh
 */
public class PourDataHotItems {
    String to,from;
    private String[] Params;
    private int[] TypeParam;
    Vector vector;
    ResultSet rs=null;
    DefaultTableModel defaultmodel;
    Connect con;
    //Constructor
      public PourDataHotItems( DefaultTableModel defaultmodel, String from, String to) {
        this.defaultmodel = defaultmodel;  
        this.to=to;
        this.from=from;
    }
    //Method
      public DefaultTableModel defaultmodel() {  //Method to default Jtable Model
        vector= new Vector();
        Object[] rowData=new Object[3];
        con = new Connect();
        Params = new String[]{from,to};
        TypeParam = new int[]{3,3};
        
        String IDtems,ItemName;
        int Total;
        
        //
        try{
        rs=con.myExecuteSP("{call dbo.topitem(?,?)}", Params, TypeParam);
        while(rs.next()){
            IDtems = rs.getString("IDHang");
            ItemName = rs.getString("TenHang");
            Total = rs.getInt("SoLuong");
         
            vector.addElement(new ClassTopItem(IDtems,ItemName,Total));
        }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu table");
        }
        //Lists of Vector pour to DefaultModelTable
        for(int i=0;i<vector.size();i++){
            ClassTopItem temp= (ClassTopItem)vector.elementAt(i);
            rowData[0]=temp.IDtems;
            rowData[1]=temp.ItemName;
            rowData[2]=temp.Total;
            defaultmodel.addRow(rowData);
        }
        return defaultmodel;
      }
}

