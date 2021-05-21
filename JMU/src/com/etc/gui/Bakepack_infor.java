package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.etc.dao.StudentDao;
import com.etc.entity.Student;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

public class Bakepack_infor {

	private JFrame frame;
	private JFrame Myframe;
	private int i=3;
	private int n=3;
	private JLabel showInfo;
	private JLabel showInfor;
	private JComboBox comboBox;
	private Student stu;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bakepack_infor window = new bakepack_infor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public Bakepack_infor(Student stu,JFrame Myframe) {
		this.Myframe = Myframe;
		this.stu = stu;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 102));
		frame.setVisible(true);
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JCheckBox c1 = new JCheckBox("赠送玫瑰花");
		c1.setFont(new Font("华文细黑", Font.BOLD, 13));
		c1.setForeground(new Color(255, 0, 0));
		c1.setBackground(new Color(255, 204, 0));
		c1.setBounds(10, 222, 120, 27);
		frame.getContentPane().add(c1);
		
		final JCheckBox c2 = new JCheckBox("赠送爱心");
		c2.setFont(new Font("华文细黑", Font.BOLD, 13));
		c2.setForeground(new Color(255, 0, 0));
		c2.setBackground(new Color(255, 204, 0));
		c2.setBounds(147, 222, 120, 27);
		frame.getContentPane().add(c2);
		//玫瑰图片
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setMargin(new Insets(0,0,0,0));
		btnNewButton.setIcon(new ImageIcon("images/meigui.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(10, 57, 130, 130);
		frame.getContentPane().add(btnNewButton);
			
		//爱心图片
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setMargin(new Insets(0,0,0,0));
		btnNewButton_1.setIcon(new ImageIcon("images/aixin.png"));
		btnNewButton_1.setBounds(137, 57, 130, 130);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("返回上一级");
		button.setFont(new Font("华文细黑", Font.BOLD, 14));
		button.setForeground(new Color(255, 0, 0));
		button.setBackground(new Color(255, 204, 0));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//返回上一级

				Myframe.setVisible(true);
				
				frame.dispose();
				
			}
		});
		button.setBounds(80, 317, 113, 34);
		frame.getContentPane().add(button);
		
		//显示玫瑰状态
		showInfo = new JLabel("");
		showInfo.setBounds(20, 189, 84, 27);
		frame.getContentPane().add(showInfo);
		
		//显示爱心状态
		showInfor = new JLabel("");
		showInfor.setBounds(10, 189, 110, 34);
		frame.getContentPane().add(showInfor);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "095", "113", "090", "096", "094", "116"}));
		comboBox.setBounds(112, 15, 120, 24);
		frame.getContentPane().add(comboBox);
		
		JLabel label = new JLabel("\u9009\u62E9\u8D60\u9001\u5BF9\u8C61:");
		label.setFont(new Font("华文细黑", Font.BOLD, 13));
		label.setForeground(new Color(255, 0, 0));
		label.setBounds(10, 10, 133, 35);
		frame.getContentPane().add(label);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//赠送玫瑰
				if(c1.isSelected()){
					showInfo.setText("");
					if(stu.getFlower()==0){
						showInfo.setText("");
						showInfo.setText("玫瑰余额不足");
					}else{
						StudentDao sdao = new StudentDao();
						Student stemp = new Student();
						if(comboBox.getSelectedItem().equals("095")) {
							stemp = sdao.findStudentBySno(95);
							if(stemp!=null){
								stemp.setFlower(stemp.getFlower()+1);
								sdao.modifyStudent1(stemp);
								stu.setFlower(stu.getFlower()-1);
								sdao.modifyStudent1(stu);
								showInfo.setText("赠送成功!");
							}else{
								showInfo.setText("");
								showInfo.setText("此账号不存在");
							}
						}else if(comboBox.getSelectedItem().equals("113")) {
							stemp = sdao.findStudentBySno(113);
							if(stemp!=null){
								stemp.setFlower(stemp.getFlower()+1);
								sdao.modifyStudent1(stemp);
								stu.setFlower(stu.getFlower()-1);
								sdao.modifyStudent1(stu);
								showInfo.setText("赠送成功!");
							}else{
								showInfo.setText("");
								showInfo.setText("此账号不存在");
							}
						}else if(comboBox.getSelectedItem().equals("090")) {
							stemp = sdao.findStudentBySno(90);
							if(stemp!=null){
								stemp.setFlower(stemp.getFlower()+1);
								sdao.modifyStudent1(stemp);
								stu.setFlower(stu.getFlower()-1);
								sdao.modifyStudent1(stu);
								showInfo.setText("赠送成功!");
							}else{
								showInfo.setText("");
								showInfo.setText("此账号不存在");
							}
						}else if(comboBox.getSelectedItem().equals("096")) {
							stemp = sdao.findStudentBySno(96);
							if(stemp!=null){
								stemp.setFlower(stemp.getFlower()+1);
								sdao.modifyStudent1(stemp);
								stu.setFlower(stu.getFlower()-1);
								sdao.modifyStudent1(stu);
								showInfo.setText("赠送成功!");
							}else{
								showInfo.setText("");
								showInfo.setText("此账号不存在");
							}
						}else if(comboBox.getSelectedItem().equals("094")) {
							stemp = sdao.findStudentBySno(94);
							if(stemp!=null){
								stemp.setFlower(stemp.getFlower()+1);
								sdao.modifyStudent1(stemp);
								stu.setFlower(stu.getFlower()-1);
								sdao.modifyStudent1(stu);
								showInfo.setText("赠送成功!");
							}else{
								showInfo.setText("");
								showInfo.setText("此账号不存在");
							}
						}else if(comboBox.getSelectedItem().equals("116")) {
							stemp = sdao.findStudentBySno(116);
							if(stemp!=null){
								stemp.setFlower(stemp.getFlower()+1);
								sdao.modifyStudent1(stemp);
								stu.setFlower(stu.getFlower()-1);
								sdao.modifyStudent1(stu);
								showInfo.setText("赠送成功!");
							}else{
								showInfo.setText("");
								showInfo.setText("此账号不存在");
							}
						}
						
					}
				}else{
					JOptionPane.showMessageDialog(null,"送啥你好歹选一下呐","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}
				/*if(c1.isSelected()||c2.isSelected()){
					showInfo.setText("");
					showInfor.setText("");
					if(stu.getFlower() == 0&&c1.isSelected()) {
						showInfo.setText("");
						showInfo.setText("玫瑰余额不足");
					}else if(stu.getFlower()!=0&&c1.isSelected()){
					
						if(comboBox.getSelectedItem().equals("095")) {
							showInfo.setText("赠送成功!");
							stu.setFlower(stu.getFlower()-1);
						}else if(comboBox.getSelectedItem().equals("113")) {
							//
							showInfo.setText("赠送成功!");
							stu.setFlower(stu.getFlower()-1);
						}else if(comboBox.getSelectedItem().equals("090")) {
							//
							showInfo.setText("赠送成功!");
							stu.setFlower(stu.getFlower()-1);
						}else if(comboBox.getSelectedItem().equals("096")) {
							//
							showInfo.setText("赠送成功!");
							stu.setFlower(stu.getFlower()-1);
						}else if(comboBox.getSelectedItem().equals("094")) {
							//
							showInfo.setText("赠送成功!");
							stu.setFlower(stu.getFlower()-1);
						}else if(comboBox.getSelectedItem().equals("116")) {
							//
							showInfo.setText("赠送成功!");
							stu.setFlower(stu.getFlower()-1);
						}
						
					}
				}else{
					JOptionPane.showMessageDialog(null,"送啥你好歹选一下呐","ERROR",JOptionPane.INFORMATION_MESSAGE);
				}*/
			}
		});
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSend.setBounds(88, 266, 93, 23);
		frame.getContentPane().add(btnSend);
	}
}
