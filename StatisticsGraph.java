import java.awt.*;
import javax.swing.*;
import java.util.*;
public class StatisticsGraph extends JComponent{
    ArrayList<GraphPoint> points;
    double max_x;
    double max_y;
    double min_x;
    double min_y;
    int WIDTH=1900;
    int HEIGHT=1050;
    public StatisticsGraph() {
        super();
        points = new ArrayList<GraphPoint>();
        max_x=5;
        max_y=5;
        min_x=0;
        min_y=0;
    }
    public void redraw() {
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        //System.out.println("points size: " + points.size());
        //System.out.println("max x: " + max_x);
        //System.out.println("max y: " + max_y);
        System.out.println("min y : " + min_y);
        System.out.println("max y : " + max_y);
        //System.out.println("max x : " + max_x);
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        double av=0;
        for(GraphPoint p : points) {
            av+=p.getY();
        }
        av/=points.size();
        g.setColor(Color.BLACK);
        g.drawString("MEAN: " + av,30,20);
        double avy = (HEIGHT*((av-min_y)/(max_y-min_y)));
        g.setColor(Color.ORANGE);
        g.drawLine(0, (int)avy, WIDTH, (int)avy);
        g.setColor(Color.BLACK);
        ArrayList<GraphPoint> medianlist = new ArrayList<GraphPoint>();
        for(GraphPoint p : points) {
            medianlist.add(p);
        }
        Collections.sort(medianlist);
        g.drawString("MEDIAN: " + (medianlist.get((int)(medianlist.size()/2))).getY(),30,40);
        int stdev=0;
        for(GraphPoint p : points) {
            stdev+=Math.abs(p.getY()-av);
        }
        stdev/=points.size();
        g.drawString("STANDARD DEVIATION: " + stdev,30,60);      
        //double maxy = (HEIGHT*((max_y-min_y)/(max_y-min_y)));
        g.setColor(Color.BLUE);
        g.drawLine(0,(int)(HEIGHT-(HEIGHT/1.1))-30,WIDTH,(int)(HEIGHT-(HEIGHT/1.1))-30);
        g.drawLine(0,(int)(HEIGHT-((HEIGHT)/1.1/2))-30,WIDTH,(int)(HEIGHT-((HEIGHT)/1.1/2))-30);
        g.drawLine(0,(int)(HEIGHT-((HEIGHT)/.9)-30),WIDTH,(int)(HEIGHT-((HEIGHT)/.9)-30));
        
        g.setColor(Color.MAGENTA);
        double medy = (HEIGHT*((((medianlist.get((int)(medianlist.size()/2))).getY())-min_y)/(max_y-min_y)));
        g.drawLine(0,(int)medy,WIDTH,(int)medy);
        if (points.size()>0) {
            double psx = WIDTH*((points.get(0).getX())/max_x);
            double psy = (HEIGHT*(points.get(0).getY()/max_y))-(HEIGHT*(min_y/max_y));
            psy+=30;
            for(GraphPoint p : points) {
                double sx = WIDTH*(p.getX()/max_x);
                //double sy = HEIGHT*((((p.getY()/max_y)))-min_y);
                //double sy = (HEIGHT*(p.getY()/max_y))-(HEIGHT*(min_y/max_y));
                //double sy = (HEIGHT*(p.getY()/max_y));
                double sy = (HEIGHT*((p.getY()-min_y)/(max_y-min_y)));
                sy+=30;
                //System.out.println("cy: " + p.getY());
                //System.out.println("sx: " + sx);
                //System.out.println("sy: " + sy);
                //System.out.println("psx: " + psx);
                //System.out.println("psy: " + psy);
                g.setColor(Color.BLACK);
                g.fillRect((int)((sx)-2), (int)((HEIGHT-sy)-2), 4, 4);
                //g.setColor(Color.BLACK);
                if (sy>psy) {
                    g.setColor(Color.GREEN);
                } else if (psy>sy) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLACK);
                }
                g.drawLine((int)sx, (int)(HEIGHT-sy), (int)psx, (int)(HEIGHT-psy));
                psx=sx;
                psy=sy;
            }
        }
    }
    public void addPoint(GraphPoint gp) {
        points.add(gp);
        if (gp.getX()>max_x) {
            max_x=1.2*gp.getX();
        }
        if (gp.getY()>max_y) {
            max_y=1.2*gp.getY();
        }
        if (gp.getY()<min_y) {
            min_y=gp.getY();
        }
    }
    public void addPoint(double _x_, double _y_) {
        GraphPoint gp = new GraphPoint(_x_,_y_);
        points.add(gp);
        if (points.size()==1) {
            min_y=(.8*gp.getY());
        }
        if (gp.getX()>(max_x/1.1)) {
            max_x=(1.1*(gp.getX()));
        }
        if (gp.getY()>(max_y/1.1)) {
            max_y=((1.1*gp.getY()));
        }
        if (gp.getY()<(min_y/.8)) {   
            min_y=(.8*gp.getY());
        }
    }
}