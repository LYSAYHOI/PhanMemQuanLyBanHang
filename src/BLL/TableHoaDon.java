/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import DAL.*;
import javax.swing.JOptionPane;
/**
 *
 * @author lsayh
 */
//class chứa thông tin về hàng như tên hàng, giá bán lẻ, số lượng đang được khách hàng đưa vào giỏ hàng
public class TableHoaDon{
    Vector data;
    Connect conn;
    private String[] Params;
    private int[] TypeParam;
    ResultSet rs;
    DefaultTableModel model;
    public TableHoaDon(DefaultTableModel model)
    {
        this.model=model;
        int rowcount=this.model.getRowCount();
        for(int i=0;i<rowcount;i++){
            this.model.removeRow(rowcount-i-1);
        }
    }
    //method thực hiện lấy thông tin các hóa đơn theo từ khóa tìm kiếm
    //method trả về biến DefaultTableModel với key tìm kiếm và option xác định đối tượng cần tìm
    //cụ thể 0: không tìm kiếm gì cả| 1: tìm theo id hóa đơn| 2: tìm theo khách hàng| 3: tìm theo nhân viên
    //method gọi procedure SpGetHoaDon
    //method lấy hết thông tin từ kết quả sau khi gọi procedure đưa hết vào biên vector data
    //sau đó từ biến data đổi dữ liệu vào biến DefaultTableModel model
    public DefaultTableModel model(String Key, int Option) {    //truyền biến option vào stored procedures
        data= new Vector();                                     //0: không tìm kiếm gì cả   1: tìm theo id hóa đơn
        Object[] rowData=new Object[5];                         //2: tìm theo khách hàng    3: tìm theo nhân viên
        conn = new Connect();
        String IDHoaDon, NgayMua, TenKhachhang, TenNhanVien;
        double TongThanhToan;
        Params = new String[]{Key,String.valueOf(Option)};
        TypeParam = new int[]{3,1};
        try{
        rs=conn.myExecuteSP("{call SpGetHoaDon(?,?)}", Params, TypeParam);
        while(rs.next()){
            IDHoaDon = rs.getString("IDHoaDonMuaHang");
            TongThanhToan = rs.getDouble("TongThanhToan");
            NgayMua = rs.getString("NgayMua");
            TenKhachhang = rs.getString("TenKhachHang");
            TenNhanVien = rs.getString("TenNhanVien");
            
            data.addElement(new ClassHoaDon(IDHoaDon, TongThanhToan, NgayMua, TenKhachhang, TenNhanVien));
            //rowData[0] = new ClassHoaDon(IDHoaDon, TongThanhToan, NgayMua, TenKhachhang, TenNhanVien);
        }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu table");
        }
        for(int i=0;i<data.size();i++){
            ClassHoaDon temp= (ClassHoaDon)data.elementAt(i);
            rowData[0]=temp.IDHoaDon;
            rowData[1]=temp.TongThanhToan;
            rowData[2]=temp.NgayMua;
            rowData[3]=temp.TenKhachhang;
            rowData[4]=temp.TenNhanVien;
            model.addRow(rowData);
        }
        return model;
    }
}
