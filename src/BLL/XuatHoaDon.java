/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author lsayh
 */
//file java class bình thường thực hiện xuất hóa đơn mua hàng ra file word
public class XuatHoaDon {

    String IDHoaDon;
    List<String> InfoKhachHang;
    List<List<String>> InfoHang;

    public XuatHoaDon(String IDHoaDon, List<String> InfoKhachHang, List<List<String>> InfoHang) {
        this.IDHoaDon = IDHoaDon;
        this.InfoKhachHang = InfoKhachHang;
        this.InfoHang = InfoHang;
    }

    public void Create() throws Exception {
        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("createdocument.docx"));

        //create Paragraph
        XWPFParagraph paragraph = document.createParagraph();
        XWPFParagraph paragraphCenter = document.createParagraph();
        paragraphCenter.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun txtcongty = paragraph.createRun();
        txtcongty.setFontSize(14);
        txtcongty.setFontFamily("Cambria");
        txtcongty.setText("Tập Đoàn K&H");
        txtcongty.addTab();
        txtcongty.addTab();
        txtcongty.addTab();
        txtcongty.addTab();
        txtcongty.addTab();
        txtcongty.setText("Ngày lập hóa đơn: "+LocalDate.now());
        XWPFRun txthoadon = paragraphCenter.createRun();
        txthoadon.setFontSize(18);
        txthoadon.setFontFamily("Cambria");
        txthoadon.setText("Hóa Đơn");
        txthoadon.addBreak();
        XWPFRun txtsohoadon = paragraphCenter.createRun();
        txtsohoadon.setFontSize(12);
        txtsohoadon.setFontFamily("Cambria");
        txtsohoadon.setText("(số hóa đơn: " + IDHoaDon + ")");
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun txtthongtinkh = paragraph1.createRun();
        txtthongtinkh.setFontSize(12);
        txtthongtinkh.setBold(true);
        txtthongtinkh.setFontFamily("Cambria");
        txtthongtinkh.setText("thông tin khách hàng");
        txtthongtinkh.addBreak();
        XWPFRun txtchitietthongtinkh = paragraph1.createRun();
        txtchitietthongtinkh.setFontSize(12);
        txtchitietthongtinkh.setFontFamily("Cambria");
        txtchitietthongtinkh.setText("Tên Khách Hàng: " + InfoKhachHang.get(0));
        txtchitietthongtinkh.addBreak();
        txtchitietthongtinkh.setText("Số Điện thoại: " + InfoKhachHang.get(1));
        txtchitietthongtinkh.addBreak();
        txtchitietthongtinkh.setText("Chứng minh số: " + InfoKhachHang.get(2));
        txtchitietthongtinkh.addBreak();
        txtchitietthongtinkh.setText("Địa chỉ: " + InfoKhachHang.get(3));
        txtchitietthongtinkh.addBreak();
        XWPFRun txtthongtinhang = paragraph1.createRun();
        txtthongtinhang.setFontSize(12);
        txtthongtinhang.setBold(true);
        txtthongtinhang.setFontFamily("Cambria");
        txtthongtinhang.setText("thông tin mặt hàng");
        //create table
        XWPFTable table = document.createTable();
        //create first row
        XWPFTableRow tablethongtinhang = table.getRow(0);
        tablethongtinhang.getCell(0).setText("STT");
        tablethongtinhang.addNewTableCell().setText("Tên Mặt Hàng");
        tablethongtinhang.addNewTableCell().setText("Giá Bán");
        tablethongtinhang.addNewTableCell().setText("Số Lượng");
        tablethongtinhang.addNewTableCell().setText("Thành Tiền");
        for (int i = 0; i < InfoHang.size(); i++) {
            XWPFTableRow tablethongtinhang1 = table.createRow();
            tablethongtinhang1.getCell(0).setText(String.valueOf(i+1));
            List<String> info= InfoHang.get(i);
            tablethongtinhang1.getCell(1).setText(info.get(0));
            tablethongtinhang1.getCell(2).setText(info.get(1));
            tablethongtinhang1.getCell(3).setText(info.get(2));
            tablethongtinhang1.getCell(4).setText(info.get(3));
        }
        XWPFParagraph paragraph2 = document.createParagraph();
        XWPFRun txtTongThanhToan = paragraph2.createRun();
        txtTongThanhToan.setFontSize(12);
        txtTongThanhToan.setBold(true);
        txtTongThanhToan.setFontFamily("Cambria");
        txtTongThanhToan.setText("Tổng Thanh Toán: "+InfoKhachHang.get(4));
        document.write(out);
        out.close();
        System.out.println("createdocument.docx written successully");
    }
}
