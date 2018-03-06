/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author lsayh
 */
public class Connect {

    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://SAYHOI-SAMA;databaseName=QLBanHang;integratedSecurity=true";
    static final String DB_URL1 = "jdbc:sqlserver://192.168.137.53;databaseName=ShopManagement;user=member1;password=123";

    private static Connection con;
    private static String IP;
    private static String User;
    private static String Pass;
    private static String Database;
    private static int flag;

    //method nhận các thông tin cần thiết để thực hiện tìm kiếm các cơ sở dữ liệu chứa trong server
    //biến flag để đánh dấu đã xác thực đăng nhập vào server hay chưa
    //rồi sau đó 
    public int dynamicConnect(String IP, String User, String Pass, int flag, String Database) {
        this.IP = IP;
        this.User = User;
        this.Pass = Pass;
        this.flag = flag;
        if (flag >= 0) {
            this.Database = Database;
        }
        if (con() != null) {
            return 1;
        }
        return 0;
    }
    //method tạo biến connection từ các thông tin được truyền vào bằng method dynamicConnect() ở trên
    //biến flag nếu khác -1 thì sẽ tạo biến connection hoàn chỉnh
    public static Connection con() {
        try {
            Class.forName(JDBC_DRIVER);
            if (flag == -1) {
                con = DriverManager.getConnection("jdbc:sqlserver://" + IP + ";user=" + User + ";password=" + Pass);
            } else {
                con = DriverManager.getConnection("jdbc:sqlserver://" + IP + ";databaseName=" + Database + ";user=" + User + ";password=" + Pass);
            }
            //con = DriverManager.getConnection(DB_URL);
            return con;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "IP Address User Name or Password is incorrect\nplease try again", "Error message", 1);
            return null;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found", "Error message", 1);
            return null;
        }
    }

    ;
    //method thực hiện gọi Function/procedure sqlQuery chứa Query String, mảng params chứa các thông tin dạng thô (String)
    //đưa vào cho function/procedure sử lý, TypeParam là mảng theo thứ tự của quy định kiểu của params
    //cụ thể TypeParam=1 kiểu int, TypeParam=2 kiểu float, TypeParam=3 kiểu String
    //method này gọi những function/procedure trả về kiểu int
    public int returnFromFunction(String sqlQuery, String[] Params, int[] TypeParam) {
        int result = 0;
        try {
            CallableStatement Cstm = con().prepareCall(sqlQuery);
            Cstm.registerOutParameter(1, Types.INTEGER);
            for (int i = 0; i < TypeParam.length; i++) {
                if (TypeParam[i] == 1) //kiểu int
                {
                    Cstm.setInt(i + 2, Integer.parseInt(Params[i]));
                }
                if (TypeParam[i] == 2) //kiểu float
                {
                    Cstm.setFloat(i + 2, Float.parseFloat(Params[i]));
                }
                if (TypeParam[i] == 3) //kiểu String
                {
                    Cstm.setString(i + 2, Params[i]);
                }
            }
            Cstm.execute();
            result = Cstm.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi Không thể lấy dữ liệu", "Báo lỗi DAL fun", 1);
        }
        return result;
    }
    //method thực hiện gọi Function/procedure sqlQuery chứa Query String, mảng params chứa các thông tin dạng thô (String)
    //đưa vào cho function/procedure sử lý, TypeParam là mảng theo thứ tự của quy định kiểu của params
    //cụ thể TypeParam=1 kiểu int, TypeParam=2 kiểu float, TypeParam=3 kiểu String
    //method này gọi những function/procedure trả về kiểu Bigdecimal
    public BigDecimal returnDecimalFromFunction(String sqlQuery, String[] Params, int[] TypeParam) {
        BigDecimal result = new BigDecimal(0.00);
        try {
            CallableStatement Cstm = con().prepareCall(sqlQuery);
            Cstm.registerOutParameter(1, Types.DECIMAL);
            for (int i = 0; i < TypeParam.length; i++) {
                if (TypeParam[i] == 1) //kiểu int
                {
                    Cstm.setInt(i + 2, Integer.parseInt(Params[i]));
                }
                if (TypeParam[i] == 2) //kiểu float
                {
                    Cstm.setFloat(i + 2, Float.parseFloat(Params[i]));
                }
                if (TypeParam[i] == 3) //kiểu String
                {
                    Cstm.setString(i + 2, Params[i]);
                }
            }
            Cstm.execute();
            result = Cstm.getBigDecimal(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi Không thể lấy dữ liệu", "Báo lỗi DAL fun", 1);
        }
        return result;
    }
    
    //method thực hiện gọi procedure sqlQuery chứa Query String, mảng params chứa các thông tin dạng thô (String)
    //đưa vào cho procedure sử lý, TypeParam là mảng theo thứ tự của quy định kiểu của params
    //cụ thể TypeParam=1 kiểu int, TypeParam=2 kiểu float, TypeParam=3 kiểu String
    //method này gọi những procedure trả về một bảng, sử dụng biến ResultSet
    public ResultSet myExecuteSP(String sqlQuery, String[] Params, int[] TypeParam) {
        ResultSet rs = null;
        try {
            CallableStatement Cstm = con().prepareCall(sqlQuery);
            for (int i = 0; i < TypeParam.length; i++) {
                if (TypeParam[i] == 1) //kiểu int
                {
                    Cstm.setInt(i + 1, Integer.parseInt(Params[i]));
                }
                if (TypeParam[i] == 2) //kiểu float
                {
                    Cstm.setFloat(i + 1, Float.parseFloat(Params[i]));
                }
                if (TypeParam[i] == 3) //kiểu String
                {
                    Cstm.setString(i + 1, Params[i]);
                }
            }
            rs = Cstm.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi Không thể lấy dữ liệu", "Báo lỗi DAL", 1);
            System.exit(1);
        }
        return rs;
    }
    //method thực hiện gọi procedure sqlQuery chứa Query String, mảng params chứa các thông tin dạng thô (String)
    //đưa vào cho procedure sử lý, TypeParam là mảng theo thứ tự của quy định kiểu của params
    //cụ thể TypeParam=1 kiểu int, TypeParam=2 kiểu float, TypeParam=3 kiểu String
    //method này gọi những procedure thực hiện thay đổi trên bảng các hành động insert update delete
    public void myExecuteUpdateSP(String sqlQuery, String[] Params, int[] TypeParam) {
        try {
            CallableStatement Cstm = con().prepareCall(sqlQuery);
            for (int i = 0; i < TypeParam.length; i++) {
                if (TypeParam[i] == 1) //kiểu int
                {
                    Cstm.setInt(i + 1, Integer.parseInt(Params[i]));
                }
                if (TypeParam[i] == 2) //kiểu float
                {
                    Cstm.setFloat(i + 1, Float.parseFloat(Params[i]));
                }
                if (TypeParam[i] == 3) //kiểu String
                {
                    Cstm.setString(i + 1, Params[i]);
                }
            }
            Cstm.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi Không thể lấy dữ liệu", "Báo lỗi DAL777", 1);
            System.exit(1);
        }
    }
    //method thực hiện nhận query string thực iện truy vấn select trả về bảng giá trị
    public ResultSet myExecutePrepareStatement(String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            return rs;
        }
    }

    public int Execute_ReturnValue(String sqlQuery, String[] Params, int[] TypeParam, byte[] Image) {
        int result = -1;
        try {
            CallableStatement pro = con().prepareCall(sqlQuery);
            pro.registerOutParameter(1, Types.INTEGER);   //value tra ve

            //insert 6(8)   modify 7(8)
            //for (int i = 0; i < TypeParam.length; i++) {
            //    if (TypeParam[i] == 1)   pro.setInt   (i + 2, Integer.parseInt(Params[i]));
            //    if (TypeParam[i] == 2)   pro.setDouble(i + 2, Double.parseDouble(Params[i]));
            //    if (TypeParam[i] == 3)   pro.setString(i + 2, Params[i]);
            // }
            // pro.setBytes(8, Image);          // byte[] in the last póition
            //{IDHang,TenHang,Giabanle,ThongSoKyThuat,SoLuong,IDNPP,IDLoaiHang};
            if (TypeParam.length == 8) {
                pro.setString("IDHang", Params[0]);
                pro.setString("TenHang", Params[1]);
                pro.setDouble("Giabanle", Double.parseDouble(Params[2]));
                pro.setDouble("GiaNhap", Double.parseDouble(Params[7]));
                pro.setString("ThongSoKyThuat", Params[3]);
                pro.setInt("SoLuong", Integer.parseInt(Params[4]));
                pro.setString("IDNPP", Params[5]);
                pro.setString("IDLoaiHang", Params[6]);
                pro.setBytes("Hinh", Image);

            }
            //TenHang,Giabanle,ThongSoKyThuat,SoLuong,IDNPP,IDLoaiHang
            if (TypeParam.length ==7) {
                pro.setString("TenHang", Params[0]);
                pro.setDouble("Giabanle", Double.parseDouble(Params[1]));
                pro.setDouble("GiaNhap", Double.parseDouble(Params[6]));
                pro.setString("ThongSoKyThuat", Params[2]);
                pro.setInt("SoLuong", Integer.parseInt(Params[3]));
                pro.setString("IDNPP", Params[4]);
                pro.setString("IDLoaiHang", Params[5]);
                pro.setBytes("Hinh", Image);
            }
            pro.execute();
            result = pro.getInt(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR DataBase", 1);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR DataBase", 1);
        }
        return result;
    }
    //method thực hiện duy nhất việc gọi procedure phục vụ cho việc đăng nhập
    //nhận vào user name và password từ textfield trong form để truyền vào procedure
    //procedure trả ra 2 biến output parameter với nội dung chứa tên người đăng nhập và quyền hạn lưu vào trong biến vector info
    public void myExecuteFuncReturnDoubleValue(String sqlQuery, String UserName, String Password, Vector info) {
        try {
            CallableStatement Cstm = con().prepareCall(sqlQuery);
            Cstm.registerOutParameter(1, Types.NVARCHAR);
            Cstm.registerOutParameter(2, Types.INTEGER);
            Cstm.setString(3, UserName);
            Cstm.setString(4, Password);
            Cstm.execute();
            info.addElement(Cstm.getString(1));
            info.addElement(Cstm.getInt(2));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi Không thể lấy dữ liệu", "Báo lỗi DAL fun", 1);
        }
    }
}
