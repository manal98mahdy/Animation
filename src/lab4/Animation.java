
package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Animation {
       public static void main(String[] args) {
        JFrame f = new JFrame("Available Fonts");
 
        DrawingPanel drawingPanel = new DrawingPanel();
        f.add(drawingPanel);
        f.setSize(400, 450);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  SwingUtilities.invokeLater(DrawingGUI::new);
   ColorChangeRunnable colorChangeRunnable = new ColorChangeRunnable(drawingPanel);
        new Thread(colorChangeRunnable).start();
    }
}

class DrawingPanel extends JPanel {
 
 private Color circleColor;

        public DrawingPanel() {
            circleColor = Color.blue; // Initial color
        }

        public void setCircleColor(Color color) {
            circleColor = color;
            repaint();
        }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        // Draw a rectangle
        g.drawRect(75, 350, 250, 20);

        // Draw a line
        g.drawLine(105, 70, 50, 220);
        g.drawLine(287, 70, 350, 220);
        g.drawLine(170, 260, 140, 350);
        g.drawLine(230, 260, 260, 350);
        g.drawArc(50, 180, 300, 80, 180, 180);
        
        // Draw an ellipse
        g.drawOval(100, 50, 190, 50);
        g.drawOval(100, 130, 40, 70);
        g.drawOval(165, 110, 70, 130);
        g.drawOval(260, 130, 40, 70);
         g.setColor(circleColor);
         g.fillOval(100, 50, 190, 50);

        g.fillOval(100, 130, 40, 70);
        g.fillOval(165, 110, 70, 130);
        g.fillOval(260, 130, 40, 70);
        
     
    }
}
     class ColorChangeRunnable implements Runnable {
        private DrawingPanel drawingPanel;
        private Random random;

        public ColorChangeRunnable(DrawingPanel drawingPanel) {
            this.drawingPanel = drawingPanel;
            this.random = new Random();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Sleep for 3 seconds
                    Thread.sleep(300);

                    // Generate a random color
                    int red = random.nextInt(256);
                    int green = random.nextInt(256);
                    int blue = random.nextInt(256);
                    Color randomColor = new Color(red, green, blue);

                    // Update the color in the DrawingPanel
                    SwingUtilities.invokeLater(() -> drawingPanel.setCircleColor(randomColor));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }


