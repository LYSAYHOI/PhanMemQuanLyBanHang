/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connect;
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
public class SearchItems {
    
    private String[] Params;
    private int[] TypeParam;
    String searchtext,columsearch;
    //
    Vector vector;
    ResultSet rs=null;
    DefaultTableModel defaultmodel;
    Connect con;
    //
    public SearchItems(DefaultTableModel defaultmodel,String searchtext,String columsearch ) {
        this.searchtext = searchtext;
        this.columsearch = columsearch;
        this.defaultmodel = defaultmodel;      
    }
    public DefaultTableModel  Find()
    {  
        vector= new Vector();
        Object[] rowData=new Object[9];
        con = new Connect();
        Params=new String[]{searchtext,columsearch};
        TypeParam = new int[]{3,3};
        //
        String IDHang,TenHang,ThongSoKyThuat,TenLoaiHang,TenNPP;
        byte[] Hinh;
        BigDecimal Giabanle,gianhap;
        int SoLuong;
        try{
        rs=con.myExecuteSP("{call dbo.Findelement(?,?)}", Params, TypeParam);
        while(rs.next()){
            IDHang = rs.getString("IDHang");
            TenHang = rs.getString("TenHang");
            ThongSoKyThuat = rs.getString("ThongSoKyThuat");
            Hinh = rs.getBytes("Hinh");
            Giabanle = rs.getBigDecimal("Giabanle");
            SoLuong=rs.getInt("SoLuong");         
            TenNPP= rs.getString("TenNPP") ; 
            TenLoaiHang = rs.getString("TenLoaiHang");
            gianhap=rs.getBigDecimal("GiaNhap");
                   
            //
            vector.addElement(new ClassItems(IDHang, TenHang,TenLoaiHang, TenNPP, Giabanle,SoLuong,ThongSoKyThuat, Hinh,gianhap));
        }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu table");
        }
        //Lists of Vector pour to DefaultModelTable
        for(int i=0;i<vector.size();i++){
            ClassItems temp= (ClassItems)vector.elementAt(i);
            rowData[0]=temp.IDHang;
            rowData[1]=temp.TenHang;
            rowData[2]=temp.TenLoaiHang;
            rowData[3]=temp.TenNPP;
            rowData[4]=temp.Giabanle;
            rowData[5]=temp.gianhap;
            rowData[6]=temp.SoLuong;
            rowData[7]=temp.ThongSoKyThuat;
            rowData[8]=temp.Hinh;
            defaultmodel.addRow(rowData);
        }
        return defaultmodel;
    }
}
