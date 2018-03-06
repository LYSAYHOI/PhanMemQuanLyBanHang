/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connect;

/**
 *
 * @author minhh
 */
public class ModifyItems {
     String IDHang,TenHang,ThongSoKyThuat,IDNPP,IDLoaiHang, Giabanle, SoLuong,gianhap   ;
     byte[] Image;
    Connect conn=new Connect();
    private String[] Params;
    private int[] TypeParam;

    public ModifyItems(String IDHang, String TenHang, String ThongSoKyThuat, String IDNPP, String IDLoaiHang, String Giabanle, String SoLuong,byte[] Image,String gianhap) {
        this.IDHang = IDHang;
        this.TenHang = TenHang;
        this.ThongSoKyThuat = ThongSoKyThuat;
        this.IDNPP = IDNPP;
        this.IDLoaiHang = IDLoaiHang;
        this.Giabanle = Giabanle;
        this.SoLuong = SoLuong;
        this.Image=Image;
        this.gianhap=gianhap;
    }

     public int CallProcedure_ToModify()
    {
        Params=new String[]{IDHang,TenHang,Giabanle,ThongSoKyThuat,SoLuong,IDNPP,IDLoaiHang,gianhap};
        TypeParam = new int[]{3,3,2,3,1,3,3,2};
        return conn.Execute_ReturnValue("{? = call dbo.ModifyItem(?,?,?,?,?,?,?,?,?)}", Params, TypeParam,Image);
    
    }    
}
