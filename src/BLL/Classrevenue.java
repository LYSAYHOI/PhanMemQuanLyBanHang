/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.math.BigDecimal;

/**
 *
 * @author minhh
 */
public class Classrevenue {
      String IDHoaDonMuaHang,TenNhanVien,TenKhachHang,NgayMua;
        
        BigDecimal TongThanhToan;

    public Classrevenue(String IDHoaDonMuaHang, String TenKhachHang,String TenNhanVien,  String NgayMua, BigDecimal TongThanhToan) {
        this.IDHoaDonMuaHang = IDHoaDonMuaHang;
        this.TenNhanVien = TenNhanVien;
        this.TenKhachHang = TenKhachHang;
        this.NgayMua = NgayMua;
        this.TongThanhToan = TongThanhToan;
    }
        
}
