package runSL;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FrmTinhSoLieu extends JFrame {
    private JTextField txtQuangDuong, txtThoiGian, txtNhienLieu;
    private JTextField txtTenXe, txtHangSanXuat;
    private JTextField txtVanToc, txtTieuThuNhienLieu;
    private JRadioButton rdoXeHoi, rdoTauThuy;
    private JButton btnTinhToan;
    private JLabel label_3;
    private JTextField txtTrongLuong;
    private JTextField txtSucTai;
    private JTextField txtXuoi;
    private JTextField txtNguoc;
    private JLabel label_3_1_1_1_1_2;
    private JTextField txtNhienlieuTau;
    
    public FrmTinhSoLieu() {
        setTitle("Phuong tien giao thong - dong co");
        setSize(763, 610);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        // Labels & Inputs
        JLabel label = new JLabel("Quãng đường (km):");
        label.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label.setBounds(1, 51, 136, 27);
        getContentPane().add(label);
        txtQuangDuong = new JTextField(10);
        txtQuangDuong.setBounds(126, 52, 102, 27);
        getContentPane().add(txtQuangDuong);
        
        JLabel label_1 = new JLabel("Thời gian (giờ):");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_1.setBounds(271, 47, 111, 31);
        getContentPane().add(label_1);
        txtThoiGian = new JTextField(10);
        txtThoiGian.setBounds(367, 50, 111, 27);
        getContentPane().add(txtThoiGian);
        
        JLabel label_2 = new JLabel("Nhiên liệu (lít):");
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_2.setBounds(501, 51, 118, 27);
        getContentPane().add(label_2);
        txtNhienLieu = new JTextField(10);
        txtNhienLieu.setBounds(590, 51, 136, 27);
        getContentPane().add(txtNhienLieu);
        ButtonGroup group = new ButtonGroup();
        
        JLabel label_4 = new JLabel("Tên xe:");
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_4.setBounds(10, 175, 48, 31);
        getContentPane().add(label_4);
        txtTenXe = new JTextField(10);
        txtTenXe.setBounds(104, 177, 96, 27);
        getContentPane().add(txtTenXe);
        
        JLabel label_5 = new JLabel("Hãng sản xuất:");
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_5.setBounds(10, 211, 150, 27);
        getContentPane().add(label_5);
        txtHangSanXuat = new JTextField(10);
        txtHangSanXuat.setBounds(102, 214, 98, 31);
        getContentPane().add(txtHangSanXuat);
        
        // Button
        btnTinhToan = new JButton("Tính vận tốc - Tiêu thụ nhiên liệu");
        btnTinhToan.setBounds(10, 301, 183, 39);
        getContentPane().add(btnTinhToan);
        
        // Results
        JLabel label_7 = new JLabel("Vận tốc (km/h):");
        label_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_7.setBounds(10, 390, 111, 39);
        getContentPane().add(label_7);
        txtVanToc = new JTextField(10);
        txtVanToc.setBounds(104, 396, 124, 27);
        txtVanToc.setEditable(false);
        getContentPane().add(txtVanToc);
        
        JLabel label_8 = new JLabel("Tiêu thụ nhiên liệu (km/lit):");
        label_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_8.setBounds(232, 390, 143, 39);
        getContentPane().add(label_8);
        txtTieuThuNhienLieu = new JTextField(10);
        txtTieuThuNhienLieu.setBounds(385, 390, 221, 31);
        txtTieuThuNhienLieu.setEditable(false);
        getContentPane().add(txtTieuThuNhienLieu);
        rdoXeHoi = new JRadioButton("Xe hoi");
        rdoXeHoi.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdoXeHoi.setBounds(23, 116, 137, 21);
        getContentPane().add(rdoXeHoi);
        group.add(rdoXeHoi);
        rdoTauThuy = new JRadioButton("Tàu thủy");
        rdoTauThuy.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdoTauThuy.setBounds(181, 116, 148, 21);
        getContentPane().add(rdoTauThuy);
        group.add(rdoTauThuy);
        
        label_3 = new JLabel("Trọng lượng");
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_3.setBounds(329, 111, 74, 31);
        getContentPane().add(label_3);
        
        txtTrongLuong = new JTextField(10);
        txtTrongLuong.setBounds(511, 115, 108, 27);
        getContentPane().add(txtTrongLuong);
        
        JLabel label_3_1 = new JLabel("Sức tải");
        label_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_3_1.setBounds(329, 147, 74, 31);
        getContentPane().add(label_3_1);
        
        txtSucTai = new JTextField(10);
        txtSucTai.setBounds(511, 151, 108, 27);
        getContentPane().add(txtSucTai);
        
        JLabel label_3_1_1_1_1 = new JLabel("Vận tốc xuôi dòng(km/h)");
        label_3_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_3_1_1_1_1.setBounds(329, 202, 172, 31);
        getContentPane().add(label_3_1_1_1_1);
        
        JLabel label_3_1_1_1_1_1 = new JLabel("Vận tốc ngược dòng(km/h)");
        label_3_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_3_1_1_1_1_1.setBounds(329, 245, 172, 31);
        getContentPane().add(label_3_1_1_1_1_1);
        
        txtXuoi = new JTextField(10);
        txtXuoi.setBounds(511, 205, 108, 27);
        getContentPane().add(txtXuoi);
        
        txtNguoc = new JTextField(10);
        txtNguoc.setBounds(511, 248, 108, 27);
        getContentPane().add(txtNguoc);
        
        JTextArea txtResult = new JTextArea();
        txtResult.setBounds(35, 453, 635, 110);
        getContentPane().add(txtResult);
        
        label_3_1_1_1_1_2 = new JLabel("Nhiên liệu tiêu hao(lít)");
        label_3_1_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label_3_1_1_1_1_2.setBounds(329, 297, 172, 31);
        getContentPane().add(label_3_1_1_1_1_2);
        
        txtNhienlieuTau = new JTextField(10);
        txtNhienlieuTau.setBounds(511, 300, 108, 27);
        getContentPane().add(txtNhienlieuTau);
        
        // Button Action
        btnTinhToan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 
            	try {
                     if(rdoXeHoi.isSelected())
                     {
                    	 String tenXe = txtTenXe.getText().trim();
                    	 String hangSX = txtHangSanXuat.getText().trim();
                    	 double quangDuong = Double.parseDouble(txtQuangDuong.getText());
                         double thoiGian = Double.parseDouble(txtThoiGian.getText());
                         double nhienLieu = Double.parseDouble(txtNhienLieu.getText()); 
                         //double tieuThuNhienLieu = quangDuong / nhienLieu;
                         
                         XeHoi xh = new XeHoi(tenXe,hangSX);
                         
                         double vantoc = xh.tinhVanToc(quangDuong, thoiGian);
                         double tieuhaonhienlieu =xh.tinhTieuThuNhienLieu(quangDuong, vantoc);
                         
                         txtVanToc.setText(String.format("%.2f",vantoc));
                         txtTieuThuNhienLieu.setText(String.format("%.2f", tieuhaonhienlieu));
                         txtResult.setText(String.format("Xe %s , hãng sản xuất : %s , vận tốc là : %.2f , nhiên liệu tiêu thụ : %.2f ",xh.getTenXe(),xh.hangsanXuat,vantoc,tieuhaonhienlieu));
                     }
                     
                     else if (rdoTauThuy.isSelected()) 
                     {
//                    	 String tenXe = txtTenXe.getText().trim();
//                    	 String hangSX = txtHangSanXuat.getText().trim();
                    	 double quangDuong = Double.parseDouble(txtQuangDuong.getText());
                         double thoiGian = Double.parseDouble(txtThoiGian.getText());
                         double nhienLieuTau = Double.parseDouble(txtNhienlieuTau.getText());
                         double trongLuong = Double.parseDouble(txtTrongLuong.getText());
                         int sucTai = Integer.parseInt(txtSucTai.getText());
                         double VtXuoi = Double.parseDouble(txtXuoi.getText());
                         double VtNguoc = Double.parseDouble(txtNguoc.getText());
                         //double tieuThuNhienLieu = quangDuong / nhienLieu;
                         
                         TauThuy tt = new TauThuy( trongLuong,  sucTai,  VtXuoi,  VtNguoc,
                        		 nhienLieuTau);
                         
                         double vantoc = tt.tinhVanToc(quangDuong, thoiGian);
                         double tieuhaonhienlieu =tt.tinhTieuThuNhienLieu(quangDuong, vantoc);
                         
                         txtVanToc.setText(String.format("%.2f",vantoc));
                         txtTieuThuNhienLieu.setText(String.format("%.2f", tieuhaonhienlieu));
                         txtResult.setText(String.format("Vận tốc là : %.2f , nhiên liệu tiêu thụ : %.2f ",vantoc,tieuhaonhienlieu));
                     }
                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(null,"Nhập số thông tin cần tính ! ");
                 }
            }
        });
    }
    
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmTinhSoLieu().setVisible(true));
    }
}
