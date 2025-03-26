package thuchanh;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;

public class FrmGhiChu {

	private JFrame frmGhiChu;
	private JTextField txtValue;
	private JTextField txtNgay;
	private LocalDate date =LocalDate.now();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmGhiChu window = new FrmGhiChu();
					window.frmGhiChu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmGhiChu() {
		initialize();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String text = date.format(dtf);
		//System.out.print(d);
		txtNgay.setText(text);
		
		JLabel lblNewLabel_1 = new JLabel("Thời Gian Ghi");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(520, 33, 104, 13);
		frmGhiChu.getContentPane().add(lblNewLabel_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGhiChu = new JFrame();
		frmGhiChu.setTitle("Ghi Chu\u0301 ");
		frmGhiChu.setBounds(100, 100, 726, 551);
		frmGhiChu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGhiChu.getContentPane().setLayout(null);
		
		txtValue = new JTextField();
		txtValue.setBounds(116, 10, 372, 147);
		frmGhiChu.getContentPane().add(txtValue);
		txtValue.setColumns(10);
		
		JTextArea txtResult = new JTextArea();
		txtResult.setBounds(111, 175, 430, 158);
		frmGhiChu.getContentPane().add(txtResult);
		
		JButton btnNew = new JButton("NEW");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValue.setText("");
				txtResult.setText("");
			}
		});
		btnNew.setBounds(520, 102, 182, 55);
		frmGhiChu.getContentPane().add(btnNew);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String noiDung = txtValue.getText();
				String Ngay = txtNgay.getText();
				if(noiDung.isEmpty() || Ngay.isEmpty())
				{
					JOptionPane.showMessageDialog(btnSave,"Nhập thông tin vào giúp cái !!!");
					return;
				}
				boolean flag ;
				try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("API.txt",true))) {
					dos.writeUTF(noiDung);
					dos.writeUTF(Ngay);
					flag = true;
					
					if(flag == true)
					{
						JOptionPane.showMessageDialog(btnSave,"File ghi nhận thành công!!!");
					}
				} catch (FileNotFoundException e1) {
					
					JOptionPane.showConfirmDialog(btnSave,"Lỗi không ghi nhận được file !");
					return;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(299, 362, 221, 63);
		frmGhiChu.getContentPane().add(btnSave);
		
		JButton btnOpen = new JButton("M\u01A1\u0309 t\u00EA\u0323p tin ");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Noidung = "";
				String ngay;
				String Result1 ="";
				try {
					DataInputStream dis = new DataInputStream(new FileInputStream("API.txt"));
					while(true)
					{	
						try {
							Noidung=dis.readUTF();
							ngay = dis.readUTF();
							Result1 = ngay + "\n" + Noidung + "\n";
							
						} catch (EOFException e2) {
							break;
						}
					}
					dis.close();
				} catch (FileNotFoundException e1) {
					
					JOptionPane.showMessageDialog(btnOpen,"Không tìm thấy file API");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				txtResult.setText(Result1);
			}
		});
		btnOpen.setBounds(107, 357, 164, 72);
		frmGhiChu.getContentPane().add(btnOpen);
		
		JLabel lblNewLabel = new JLabel("Nhật Ký");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 58, 96, 13);
		frmGhiChu.getContentPane().add(lblNewLabel);
		
		JLabel lblNiDung = new JLabel("Nội Dung");
		lblNiDung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNiDung.setBounds(10, 180, 91, 13);
		frmGhiChu.getContentPane().add(lblNiDung);
		
		
		txtNgay = new JTextField();
		
		txtNgay.setBounds(520, 56, 180, 19);
		frmGhiChu.getContentPane().add(txtNgay);
		txtNgay.setColumns(10);
	}
}
