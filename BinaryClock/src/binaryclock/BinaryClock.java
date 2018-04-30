package binaryclock;

import java.util.Timer;

public class BinaryClock {
public static BinaryClockFrame bcf = new BinaryClockFrame();
    public static void main(String[] args) {
        
        bcf.setVisible(true);
        Timer t = new Timer();
        t.schedule(new BinaryClockBase(), 0, 1000);
    }
}

