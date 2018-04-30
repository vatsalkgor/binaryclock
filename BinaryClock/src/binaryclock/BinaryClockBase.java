package binaryclock;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import javax.swing.JPanel;

/**
 *
 * @author Vatsal
 */
public class BinaryClockBase extends TimerTask {
    @Override
    public void run() {
        getHMSA(getTime());
        convertToBinary(hours, mins, secs);
    }
    protected int hours;
    protected int mins;
    protected int secs;
    protected String ap;

    private String getTime() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss a");
        return sdf.format(cal.getTime());
    }

    private void getHMSA(String time) {
        String[] hmsa = time.split(":");
        hours = Integer.valueOf(hmsa[0]);
        mins = Integer.valueOf(hmsa[1]);
        String[] t = hmsa[2].split(" ");
        secs = Integer.valueOf(t[0]);
        ap = t[1];
    }

    private void convertToBinary(int h, int m, int s) {
        
        String hrs = Integer.toBinaryString(h);
        String min = Integer.toBinaryString(m);
        String sec = Integer.toBinaryString(s);
        while (hrs.length() != 4) {
            hrs = "0".concat(hrs);
        }
        while (min.length() != 6) {
            min = "0".concat(min);
        }
        while (sec.length() != 6) {
            sec = "0".concat(sec);
        }
        if (ap.equals("PM")) {
            setColor(BinaryClock.bcf.ampm);
        } else {
            resetColor(BinaryClock.bcf.ampm);
        }
        int counter = 0;
        for (int i = 0; i < 6; i++) {
            if(counter == 6)
                counter = 0;
            if (sec.charAt(i) == '0') {
                if (counter == 0) {
                    resetColor(BinaryClock.bcf.secs32);
                } else if (counter == 1) {
                    resetColor(BinaryClock.bcf.secs16);
                } else if (counter == 2) {
                    resetColor(BinaryClock.bcf.secs8);
                } else if (counter == 3) {
                    resetColor(BinaryClock.bcf.secs4);
                } else if (counter == 4) {
                    resetColor(BinaryClock.bcf.secs2);
                } else {
                    resetColor(BinaryClock.bcf.secs1);
                }
            } else {
                if (counter == 0) {
                    setColor(BinaryClock.bcf.secs32);
                } else if (counter == 1) {
                    setColor(BinaryClock.bcf.secs16);
                } else if (counter == 2) {
                    setColor(BinaryClock.bcf.secs8);
                } else if (counter == 3) {
                    setColor(BinaryClock.bcf.secs4);
                } else if (counter == 4) {
                    setColor(BinaryClock.bcf.secs2);
                } else {
                    setColor(BinaryClock.bcf.secs1);
                }
            }
            counter++;
        }
        for (int i = 0; i < 6; i++) {
            if(counter == 6)
                counter = 0;
            if (min.charAt(i) == '0') {
                if (counter == 0) {
                    resetColor(BinaryClock.bcf.mins32);
                } else if (counter == 1) {
                    resetColor(BinaryClock.bcf.mins16);
                } else if (counter == 2) {
                    resetColor(BinaryClock.bcf.mins8);
                } else if (counter == 3) {
                    resetColor(BinaryClock.bcf.mins4);
                } else if (counter == 4) {
                    resetColor(BinaryClock.bcf.mins2);
                } else {
                    resetColor(BinaryClock.bcf.mins1);
                }
            } else {
                if (counter == 0) {
                    setColor(BinaryClock.bcf.mins32);
                } else if (counter == 1) {
                    setColor(BinaryClock.bcf.mins16);
                } else if (counter == 2) {
                    setColor(BinaryClock.bcf.mins8);
                } else if (counter == 3) {
                    setColor(BinaryClock.bcf.mins4);
                } else if (counter == 4) {
                    setColor(BinaryClock.bcf.mins2);
                } else {
                    setColor(BinaryClock.bcf.mins1);
                }
            }
            counter++;
        }
        int hrCounter = 0;
        for (int i = 0; i < 4; i++) {
            if(hrCounter == 4)
                hrCounter = 0;
            if (hrs.charAt(i) == '0') {
                if (hrCounter == 0) {
                    resetColor(BinaryClock.bcf.hours8);
                } else if (hrCounter == 1) {
                    resetColor(BinaryClock.bcf.hours4);
                } else if (hrCounter == 2) {
                    resetColor(BinaryClock.bcf.hours2);
                } else {
                    resetColor(BinaryClock.bcf.hours1);
                }
            } else {
                if (hrCounter == 0) {
                    setColor(BinaryClock.bcf.hours8);
                } else if (hrCounter == 1) {
                    setColor(BinaryClock.bcf.hours4);
                } else if (hrCounter == 2) {
                    setColor(BinaryClock.bcf.hours2);
                } else {
                    setColor(BinaryClock.bcf.hours1);
                }
            }
            hrCounter++;
        }
    }
    private void setColor(JPanel p) {
        Color c = new Color(38, 38, 38);
        p.setBackground(c);
    }

    private void resetColor(JPanel p) {
        Color c = new Color(0, 100, 148);
        p.setBackground(c);
    }
    
}
