package Task2;

/**
 *
 * @author Daniel
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class BarChart extends JPanel implements Observer{
    private DataFrame data = null;

    public BarChart(DataFrame dat) {
        this.data = dat;
    }
    
    public void update(Observable obs, Object obj) {
        if (obs == data) {
            repaint();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.getSize(); i++) {
            max = Math.max(max, data.getValue(i));
        }
        int width = (getWidth() / data.getSize()) - 2;
        int x = 1;
        for (int i = 0; i < data.getSize(); i++) {
            int value = data.getValue(i);
            int height = (int) ((getHeight() - 5) * ((double)value / max
            ));
            g.setColor(Color.black);
            g.fillRect(x, getHeight() - height, width, height);
            g.drawRect(x, getHeight() - height, width, height);
            x += (width + 2);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(data.getSize() * 100 + 5, 400);
    }
}
