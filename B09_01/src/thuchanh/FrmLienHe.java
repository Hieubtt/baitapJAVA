package thuchanh;

import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FrmLienHe {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtTel;
	private JTextField txtPictute;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLienHe window = new FrmLienHe();
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
	public FrmLienHe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 841, 429);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(156, 38, 227, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(156, 86, 136, 19);
		frame.getContentPane().add(txtTel);
		
		txtPictute = new JTextField();
		txtPictute.setColumns(10);
		txtPictute.setBounds(156, 130, 227, 19);
		frame.getContentPane().add(txtPictute);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null); 

		        if (returnValue == JFileChooser.APPROVE_OPTION) { 
		            File selectedFile = fileChooser.getSelectedFile();
		            System.out.println("File đã chọn: " + selectedFile.getAbsolutePath());
		            txtPictute.setText(selectedFile.getAbsolutePath());
		        }
		        
		        
		        
			}
		});
		btnNewButton.setBounds(404, 130, 36, 20);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setBounds(31, 41, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SĐT");
		lblNewLabel_1.setBounds(31, 89, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hình Ảnh");
		lblNewLabel_2.setBounds(31, 134, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblhinhanh = new JLabel();
		lblhinhanh.setBounds(495, 41, 276, 291);
		frame.getContentPane().add(lblhinhanh);
		
		
		JButton btnAdd = new JButton("Thêm Liên Hệ");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name = txtName.getText();
				String SDT = txtTel.getText();
				String linkHA = txtPictute.getText();
				Users lh = new Users(Name,SDT,linkHA);
				if(Name.isEmpty() || SDT.isEmpty() || linkHA.isEmpty())
				{
					JOptionPane.showMessageDialog(btnAdd,"Vui lòng nhập đầy đủ thông tin");
					return;
				}
				try {
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("APIUser.txt"));//,true
//					oos.writeUTF(Name);
//					oos.writeUTF(SDT);
//					oos.writeUTF(linkHA);
					
					oos.writeObject(lh); // sử dụng ghi object
					oos.close();
					JOptionPane.showMessageDialog(btnAdd,"Đã thêm liên hệ: " + lh.getUserName()+"-"+lh.getTel() +"-"+ lh.getHinhAnh());
					String imagePath = lh.getHinhAnh();
				    File file = new File(imagePath);

				    
				    if (!file.exists()) {
				        JOptionPane.showMessageDialog(frame, "Ảnh không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				    } else {
				        
				        BufferedImage img1 = ImageIO.read(file);
				        if (img1 != null) {
				            Image scaledImg = img1.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				            lblhinhanh.setIcon(new ImageIcon(scaledImg));
				        } else {
				            JOptionPane.showMessageDialog(frame, "Không thể đọc ảnh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				        }
				    }

				    // Cập nhật UI
				    frame.revalidate();
				    frame.repaint();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(btnAdd,"Không ghi được file API");
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(188, 178, 104, 21);
		
		
		
		
		
		frame.getContentPane().add(btnAdd);
		//JFileChooser fileChooser = new JFileChooser();
//		int result = fileChooser.showOpenDialog(null);
//		if (result == JFileChooser.APPROVE_OPTION) {
//		    File file = fileChooser.getSelectedFile();
//		    System.out.println("File đã chọn: " + file.getAbsolutePath());
//		}
	}
}
