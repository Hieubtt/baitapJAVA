package thuchanh;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageTableCellRenderer extends DefaultTableCellRenderer { 
	private static final long serialVersionUID = -7959113581100753271L; 
	private int imageWidth; 
	private int imageHeight; 
	public ImageTableCellRenderer(int imageWidth, int imageHeight) { 
	this.imageWidth = imageWidth; 
	this.imageHeight = imageHeight; 
	}  
	public Component getTableCellRendererComponent(JTable table, Object value, 
	boolean isSelected, boolean hasFocus, int row, int column) { 
	super.getTableCellRendererComponent(table, value, isSelected, hasFocus, 
	row, column); 
	 
	try { 
	BufferedImage image = null; 
	@SuppressWarnings("deprecation")
	URL url = new URL("file:" + value); 
	image = getScaledImages(ImageIO.read(url), imageWidth,imageHeight); 
	setIcon(new ImageIcon(image));
	setHorizontalAlignment(JLabel.CENTER); 
	setText(""); 
	} catch (Exception e) { 
	setText("[No image]"); 
	e.printStackTrace(); 
	} 
	return this; 
	} 
	private BufferedImage getScaledImages(BufferedImage in, int WIDTH, int HEIGHT) { 
	BufferedImage out = new BufferedImage(WIDTH, HEIGHT, 
	 BufferedImage.TYPE_INT_RGB); 
	Graphics2D g2 = out.createGraphics(); 
	g2.setColor(Color.white); 
	g2.fillRect(0, 0, WIDTH, HEIGHT); 
	double width = in.getWidth(); 
	double height = in.getHeight(); 
	double xScale = WIDTH / width; 
	double yScale = HEIGHT / height; 
	double scale = 1.0; 
	
	scale = Math.min(xScale, yScale); // scale to fit 
	
	double x = (WIDTH - width * scale) / 2; 
	double y = (HEIGHT - height * scale) / 2; 
	AffineTransform at = AffineTransform.getTranslateInstance(x, y); 
	at.scale(scale, scale); 
	g2.drawRenderedImage(in, at); 
	g2.dispose(); 
	return out; 
	} 
}