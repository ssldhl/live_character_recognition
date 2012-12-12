import java.awt.*;
import javax.swing.Icon;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sushil
 */
public class MissingIcon implements Icon{
    private int width = 64;
    private int height = 64;
    
    private BasicStroke stroke = new BasicStroke(4);
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x +1 ,y + 1,width -2 ,height -2);
        
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x +1 ,y + 1,width -2 ,height -2);
        
        g2d.setColor(Color.RED);
        
        g2d.setStroke(stroke);
        g2d.drawLine(x +10, y + 10, x + width -10, y + height -10);
        g2d.drawLine(x +10, y + height -10, x + width -10, y + 10);
        
        g2d.dispose();
    }
    
    @Override
    public int getIconWidth() {
        return width;
    }
    
    @Override
    public int getIconHeight() {
        return height;
    }    
}
