/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connect;

/**
 *
 * @author lsayh
 */
//class chứa thông tin của khách hàng
public class CreateCus {
    String TenKH, SDT, CMND, DiaChi;
    Connect conn;
    private String[] Params;
    private int[] TypeParam;
    public CreateCus(String TenKH, String SDT, String CMND, String DiaChi) {
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.CMND = CMND;
        this.DiaChi = DiaChi;
        conn= new Connect();
    }
    //method thực hiện thêm(insert) khách hàng mới
    //hoạt động insert này trả về số ID của khách hàng được tạo mới thành công (ID là KH1 thì trả về 1)
    //trường hợp không thành công thì procedure trả về -1
    //method gọi procedure SpInsertKhachHang
    public int Action(){
        Params=new String[]{TenKH, SDT, CMND, DiaChi};
        TypeParam = new int[]{3,3,3,3};
        return conn.returnFromFunction("{? = call SpInsertKhachHang(?,?,?,?)}", Params, TypeParam);
    }
}
