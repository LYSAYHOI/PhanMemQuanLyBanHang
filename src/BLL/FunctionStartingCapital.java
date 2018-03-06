/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.Connect;
import java.math.BigDecimal;
import java.sql.ResultSet;


/**
 *
 * @author minhh
 */
public class FunctionStartingCapital {
     String to,from;
       Connect conn=new Connect();
      private String[] Params;
      private int[] TypeParam;
        ResultSet rs=null;
    public FunctionStartingCapital(String from, String to) {
        this.to = to;
        this.from = from;
    }
    public BigDecimal kq() {  //Method to default Jtable Model
        Params = new String[]{from,to};
        TypeParam = new int[]{3,3};
        return conn. returnDecimalFromFunction ("{? = call dbo.StartingCapital(?,?)}", Params, TypeParam);
      }
}
