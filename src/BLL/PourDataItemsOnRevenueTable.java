/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.*;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author minhh
 */
public class PourDataItemsOnRevenueTable {
    String to,from;
    private String[] Params;
    private int[] TypeParam;
    Vector vector;
    ResultSet rs=null;
    DefaultTableModel defaultmodel;
    Connect con;
    //Constructor
      public PourDataItemsOnRevenueTable( DefaultTableModel defaultmodel,String from, String to) {
        this.defaultmodel = defaultmodel;  
         this.to=to;
        this.from=from;
    }
    //Method
      public DefaultTableModel defaultmodel() {  //Method to default Jtable Model
        vector= new Vector();
        Object[] rowData=new Object[5];
        con = new Connect();
         Params = new String[]{from,to};
        TypeParam = new int[]{3,3};
        
        String IDHoaDonMuaHang,TenNhanVien,TenKhachHang,NgayMua;
        BigDecimal TongThanhToan; 
        //
        try{
        rs=con.myExecuteSP("{call revenue(?,?)}", Params, TypeParam);
        while(rs.next()){
            IDHoaDonMuaHang= rs.getString("IDHoaDonMuaHang");
            TenNhanVien= rs.getString("TenNhanVien");
            TenKhachHang = rs.getString("TenKhachHang");
            NgayMua= rs.getString("NgayMua");
            TongThanhToan = rs.getBigDecimal("TongThanhToan");
     
            //
            vector.addElement(new Classrevenue( IDHoaDonMuaHang, TenNhanVien, TenKhachHang,  NgayMua, TongThanhToan ));
        }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu table");
        }
        //Lists of Vector pour to DefaultModelTable
        for(int i=0;i<vector.size();i++){
            Classrevenue temp= (Classrevenue)vector.elementAt(i);
            rowData[0]=temp.IDHoaDonMuaHang;
            rowData[1]=temp.TenNhanVien;
            rowData[2]=temp.TenKhachHang;
            rowData[3]=temp.NgayMua;
            rowData[4]=temp.TongThanhToan;
            defaultmodel.addRow(rowData);
        }
        return defaultmodel;
    }
}
