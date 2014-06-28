
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Administrator
 */
public class Task1 extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ArrayList<moveObject> list = new ArrayList<moveObject>();
    public static int size = 50;

    /**
     * @param args
     */
    public Task1() {
        addAll();
    }

    public void addAll() {
        list.add(new moveObject(150, 150, Color.orange));
        list.add(new moveObject(250, 150, Color.pink));
        list.add(new moveObject(200, 100, Color.green));
        list.add(new moveObject(200, 200, Color.blue));
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
// TODO Auto-generated method stub
        super.paintComponent(g);
        for (moveObject o : list) {
            Point p = convertToGrid(o.getX(), o.getY());
            g.drawImage(o.getImage(), p.x, p.y, null);
        }
    }

    public Point convertToGrid(int x, int y) {
        Point p = new Point();
        int factor = x / size;
        p.x = factor * size;

        int yfactor = y / size;
        p.y = yfactor * size;

        return p;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("test2");
        Task1 t = new Task1();
        f.setContentPane(t);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(new Dimension(500, 500));
        f.setVisible(true);

    }

    public class moveObject implements MouseListener, MouseMotionListener {

        int x = -1;
        int y = -1;
        Color color = Color.red;
        BufferedImage image = null;
        boolean pressed = false;
        int width = size;
        int height = size;

        public moveObject(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
            image = getMoveImage();
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        public BufferedImage getMoveImage() {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.setColor(color);
            g.fillRect(0, 0, image.getWidth(), image.getHeight());
            return image;
        }

        /**
         * @return the color
         */
        public Color getColor() {
            return color;
        }

        /**
         * @param color the color to set
         */
        public void setColor(Color color) {
            this.color = color;
        }

        /**
         * @return the image
         */
        public BufferedImage getImage() {
            return image;
        }

        /**
         * @param image the image to set
         */
        public void setImage(BufferedImage image) {
            this.image = image;
        }

        /**
         * @return the x
         */
        public int getX() {
            return x;
        }

        /**
         * @param x the x to set
         */
        public void setX(int x) {
            this.x = x;
        }

        /**
         * @return the y
         */
        public int getY() {
            return y;
        }

        /**
         * @param y the y to set
         */
        public void setY(int y) {
            this.y = y;
        }

        public void mouseClicked(MouseEvent e) {
// TODO Auto-generated method stub
        }

        public void mouseEntered(MouseEvent e) {
// TODO Auto-generated method stub
        }

        public void mouseExited(MouseEvent e) {
// TODO Auto-generated method stub
        }

        public void mousePressed(MouseEvent e) {
            java.awt.Rectangle rect = new java.awt.Rectangle(x, y, width, height);
            if (rect.contains(new Point(e.getX(), e.getY()))) {
                pressed = true;
            }

        }

        public void mouseReleased(MouseEvent e) {
            if (pressed) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
            pressed = false;

        }

        public void mouseDragged(MouseEvent e) {
            if (pressed) {
                x = e.getX();
                y = e.getY();
                repaint();
            }

        }

        public void mouseMoved(MouseEvent e) {
// TODO Auto-generated method stub
        }
    }
}
