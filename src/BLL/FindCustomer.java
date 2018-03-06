/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.ResultSet;
import DAL.Connect;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author lsayh
 */
//class chứa số điện thoại khách hàng để thực hiện tìm kiếm thông qua số điện thoại
public class FindCustomer {
    private String SDTorCMND;
    ResultSet rs=null;
    Connect con;
    private String[] Params;
    private int[] TypeParam;
    public FindCustomer(String SDTorCMND){
        this.SDTorCMND=SDTorCMND;
        con= new Connect();
        
    }
    //method thực hiện lấy(select) các thông tin của khách hàng tìm được
    //hoạt động select này trả về một bảng chứa thông tin khách hàng như: tên khách hàng, SDT, CMND, Dịa chỉ
    //method gọi procedure SpFindKhachHang
    public List getInfo() {
        List<String> info = new ArrayList<String>();
        Params = new String[]{SDTorCMND};
        TypeParam = new int[]{3};
        rs = con.myExecuteSP("{call SpFindKhachHang(?) }", Params, TypeParam);
        try {
            while (rs.next()) {
                info.add(rs.getString("TenKhachHang"));
                info.add(rs.getString("SDT"));
                info.add(rs.getString("CMND"));
                info.add(rs.getString("DiaChi"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return info;
    }
}
