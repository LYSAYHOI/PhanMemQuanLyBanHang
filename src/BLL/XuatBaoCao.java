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
//file java class bình thường thực hiện xuất báo cáo bán hàng và lời trong khoảng thời gian được tùy chọn ra file word
public class XuatBaoCao {
    private List<String> InfoReport;
    public XuatBaoCao(List<String> InfoReport) {
        this.InfoReport = InfoReport;
    }
    public void create() throws Exception{
        //Blank Document
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("createReport.docx"));

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
        txtcongty.setText("Ngày lập báo cáo: "+LocalDate.now());
        XWPFRun txthoadon = paragraphCenter.createRun();
        txthoadon.setFontSize(18);
        txthoadon.setFontFamily("Cambria");
        txthoadon.setText("Báo cáo thống kế bán hàng");
        txthoadon.addBreak();
        XWPFRun txtsohoadon = paragraphCenter.createRun();
        txtsohoadon.setFontSize(12);
        txtsohoadon.setFontFamily("Cambria");
        txtsohoadon.setText("(từ: " + InfoReport.get(0) + " đến: "+InfoReport.get(1)+")");
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun txtthongtinkh = paragraph1.createRun();
        txtthongtinkh.setFontSize(12);
        txtthongtinkh.setBold(true);
        txtthongtinkh.setFontFamily("Cambria");
        txtthongtinkh.setText("Thông tin bán hàng");
        txtthongtinkh.addBreak();
        XWPFRun txtchitietthongtinkh = paragraph1.createRun();
        txtchitietthongtinkh.setFontSize(12);
        txtchitietthongtinkh.setFontFamily("Cambria");
        txtchitietthongtinkh.setText("Tổng tiền bán được: " + InfoReport.get(2)+"VND");
        txtchitietthongtinkh.addBreak();
        txtchitietthongtinkh.setText("Tổng tiền vốn: " + InfoReport.get(3)+"VND");
        txtchitietthongtinkh.addBreak();
        txtchitietthongtinkh.setText("Tiền lãi: " + InfoReport.get(4)+"VND");
        txtchitietthongtinkh.addBreak();
        txtchitietthongtinkh.setText("Phần trăm lãi: " + InfoReport.get(5)+"%");
        txtchitietthongtinkh.addBreak();
        
        document.write(out);
        out.close();
        System.out.println("createdocument.docx written successully");
    }
}
