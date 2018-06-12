import java.awt.*;
import javax.swing.*;
public class initGraph {
    public static void main(String[] args) {
        JFrame frame = new JFrame("graph");
        frame.setSize(1000,1000);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        StatisticsGraph sg = new StatisticsGraph();
        frame.add(sg);
        sg.setVisible(true);
        /*for(int i=0;i<1400;i++) {
            double y = webData.getCurrent();
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(60000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        for(int i=0;i<1000;i++) {
            double y = (Math.random()*10000);
            sg.addPoint(i,y);
            sg.redraw();
            try {
                Thread.sleep(100);
            } catch (Exception e) { 
                e.printStackTrace();
            }
        }
    }
}