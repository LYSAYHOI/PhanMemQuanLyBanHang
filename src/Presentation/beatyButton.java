/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.Timer;

/**
 *
 * @author lsayh
 */
public class beatyButton extends Thread{
    JButton BtnBeauty;
    public beatyButton(JButton need){
        BtnBeauty=need;
    }
    @Override
    public void run(){
        Timer time = new Timer(250, TimerListener);
        time.start();
    }
    private ActionListener TimerListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int random1 = (int )(Math.random() * 255);
            int random2 = (int )(Math.random() * 255);
            int random3 = (int )(Math.random() * 255);
            BtnBeauty.setBackground(new Color(random1, random2, random3));
        }
    };
}
