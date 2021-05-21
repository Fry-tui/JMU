package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.etc.dao.StudentDao;
import com.etc.entity.Student;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindStudent {

	private JFrame frame;
	private JTextField snoText;
	private JFrame AdminFrame;
	private JLabel showInfor;
	private JLabel showInfor1;
	private JButton button;
	private JFrame FindStudent;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindStudent window = new FindStudent();
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
	public FindStudent(JFrame frame1) {
		AdminFrame = frame1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入你要查询的学生学号:");
		label.setBounds(14, 13, 197, 18);
		frame.getContentPane().add(label);
		
		snoText = new JTextField();
		snoText.setBounds(60, 39, 129, 24);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(snoText.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "快选一个同学!", "错误!", JOptionPane.CANCEL_OPTION);
				}else {
					int g = Integer.parseInt(snoText.getText());
					Student stu = new Student();
					StudentDao sdao = new StudentDao();
					stu = sdao.findStudentBySno(g);
					System.out.println(stu.getSname());
					showInfor.setText("\t姓名    \t密码    \t学号    \t年龄    \t花花");
				    showInfor1.setText(" "+stu.getSname()+"         "+stu.getSpwd()+"        "+stu.getSno()+"         "+stu.getSage()+"         "+stu.getFlower());
					/*System.out.println("\t姓名\t密码\t名字\t年龄\t花花");
					System.out.println("\t"+stu.getSname()+"\t"+stu.getSpwd()+"\t"+stu.getSname()+"\t"+stu.getSage()+"\t"+stu.getFlower());*/

				}
				
			}
		});
		btnNewButton.setBounds(192, 39, 73, 27);
		frame.getContentPane().add(btnNewButton);
		
		showInfor = new JLabel("");
		showInfor.setBounds(14, 95, 251, 76);
		frame.getContentPane().add(showInfor);
		
		showInfor1 = new JLabel("");
		showInfor1.setBounds(14, 143, 244, 84);
		frame.getContentPane().add(showInfor1);
		
		button = new JButton("返回上一级");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				AdminFrame.setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(76, 293, 113, 27);
		frame.getContentPane().add(button);
	}
}
