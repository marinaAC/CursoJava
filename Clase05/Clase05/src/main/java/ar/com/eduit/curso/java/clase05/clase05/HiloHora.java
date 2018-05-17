
package ar.com.eduit.curso.java.clase05.clase05;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.swing.JTextField;


public class HiloHora implements Runnable{
    
    private JTextField txt;

    public HiloHora(JTextField txt) {
        this.txt = txt;
    }
    
    @Override
    public void run() {
        while(true){
            LocalDateTime ld = LocalDateTime.now();
            this.txt.setText(ld.getDayOfMonth()+"/"+ld.getMonthValue()+"/"+ld.getYear()+" "+ ld.getHour()+":"+ld.getMinute()+":"+ld.getSecond());
            try{
                Thread.sleep(1000);
            }catch(Exception e){
            }
        }
    }
    
}
