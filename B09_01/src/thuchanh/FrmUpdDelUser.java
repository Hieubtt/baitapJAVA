package thuchanh;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmUpdDelUser {

	private JFrame frame;
	private JTextField txtName;
	private JTextField txtTel;
	private JTextField txtLinkHinh;
	private JTable table;
	private List<Users> lst = new ArrayList<Users>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUpdDelUser window = new FrmUpdDelUser();
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
	public FrmUpdDelUser() {
		initialize();
		try {
			@SuppressWarnings("unused")
			DefaultTableModel dfm=	new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Hình Anh", "Họ Tên", "Số Điện Thoại"
					}
				) {
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
			DataInputStream dis = new DataInputStream(new FileInputStream("APIUser1.txt"));
			while(true)
			{
				String name = dis.readUTF();      // Cột 1: tên
				String phone = dis.readUTF();     // Cột 2: email
				String linkhinh = dis.readUTF();     // Cột 3: số điện thoại
				Users u = new Users(name,phone,linkhinh);
				lst.add(u);
				
				for(Users i : lst)
				{
					File file = new File(u.getHinhAnh());
					try {
				        BufferedImage img1 = ImageIO.read(file);
				        if (img1 != null) {
				            Image scaledImg = img1.getScaledInstance(100, 50, Image.SCALE_SMOOTH);
				            ImageIcon icon = new ImageIcon(scaledImg);
				            dfm.addRow(new Object [] {icon,u.getUserName(),u.getTel()});///
				            table.setModel(dfm);
				            System.out.println(" UserName: " + u.getUserName() + " - " + u.getTel() + u.getHinhAnh());
				        } else {
				            JOptionPane.showMessageDialog(frame, "Không thể đọc ảnh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				        }
			    	}
					catch (IOException e1) {
	                    JOptionPane.showMessageDialog(frame, "Lỗi khi đọc ảnh: " + e1.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
	                }
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 580, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(65, 31, 155, 19);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("T\u00EAn");
		lblNewLabel.setBounds(10, 34, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(346, 31, 155, 19);
		frame.getContentPane().add(txtTel);
		
		JLabel lblTel = new JLabel("Tel");
		lblTel.setBounds(305, 34, 45, 13);
		frame.getContentPane().add(lblTel);
		
		JLabel lblHinh = new JLabel("Hi\u0300nh");
		lblHinh.setBounds(10, 94, 45, 13);
		frame.getContentPane().add(lblHinh);
		
		txtLinkHinh = new JTextField();
		txtLinkHinh.setColumns(10);
		txtLinkHinh.setBounds(65, 91, 303, 19);
		frame.getContentPane().add(txtLinkHinh);
		
		JButton btnNewButton = new JButton("...");
		btnNewButton.setBounds(393, 90, 60, 21);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 167, 451, 230);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Hi\u0300nh A\u0309nh", "Ho\u0323 T\u00EAn", "S\u00F4\u0301 \u0110i\u00EA\u0323n Thoa\u0323i"
			}
		));
		scrollPane.setColumnHeaderView(table);
		
		JButton btnDelete = new JButton("Xoa\u0301");
		btnDelete.setBounds(179, 136, 85, 21);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("C\u00E2\u0323p Nh\u00E2\u0323t");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdate.setBounds(65, 136, 85, 21);
		frame.getContentPane().add(btnUpdate);
	}
}
