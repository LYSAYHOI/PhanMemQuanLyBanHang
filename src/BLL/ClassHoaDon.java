/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author lsayh
 */
//lớp bao gồm thông tin chi tiết của hóa đơn
//class này có các biến tương tự với các cột trong view hóa đơn trong database
public class ClassHoaDon {

    public String IDHoaDon, NgayMua, TenKhachhang, TenNhanVien;
    public double TongThanhToan;
    
    public ClassHoaDon(String IDHoaDon, double TongThanhToan, String NgayMua, String TenKhachhang, String TenNhanVien) {
        this.IDHoaDon = IDHoaDon;
        this.TongThanhToan = TongThanhToan;
        this.NgayMua = NgayMua;
        this.TenKhachhang = TenKhachhang;
        this.TenNhanVien = TenNhanVien;
    }
}
