import java.awt.*;
import javax.swing.*;
public class initGraph {
    public static void main(String[] args) {
        JFrame frame = new JFrame("graph");
        frame.setSize(1900,1050);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StatisticsGraph sg = new StatisticsGraph();
        frame.add(sg);
        sg.setVisible(true);
        /*for(int i=1;i<1401;i++) {
            double y = webData.getCurrent();
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        /*for(int i=0;i<1000;i++) {
            double y = (Math.random()*100)+7500;
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(10);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        /*for(int i=0;i<100;i++) {
            sg.addPoint(i,i);
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }
        for(int i=100;i<201;i++) {
            sg.addPoint(i, Math.abs(201-i));
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        for(int i=0;i<1000;i++) {
            sg.addPoint(i,i*i);
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }
    }
}