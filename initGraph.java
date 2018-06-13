import java.awt.*;
import javax.swing.*;
public class initGraph {
    public static void main(String[] args) {
        JFrame frame = new JFrame("graph");
        frame.setSize(1900,1050);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StatisticsGraph sg = new StatisticsGraph(frame);
        frame.add(sg);
        sg.setVisible(true);
        for(int i=0;i<1400;i++) {
            double y = webData.getCurrent();
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /*for(int i=0;i<10000;i++) {
            double y = (Math.random()*100000);
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(10);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        /*
        for(int i=0;i<100;i++) {
            sg.addPoint(i,i);
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }
        for(int i=100;i<=201;i++) {
            sg.addPoint(i, Math.abs(201-i));
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        /*for(int i=0;i<1000;i++) {
            sg.addPoint(i,i*i*i);
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        /*for(int i=0;i<10000;i++) {
            double x=Math.random()*1000;
            double y=Math.random()*10000;
            sg.addPoint(x,y);
            sg.redraw();
            try {
                Thread.sleep(10);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        /*for(double i=0;i<100;i+=.1) {
            double y = Math.tan(i)+10;
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        /*for(int i=-1000;i<1000;i++) {
            double y = (2*(i*i*i))+(4.3*(i*i))-(1.2*i)+93;
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }*/
        
    }
}