import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

class PaintPanel extends JPanel{
    private final ArrayList<Point> points = new ArrayList<>();

    public PaintPanel(){
        addMouseMotionListener(
            new MouseMotionAdapter(){
                @Override
                public void mouseDragged(MouseEvent event){
                    points.add(event.getPoint());
                    repaint();
                }
            }
        );
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (Point point : points)
            g.fillOval(point.x, point.y, 4, 4);
    }
}

public class Painter{
    public static void main(String[] args){
        JFrame application = new JFrame("Paint");

        PaintPanel paintPanel = new PaintPanel();
        application.add(paintPanel, BorderLayout.CENTER);

        application.add(new JLabel("Drag mouse to draw"), BorderLayout.SOUTH);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(600, 800);
        application.setVisible(true);
    }
}
