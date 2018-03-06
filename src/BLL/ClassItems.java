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
public class ClassItems {
   public String IDHang,TenHang,ThongSoKyThuat,IDNPP,TenLoaiHang,TenNPP;
   public BigDecimal Giabanle,gianhap;
   public byte[] Hinh;
   public int SoLuong;
    public ClassItems(String IDHang, String TenHang,String TenLoaiHang, String TenNPP, BigDecimal Giabanle, int SoLuong,String ThongSoKyThuat,byte[] Hinh ,BigDecimal gianhap) {
        this.IDHang = IDHang;
        this.TenHang = TenHang;
        this.ThongSoKyThuat = ThongSoKyThuat;
        this.Hinh = Hinh;
        this.TenNPP=TenNPP;
        this.TenLoaiHang = TenLoaiHang;
        this.Giabanle = Giabanle;
        this.SoLuong = SoLuong;
        this.gianhap=gianhap;
    }
}
