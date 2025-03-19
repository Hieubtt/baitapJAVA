package Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import Package.GiftBox.Gift;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.StringJoiner;
import java.awt.event.ActionEvent;

public class FrmDV {

	private JFrame frame;
	private JTextField txthinhDang;
	private JTextField txtMau;
	private JTextField txtName;
	private JTextField txtWeight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDV window = new FrmDV();
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
	public FrmDV() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 765, 610);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Th\u00F4ng tin h\u00F4\u0323p qua\u0300");
		lblNewLabel.setBounds(29, 48, 96, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHinhDangHp = new JLabel("Hi\u0300nh da\u0301ng h\u00F4\u0323p qua\u0300 ");
		lblHinhDangHp.setBounds(61, 81, 96, 23);
		frame.getContentPane().add(lblHinhDangHp);
		
		JLabel lblMauSc = new JLabel("Ma\u0300u s\u0103\u0301c");
		lblMauSc.setBounds(61, 124, 96, 23);
		frame.getContentPane().add(lblMauSc);
		
		JLabel lblThngTinQua = new JLabel("Th\u00F4ng tin qua\u0300");
		lblThngTinQua.setBounds(61, 181, 96, 23);
		frame.getContentPane().add(lblThngTinQua);
		
		JLabel lblTnQua = new JLabel("T\u00EAn qua\u0300");
		lblTnQua.setBounds(61, 226, 96, 23);
		frame.getContentPane().add(lblTnQua);
		
		JLabel lblTrongLng = new JLabel("Tro\u0323ng l\u01B0\u01A1\u0323ng");
		lblTrongLng.setBounds(61, 269, 96, 23);
		frame.getContentPane().add(lblTrongLng);
		
		JLabel lblNewLabel_7 = new JLabel("Th\u00F4ng tin g\u01B0\u0309i qua\u0300");
		lblNewLabel_7.setBounds(29, 372, 96, 23);
		frame.getContentPane().add(lblNewLabel_7);
		JTextArea txtResult = new JTextArea();
		JButton btnSend = new JButton("G\u01B0\u0309i qua\u0300");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String Ten
				String ten = txtName.getText().trim();
				String hinhDang = txthinhDang.getText().trim();
				String mauSac = txtMau.getText().trim();
				String trongLuong = txtWeight.getText().trim();
				
				if(ten.isEmpty() || hinhDang.isEmpty() || mauSac.isEmpty() || trongLuong.isEmpty())
				{
					JOptionPane.showMessageDialog(null,"Hãy nhập đầy đủ thông tin");
					return;
				}
				
				Double TrongLuong = Double.parseDouble(trongLuong);
				
				GiftBox gb = new GiftBox(hinhDang, mauSac);
				GiftBox.Gift g = gb.new Gift(ten, TrongLuong);
				
				StringJoiner sb = new StringJoiner("\n----------------------\n");
				sb.add(String.format("Màu sắc hộp quà: %s \n Hình dạng: %s \n Phí làm hộp: %d \n Tên hộp quà: %s \n Trọng lượng hợp quà: %.2f",
					    gb.getMauSac(),
					    gb.getHinhDang(),
					    gb.getPhilamHop(),
					    g.getTen(),
					    g.gettrongLuong()
						));
				txtResult.setText(sb.toString());
				
			}
		});
		btnSend.setBounds(347, 315, 242, 43);
		frame.getContentPane().add(btnSend);
		
		txthinhDang = new JTextField();
		txthinhDang.setBounds(237, 83, 229, 19);
		frame.getContentPane().add(txthinhDang);
		txthinhDang.setColumns(10);
		
		txtMau = new JTextField();
		txtMau.setColumns(10);
		txtMau.setBounds(237, 126, 229, 19);
		frame.getContentPane().add(txtMau);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(237, 228, 229, 19);
		frame.getContentPane().add(txtName);
		
		txtWeight = new JTextField();
		txtWeight.setColumns(10);
		txtWeight.setBounds(237, 271, 229, 19);
		frame.getContentPane().add(txtWeight);
		
		
		txtResult.setBounds(221, 371, 315, 177);
		frame.getContentPane().add(txtResult);
	}
}
