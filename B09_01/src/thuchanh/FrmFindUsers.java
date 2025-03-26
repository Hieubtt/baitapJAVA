package thuchanh;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmFindUsers {

	private JFrame frame;
	private JTextField txtFind;
	private JTable table;
	List<Users> lst = new ArrayList<Users>() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFindUsers window = new FrmFindUsers();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
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
	public FrmFindUsers() {
		initialize();

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 744, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtFind = new JTextField();
		txtFind.setBounds(115, 37, 198, 24);
		frame.getContentPane().add(txtFind);
		txtFind.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn");
		lblNewLabel.setBounds(29, 39, 76, 19);
		frame.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hình Ảnh", "Họ tên", "ĐTDĐ"
			}
		));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(76, 128, 477, 221);
		frame.getContentPane().add(scrollPane);
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		
		
		JButton btnFind = new JButton("Ti\u0300m Ki\u00EA\u0301m");
		btnFind.addActionListener(new ActionListener() {
			//private Object icon;

			public void actionPerformed(ActionEvent e) {
				try {
					@SuppressWarnings("resource")
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("APIUser.txt"));
					while(true)
					{
						try {
							//DefaultTableModel dfm = new  DefaultTableModel(new String [] {"Hình Ảnh", "Họ tên", "ĐTDĐ"},0);
							DefaultTableModel dfm = new DefaultTableModel(
								    new Object[][] {}, 
								    new String[] { "Hình Ảnh", "Họ tên", "ĐTDĐ" }) {
								    /**
										 * 
										 */
										private static final long serialVersionUID = 1L;

									@Override
								    public Class<?> getColumnClass(int columnIndex) {
								        if (columnIndex == 0) {
								            return ImageIcon.class; // Cột đầu tiên là ảnh
								        }
								        return String.class; // Cột khác là String
								    }
								};
							
		                    
							Users user = (Users) ois.readObject();
		                    //System.out.println(" UserName: " + user.getUserName() + " - " + user.getTel() + user.getHinhAnh());
							lst.add(user);
		                    String imagePath = user.getHinhAnh();
						    File file = new File(imagePath);
						    for(@SuppressWarnings("unused") Users u : lst)
						    {
						    	if(user.getUserName().toLowerCase().contains(txtFind.getText().toLowerCase()))
		                    {
		                    	if (!file.exists()) {
							        JOptionPane.showMessageDialog(frame, "Ảnh không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
							    } else {
							        
							        BufferedImage img1 = ImageIO.read(file);
							        if (img1 != null) {
							            Image scaledImg = img1.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
							            ImageIcon icon = new ImageIcon(scaledImg);
							            dfm.addRow(new Object [] {icon,user.getUserName(),user.getTel()});///
							            table.setModel(dfm);
							            System.out.println(" UserName: " + user.getUserName() + " - " + user.getTel() + user.getHinhAnh());
							        } else {
							            JOptionPane.showMessageDialog(frame, "Không thể đọc ảnh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
							        }
							        
							    }
		                    	
		                    	return;
		                    }
		                    
					    }
		                    
		                } catch (EOFException e1) {
		                    break;
		                }
						
					}
					ois.close();
					
					//ois.close();
				} catch (IOException e3) {
					JOptionPane.showMessageDialog(frame,"Lỗi không tìm thấy file API ","Lỗi",JOptionPane.ERROR_MESSAGE);
					e3.printStackTrace();
				} catch (ClassNotFoundException e2) {
					JOptionPane.showMessageDialog(frame,"Lỗi không đọc được file API ","Lỗi",JOptionPane.ERROR_MESSAGE);
					e2.printStackTrace();
				}
				
				
			}
		});
		btnFind.setBounds(354, 38, 91, 21);
		frame.getContentPane().add(btnFind);
		
		
		
		

	}
}
