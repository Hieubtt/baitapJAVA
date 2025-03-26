package thuchanh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.awt.event.ActionEvent;

public class FrmEndOfYear {

	private JFrame frame;
	private JTextField txthoTen;
	private JTextField txtLop;
	private JTextField txtScoreTB1;
	private JTextField txtScoreTB2;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmEndOfYear window = new FrmEndOfYear();
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
	public FrmEndOfYear() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txthoTen = new JTextField();
		txthoTen.setBounds(181, 33, 120, 19);
		frame.getContentPane().add(txthoTen);
		txthoTen.setColumns(10);
		
		txtLop = new JTextField();
		txtLop.setColumns(10);
		txtLop.setBounds(181, 75, 120, 19);
		frame.getContentPane().add(txtLop);
		
		txtScoreTB1 = new JTextField();
		txtScoreTB1.setColumns(10);
		txtScoreTB1.setBounds(181, 119, 120, 19);
		frame.getContentPane().add(txtScoreTB1);
		
		txtScoreTB2 = new JTextField();
		txtScoreTB2.setColumns(10);
		txtScoreTB2.setBounds(181, 159, 120, 19);
		frame.getContentPane().add(txtScoreTB2);
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ho\u0323 va\u0300 t\u00EAn", "Kh\u00F4\u0301i", "TB HK1", "TB HK2", "TB Ca\u0309 n\u0103m"
			}
		));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Th\u00EAm m\u01A1\u0301i");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hoTen = txthoTen.getText();
				String StrLop = txtLop.getText();
				String StrscoreTB1 = txtScoreTB1.getText();
				String StrscoreTB2 = txtScoreTB2.getText();
				if(hoTen.isEmpty() || StrLop.isEmpty()|| StrscoreTB1.isEmpty()|| StrscoreTB2.isEmpty())
				{
					
					JOptionPane.showMessageDialog(btnAdd,"Nhập thông tin vào ");
				}
				int Lop = Integer.parseInt(StrLop);
				if(Lop>0 && Lop<13)
				{
					try {
						@SuppressWarnings("resource")
						DataOutputStream dos = new DataOutputStream(new FileOutputStream("APIScore.txt",true));
						Double scoreTB1 = Double.parseDouble(StrscoreTB1);
						Double scoreTB2 = Double.parseDouble(StrscoreTB2);
						dos.writeUTF(hoTen);
						dos.writeInt(Lop);
						dos.writeDouble(scoreTB1);
						dos.writeDouble(scoreTB2);
						JOptionPane.showMessageDialog(btnAdd,"Đã lưu file thành công");
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(btnAdd,"Lỗi không ghi nhận được file","Lỗi",JOptionPane.ERROR_MESSAGE);
						return;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(btnAdd,"Nhập số lớp từ 1 tới 12");
				}	
				
				
			}
		});
		btnAdd.setBounds(352, 33, 113, 21);
		frame.getContentPane().add(btnAdd);
		
		JButton btnContinue = new JButton("Ti\u00EA\u0301p tu\u0323c");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txthoTen.setText("");
				txtLop.setText("");
				txtScoreTB1.setText("");
				txtScoreTB2.setText("");
				
			}
		});
		btnContinue.setBounds(352, 75, 113, 21);
		frame.getContentPane().add(btnContinue);
		
		JButton btnRead = new JButton("\u0110o\u0323c danh sa\u0301ch");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					@SuppressWarnings("resource")
					DataInputStream dis = new DataInputStream(new FileInputStream("APIScore.txt"));
				    DefaultTableModel dfm = new DefaultTableModel(new String[]{"Họ và Tên", "Khối", "TB HK1", "TB HK2","TB Cả năm"}, 0);
					
						while(true)
						{
							try {
							String value1=dis.readUTF();
							int value2=dis.readInt();
							Double value3=dis.readDouble();
							Double value4=dis.readDouble();
							Double value5 = ((value4+value3)==0)? 0:((Double)(value4+value3*2)/3);
							dfm.addRow(new Object[] {value1,value2,value3,value4,value5});
							
							} catch (EOFException  e2) {
								break;
							}
						}
						
						
						dis.close();
						table.setModel(dfm);
					
					
					
					
							
						
					//dis.close();
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(btnRead,"Lỗi không đọc được file");
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnRead.setBounds(352, 119, 113, 21);
		frame.getContentPane().add(btnRead);
		
		JButton btnThongKe = new JButton("Th\u00F4\u0301ng k\u00EA");
		btnThongKe.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
				int soHSG = 0;
				int soHSK =0;
				int soHSTB =0;
				int soHSY =0;
				
				try {
					@SuppressWarnings("resource")
					DataInputStream dis = new DataInputStream(new FileInputStream("APIScore.txt"));
				    //DefaultTableModel dfm = new DefaultTableModel(new String[]{"Họ và Tên", "Khối", "TB HK1", "TB HK2","TB Cả năm"}, 0);
					
						while(true)
						{
							try {
							String value1=dis.readUTF();
							int value2=dis.readInt();
							Double value3=dis.readDouble();
							Double value4=dis.readDouble();
							Double value5 = ((value4+value3)==0)? 0:((Double)(value4+value3*2)/3);
							//dfm.addRow(new Object[] {value1,value2,value3,value4,value5});
							if(value5>=8)
							{
								soHSG++;
							}
							else if(value5<8 && value5>=7)
							{
								soHSK++;
							}
							else if(value5<7 && value5>=5)
							{
								soHSTB++;
							}
							else
							{
								soHSY++;
							}
							} catch (EOFException  e2) {
								break;
							}
						}
						
						
						dis.close();
						//table.setModel(dfm);
					
					
					
					
							
						
					//dis.close();
					
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(btnRead,"Lỗi không đọc được file");
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				String ketQua = "Số HS giỏi: " + soHSG + "\n Số HS khá: " + soHSK + "\n Số HSTB: " + soHSTB + "\n Số HS yếu & kém: " + soHSY;
				JOptionPane.showMessageDialog(btnThongKe,ketQua,"Thống kê",1);
			}
		});
		btnThongKe.setBounds(352, 159, 113, 21);
		frame.getContentPane().add(btnThongKe);
		
		JLabel lblNewLabel = new JLabel("Ho\u0323 va\u0300 t\u00EAn");
		lblNewLabel.setBounds(67, 39, 77, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblKhiLp = new JLabel("Kh\u00F4\u0301i l\u01A1\u0301p");
		lblKhiLp.setBounds(67, 81, 77, 13);
		frame.getContentPane().add(lblKhiLp);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u0110i\u00EA\u0309m TB HK1");
		lblNewLabel_1_1.setBounds(67, 125, 77, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0110i\u00EA\u0309m TB HK2");
		lblNewLabel_1_2.setBounds(67, 165, 77, 13);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		
		scrollPane.setBounds(74, 207, 452, 200);
		frame.getContentPane().add(scrollPane);
		
		
	}
}
