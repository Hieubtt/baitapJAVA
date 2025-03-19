package Work;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ToolTipManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmKeoTha {

	private JFrame frmDemoLopLong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmKeoTha window = new FrmKeoTha();
					window.frmDemoLopLong.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmKeoTha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ToolTipManager.sharedInstance().setInitialDelay(0); // Hiển thị ngay lập tức
		ToolTipManager.sharedInstance().setDismissDelay(5000); // Giữ tooltip trong 5 giây
		frmDemoLopLong = new JFrame();
		frmDemoLopLong.setTitle("Demo l\u01A1\u0301p l\u00F4\u0300ng c\u00E2\u0301p");
		frmDemoLopLong.setBounds(100, 100, 612, 485);
		frmDemoLopLong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDemoLopLong.getContentPane().setLayout(null);
		
		
		JButton BtnCo = new JButton("Đồng ý");
		BtnCo.setVisible(false);
		BtnCo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BtnCo.setToolTipText("Suy nghĩ trước khi click nha");
			}
		});
		
		JButton BtnKhong = new JButton("Không Đồng Ý");
		BtnKhong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BtnKhong.setToolTipText("Di con chuột qua bên kia nha !");
			}
		});
		BtnKhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Click bên bên click bên đây làm gì !");
				BtnKhong.setVisible(false);
				BtnCo.setVisible(true);
			}
		});
		BtnKhong.setFont(new Font("Tahoma", Font.BOLD, 20));
		BtnKhong.setBounds(24, 282, 184, 68);
		frmDemoLopLong.getContentPane().add(BtnKhong);
		
		
		BtnCo.setFont(new Font("Tahoma", Font.BOLD, 20));
		BtnCo.setBounds(335, 282, 184, 68);
		frmDemoLopLong.getContentPane().add(BtnCo);
	}
}
