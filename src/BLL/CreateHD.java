/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;
import DAL.*;
/**
 *
 * @author lsayh
 */
//class chứa thông tin của hóa đơn
public class CreateHD {
    private float TongThanhToan;
    private String TenKhachHang;
    private String TenNhanVien;
    Connect conn;
    private String[] Params;
    private int[] TypeParam;
    public CreateHD(float TongThanhToan, String TenKhachHang, String TenNhanVien){
        this.TongThanhToan=TongThanhToan;
        this.TenKhachHang=TenKhachHang;
        this.TenNhanVien=TenNhanVien;
        conn= new Connect();
    }
    //method thực hiện thêm(insert) hóa đơn mới
    //hoạt động insert này trả về số ID của hóa đơn được tạo mới thành công (ID là HD1 thì trả về 1)
    //trường hợp không thành công thì procedure trả về -1
    //method gọi procedure SpInsertView
    public int Action(){
        Params=new String[]{String.valueOf(TongThanhToan),TenKhachHang,TenNhanVien};
        TypeParam = new int[]{2,3,3};
        return conn.returnFromFunction("{? = call SpInsertView(?,?,?)}", Params, TypeParam);
    }
    //method thực hiện thêm(insert) chi tiết hóa đơn
    //hoạt động insert lấy thông tin từ bảng giỏ hàng chứa thông tin về tên hàng, số lượng mua
    //giá = giahang*soluongmua ID lấy từ ID trả về từ method Action() ở trên
    //trường hợp không thành công thì procedure trả về -1
    //method gọi procedure SpInsertchiTietMuaHang
    public void InsertChiTiet(String IDHD, String TenHang, int SoLuong, float Gia){
        
        Params=new String[]{String.valueOf(SoLuong),String.valueOf(Gia),TenHang,IDHD};
        TypeParam = new int[]{1,2,3,3};
        conn.myExecuteUpdateSP("{call SpInsertchiTietMuaHang(?,?,?,?)}", Params, TypeParam);
    }
}
