package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.etc.dao.StudentDao;
import com.etc.entity.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AdminShowGUI {

	private JFrame frame;
	private JTable table;
	private JButton btnSno;
	private JTextField snoText;
	private JTextField snameText;
	private JTextField pwdText;
	private JTextField fnumText;
	private JButton button_1;
	private JFrame Crtlframe;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminShowGUI window = new AdminShowGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public AdminShowGUI(JFrame Crtlframe) {
		this.Crtlframe = Crtlframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setVisible(true);
		frame.setBounds(100, 100, 677, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton findALL = new JButton("显示所有学生信息");
		findALL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentDao sdao = new StudentDao();
				List<Student> list = sdao.findAllStudent();
				Object[][] obj = new Object[list.size()][7];
				for(int i=0;i<list.size();i++){
					obj[i][0] = list.get(i).getSno();
					obj[i][1] = list.get(i).getSname();
					obj[i][2] = list.get(i).getSpwd();
					obj[i][3] = list.get(i).getSage();
					obj[i][4] = list.get(i).getFlower();
					obj[i][5] = list.get(i).getBirthday();
					obj[i][6] = list.get(i).getStn();
				}
				
				table.setModel(new DefaultTableModel(obj,new String[] {
						"s number", "s name", "s pwd", "s age", "flowernum", "birthday", "s tnumber"
				}));
			}
		});
		findALL.setBounds(10, 21, 142, 23);
		frame.getContentPane().add(findALL);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 54, 618, 107);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*snoText.setText(table_1.getValueAt(table_1.getSelectedRow(), 0)
						+ "");
				snameText.setText(table_1.getValueAt(table_1.getSelectedRow(),
						1) + "");
				pwdText.setText(table_1.getValueAt(table_1.getSelectedRow(), 2)
						+ "");
				ageText.setText(table_1.getValueAt(table_1.getSelectedRow(), 3)
						+ "");*/
				
				snoText.setText(table.getValueAt(table.getSelectedRow(), 0)+"");
				snameText.setText(table.getValueAt(table.getSelectedRow(), 1)+"");
				pwdText.setText(table.getValueAt(table.getSelectedRow(), 2)+"");
				fnumText.setText(table.getValueAt(table.getSelectedRow(), 4)+"");
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				" sno", " sname", "  spwd", " sage", "flower", " birthday", "  stnumber"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(45);
		table.getColumnModel().getColumn(1).setPreferredWidth(54);
		table.getColumnModel().getColumn(2).setPreferredWidth(65);
		table.getColumnModel().getColumn(3).setPreferredWidth(46);
		table.getColumnModel().getColumn(4).setPreferredWidth(46);
		table.getColumnModel().getColumn(6).setPreferredWidth(86);
		scrollPane.setViewportView(table);
		
		btnSno = new JButton("sno");
		btnSno.setBounds(10, 171, 51, 23);
		frame.getContentPane().add(btnSno);
		
		snoText = new JTextField();
		snoText.setEditable(false);
		snoText.setBounds(71, 172, 66, 21);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		JButton btnSname = new JButton("name");
		btnSname.setBounds(150, 171, 57, 23);
		frame.getContentPane().add(btnSname);
		
		snameText = new JTextField();
		snameText.setBounds(217, 172, 66, 21);
		frame.getContentPane().add(snameText);
		snameText.setColumns(10);
		
		JButton btnNewButton = new JButton("pwd");
		btnNewButton.setBounds(287, 171, 51, 23);
		frame.getContentPane().add(btnNewButton);
		
		pwdText = new JTextField();
		pwdText.setBounds(344, 172, 66, 21);
		frame.getContentPane().add(pwdText);
		pwdText.setColumns(10);
		
		JButton btnFlowernum = new JButton("flowernum");
		btnFlowernum.setBounds(415, 171, 93, 23);
		frame.getContentPane().add(btnFlowernum);
		
		fnumText = new JTextField();
		fnumText.setBounds(518, 172, 66, 21);
		frame.getContentPane().add(fnumText);
		fnumText.setColumns(10);
		
		JButton upBtn = new JButton("\u786E\u8BA4\u4FEE\u6539");
		upBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student ustu = new Student();
				StudentDao usdao = new StudentDao();
				ustu.setSno(Integer.parseInt(snoText.getText()));
				if(pwdText.getText().length()==0){
					JOptionPane.showMessageDialog(null, "密码不能为空哦", "TIP", JOptionPane.INFORMATION_MESSAGE);
				}else{
					if(snameText.getText().length()!=0||fnumText.getText().length()!=0){
						ustu.setSname(snameText.getText());
						//
						if("".equals(snoText.getText())){
							JOptionPane.showMessageDialog(null, "ERROR", "TIP", JOptionPane.INFORMATION_MESSAGE);
						}else{
							ustu.setSno(Integer.parseInt(snoText.getText()));
							ustu.setFlower(Integer.parseInt(fnumText.getText()));
							ustu.setSpwd(pwdText.getText());
							usdao.modifyStudent1(ustu);
							JOptionPane.showMessageDialog(null, "OK", "result", JOptionPane.INFORMATION_MESSAGE);
						}
						
					}else{
						if(!"".equals(snoText.getText())){
							if(snameText.getText().length()==0){
								ustu.setSname(null);
								ustu.setFlower(Integer.parseInt(fnumText.getText()));
								ustu.setSpwd(pwdText.getText());
								usdao.modifyStudent1(ustu);
								JOptionPane.showMessageDialog(null, "OK", "result", JOptionPane.INFORMATION_MESSAGE);
							}
							if(fnumText.getText().length()==0){
								ustu.setFlower(0);
								ustu.setSname(snameText.getText());
								ustu.setSpwd(pwdText.getText());
								usdao.modifyStudent1(ustu);
								JOptionPane.showMessageDialog(null, "OK", "result", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
				}
			}
		});
		upBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upBtn.setBounds(59, 214, 93, 23);
		frame.getContentPane().add(upBtn);
		
		JButton button = new JButton("\u5220\u9664\u8BE5\u9879");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(!"".equals(snoText.getText())){
						int sno = Integer.parseInt(snoText.getText());
						StudentDao sdao = new StudentDao();
						boolean flag = sdao.deleteStudentBySno(sno);
						if (flag) {
							JOptionPane.showMessageDialog(null, "删除成功", "提示信息",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "删除失败", "提示信息",
								JOptionPane.ERROR_MESSAGE);
					}

				
				}
			}
		});
		button.setBounds(435, 214, 93, 23);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Crtlframe.setVisible(true);
				frame.dispose();
			}
		});
		button_1.setBounds(245, 214, 93, 23);
		frame.getContentPane().add(button_1);
	}
}
