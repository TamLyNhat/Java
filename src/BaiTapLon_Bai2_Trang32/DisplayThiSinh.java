package BaiTapLon_Bai2_Trang32;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Database.AddressBookDisplay;

public class DisplayThiSinh extends JFrame{
	
	private JPanel displayPanel;
	private JPanel displaybutton;
	
	private JLabel ThongTinThiSinh;
	private JLabel lbsobaodanh;
	private JLabel lbhoten;
	private JLabel lbdienthoai;
	private JLabel lbdiemlt;
	private JLabel lbdiemth;
	
	private JTextField sobaodanh;
	private JTextField hoten;
	private JTextField dienthoai;
	private JTextField diemLT;
	private JTextField diemTH;
	
	private JButton them;
	private JButton sua;
	private JButton luu;
	private JButton xoa;
	private JButton huy;
	
	private static JTable bang;
	
	static DefaultTableModel tbn = new DefaultTableModel();
	private DefaultTableModel tblModel;
	private String[] header = new String[]{"soBaoDanh", "hoTen", "dienThoai","diemLyThuyet","diemThucHanh"};

	
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	public DisplayThiSinh()
	{

		displayPanel = new JPanel();
		displaybutton = new JPanel();
		
		setLayout(new FlowLayout());

		ThongTinThiSinh = new JLabel("Thông Tin Thí Sinh");
		add(ThongTinThiSinh);
		
		lbsobaodanh = new JLabel();
		lbhoten = new JLabel();
		lbdienthoai = new JLabel();
		lbdiemlt = new JLabel();
		lbdiemth = new JLabel();
		
		sobaodanh = new JTextField(20);
		hoten = new JTextField(20);
		dienthoai = new JTextField(20);
		diemLT = new JTextField(20);
		diemTH = new JTextField(20);
		
		them = new JButton("Thêm");
		sua = new JButton("Sửa");
		luu = new JButton("Lưu");
		huy = new JButton("Hủy");
		xoa = new JButton("Xóa");
		
		bang = new JTable();
		
		
		setSize(500, 500);
		setResizable( false );
		
		//5 hang 2 cot, khoang canh 4
		displayPanel.setLayout(new GridLayout(5, 2, 4, 4));
		
		lbsobaodanh.setText("Số báo danh");
		displayPanel.add(lbsobaodanh);
		displayPanel.add(sobaodanh);
		
		lbhoten.setText("Họ Tên");
		displayPanel.add(lbhoten);
		displayPanel.add(hoten);
		
		lbdienthoai.setText("Điện thoại");
		displayPanel.add(lbdienthoai);
		displayPanel.add(dienthoai);
		
		lbdiemlt.setText("Điểm lý thuyết");
		displayPanel.add(lbdiemlt);
		displayPanel.add(diemLT);
		
		lbdiemth.setText("Điểm thực hành");
		displayPanel.add(lbdiemth);
		displayPanel.add(diemTH);
		
		add(displayPanel);
		
		//1 hang 4 cot
		displaybutton.setLayout(new GridLayout(1, 4, 2, 2));
		
		displaybutton.add(them);
		displaybutton.add(huy);
		displaybutton.add(sua);
		displaybutton.add(xoa);
		displaybutton.add(luu);

		add(displaybutton);
		
		bang.setRowHeight(20);
		bang.setBackground(Color.blue);
			
		
		
		JPanel pane1 = new JPanel();
		pane1.add(bang);
		
		//add(bang);
		
		final JPanel tblPanel= new JPanel();
		tblPanel.setLayout(new FlowLayout());
		tblPanel.setPreferredSize(new Dimension(100, 100));
		
		DefaultTableModel tblModel=new DefaultTableModel();
		bang = new JTable(tblModel);
		bang.setFillsViewportHeight(true);
		
		bang.getTableHeader().setReorderingAllowed(false);
		tblModel.addColumn("So bao danh");
		tblModel.addColumn("Ho ten");
		tblModel.addColumn("Dien thoai");
		tblModel.addColumn("Diem ly thuyet");
		tblModel.addColumn("Diem thuc hanh");
		add(new JScrollPane(bang));
		
		
		bang.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                bangMouseClicked(evt);
            }
        });
		
		them.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					themActionPerformed(e);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
			}
        });
		
		sua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					suaActionPerformed(e);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
			}
        });
		
		xoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					xoaActionPerformed(e);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}
			}

        });
		
		setVisible(true);
	}
		
	public void executeSQLQuery(String sql, String message) throws ClassNotFoundException, SQLException
	{
		Connection con = MySQLConnUtils.getMySQLConnection();
		Statement st;
		try
		{
			st = con.createStatement();
			
			if(st.executeUpdate(sql) == 1)
			{
				JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
				showData();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Data not " + message + " Succefully");
			}
		}catch(Exception e)
		{
			System.out.println("1");
			e.printStackTrace();
		}
	}
	
	private void bangMouseClicked(MouseEvent evt) 
	{                                     
		int i = bang.getSelectedRow();
		TableModel model = bang.getModel();
		sobaodanh.setText(model.getValueAt(i, 0).toString());
		hoten.setText(model.getValueAt(i, 1).toString());
		dienthoai.setText(model.getValueAt(i, 2).toString());
		diemLT.setText(model.getValueAt(i, 3).toString());
		diemTH.setText(model.getValueAt(i, 4).toString());
		
		sobaodanh.setEditable(false);
    }   
	
	
	private void themActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException
	{
		sobaodanh.setEditable(true);
		sobaodanh.requestFocus();
		
		String sql = "INSERT INTO thisinh(soBaoDanh, hoTen, dienThoai, diemLyThuyet, diemThucHanh) VALUES ('"+sobaodanh.getText()+"','"+hoten.getText()+"','"+dienthoai.getText()+"','"+diemLT.getText()+"','"+diemTH.getText()+"')";
		executeSQLQuery(sql,"Inserted");
		
		sobaodanh.setText("");
		hoten.setText("");
		dienthoai.setText("");
		diemLT.setText("");
		diemTH.setText("");
	}	
	
	private void suaActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException
	{
		
		String sql = "UPDATE `thisinh` SET `hoTen`='"+hoten.getText()+"',`dienThoai`='"+dienthoai.getText()+"',`diemLyThuyet`='"+diemLT.getText()+"',`diemThucHanh`="+diemTH.getText()+" WHERE `soBaoDanh` = '"+sobaodanh.getText()+"'";
		executeSQLQuery(sql,"Updated");
	}
	

	private void xoaActionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException
	{
		
		String sql = "DELETE FROM thisinh WHERE soBaoDanh= '"+ sobaodanh.getText()+"'"; 
		executeSQLQuery(sql,"Deleted");
	}
	
	//Load du lieu len JTable
	public void showData() 
	{
		try { 
			 conn = ConnectionUtils.getMyConnection();
			 tblModel = new DefaultTableModel(header, 0);
			 
		      // tao doi tuong Statement
		      stmt = conn.createStatement();

			 String sql = "select * from thisinh";

			 // tao doi tuong thuc thi cau lenhSelect
			 stmt = conn.createStatement();

			 // thuc thi
			 rs = stmt.executeQuery(sql);
			 Vector data = null;

			 tblModel.setRowCount(0);

			 // Trong khi chua co du lieu
			 while (rs.next()) {
			   data = new Vector();
			   data.add(rs.getString("soBaoDanh"));
			   data.add(rs.getString("hoTen"));
			   data.add(rs.getString("dienThoai"));
			   data.add(rs.getFloat("diemLyThuyet"));
			   data.add(rs.getFloat("diemThucHanh"));

			   // them data vao table model
			   tblModel.addRow(data);
			 }

			 bang.setModel(tblModel); // them du lieu vao table
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		DisplayThiSinh ts = new DisplayThiSinh();
		//DisplayThiSinh.loadform();
		ts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ts.setVisible(true);
		ts.showData();
	}
}