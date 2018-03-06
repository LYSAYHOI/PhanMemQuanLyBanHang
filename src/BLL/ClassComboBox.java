/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author minhh
 */
public class ClassComboBox {
     private String IDLoaiHang,TenLoaiHang;

     
    public ClassComboBox(String IDLoaiHang, String TenLoaiHang) {
        this.IDLoaiHang = IDLoaiHang;
        this.TenLoaiHang = TenLoaiHang;
    }
    
    public String getIDLoaiHang() {
        return IDLoaiHang;
    }

    public void setIDLoaiHang(String IDLoaiHang) {
        this.IDLoaiHang = IDLoaiHang;
    }

    public String getTenLoaiHang() {
        return TenLoaiHang;
    }

    public void setTenLoaiHang(String TenLoaiHang) {
        this.TenLoaiHang = TenLoaiHang;
    }

    @Override
    public String toString(){
        return this.TenLoaiHang;
    }
}
