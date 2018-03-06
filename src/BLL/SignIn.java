/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.ResultSet;
import DAL.Connect;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author lsayh
 */
//class làm nhiệm vụ đăng nhập
public class SignIn {
 private String[] Params;
    private int[] TypeParam; String variable;
    public static ResultSet rs=null;//Kết quả trả về dạng 1 bảng hay 1 dòng dữ liệu 
    public  Connect con;//Lấy từ lớp cơ bản kết nối Data
    DefaultComboBoxModel defaultcomboBox ;
    //thực hiện lấy thông tin Ip User name, ten database
    //biến flag để đánh dấu đã xác thực đăng nhập vào server hay chưa
    //các bước đăng nhập 1: xác thực đăng nhập server
    //2: chọn database rồi bắt đầu sử dụng
    public int connect(String IP, String User, String Pass, int flag, String Database) {
        
            Connect con = new Connect();
            if(con.dynamicConnect(IP, User, Pass, flag, Database) == 1)
                return 1;
        return 0;
    }
    //method thực hiện lấy danh sách database có trong server đã đăng nhập trước đó
    public DefaultComboBoxModel takeDBMS() {
        defaultcomboBox = new DefaultComboBoxModel();
        con = new Connect();

        try {
            rs = con.myExecutePrepareStatement("select name from sys.databases");
            while (rs.next()) {
                defaultcomboBox.addElement(rs.getString("name"));//id được lấy từ csdl
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi lấy dữ liệu ComboBox", "Bao Loi query", 1);
        }
        return defaultcomboBox;
    }
    //method thực hiện lấy thông tin của người đăng nhập có user name và password được nhập vào
    //kết quả được chứa trong biến info
    public void getRole(String UserName,String Password, ClassLoginInfo Info){
        con = new Connect();
        Vector info = new Vector();
        con.myExecuteFuncReturnDoubleValue("{call spGetLoginInfo(?,?,?,?)}", UserName, Password, info);
        Info.setName(String.valueOf(info.get(0)));
        Info.setRole(Integer.parseInt(String.valueOf(info.get(1))));
    }
}
