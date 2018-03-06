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
 * @author lsayh
 */
//class chứa thông tin về hàng như tên hàng, giá bán lẻ, số lượng còn trong kho
public class TableHang {
    public class ClassTenGiaHang{
        String TenHang;
        double Gia;
        int SoLuong;
        public ClassTenGiaHang(String TenHang, double Gia, int SoLuong){
            this.Gia=Gia;
            this.TenHang=TenHang;
            this.SoLuong=SoLuong;
        }
    }
    Vector data;
    Connect conn;
    private String[] Params;
    private int[] TypeParam;
    ResultSet rs;
    DefaultTableModel model;
    public TableHang(DefaultTableModel model)
    {
        this.model=model;
    }
    //method trả về biến DefaultTableModel với key là từ khóa tìm kiếm theo tên của sản phẩm
    //nếu key = "" tức là lấy hết tất cả sản phẩm thỏa điều kiện của procedure
    //method gọi procedure SpGetSanPham
    //method lấy hết thông tin từ kết quả sau khi gọi procedure đưa hết vào biên vector data
    //sau đó từ biến data đổi dữ liệu vào biến DefaultTableModel model
    public DefaultTableModel model(String key) {    //key là từ khóa cần tìm kiếm, nếu không có yêu cầu tìm kiếm
        data = new Vector();                        //thì giá trị của từ khóa này là rỗng
        Object[] rowData = new Object[3];
        conn = new Connect();
        String TenHang;
        double Gia;
        int SoLuong;
        Params = new String[]{key};
        TypeParam = new int[]{3};
        try {
            rs = conn.myExecuteSP("{call SpGetSanPham(?)}", Params, TypeParam);
            while (rs.next()) {
                TenHang = rs.getString("TenHang");
                Gia = rs.getDouble("GiabanLe");
                SoLuong = rs.getInt("SoLuong");
                data.addElement(new ClassTenGiaHang(TenHang, Gia, SoLuong));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu table");
        }
        for (int i = 0; i < data.size(); i++) {
            ClassTenGiaHang temp = (ClassTenGiaHang) data.elementAt(i);
            rowData[0] = temp.TenHang;
            rowData[1] = temp.SoLuong;
            rowData[2] = temp.Gia;
            model.addRow(rowData);
        }
        return model;
    }
}
