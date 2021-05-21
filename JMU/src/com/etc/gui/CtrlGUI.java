package com.etc.gui;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;

public class CtrlGUI {

	private JFrame frame;
	private int ano;
	private String aname;
	private JFrame loginframe;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CtrlGUI window = new CtrlGUI(ano,aname);
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
	public CtrlGUI(int ano,String aname,JFrame loginFrame) {
		this.ano = ano;
		this.aname = aname;
		this.loginframe = loginFrame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setVisible(true);
		frame.setTitle("管理员");
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel showName = new JLabel("尊敬的"+aname+",您好");
		showName.setBounds(10, 10, 262, 25);
		frame.getContentPane().add(showName);
		
		JLabel label = new JLabel("查询学生");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				FindStudent window = new FindStudent(frame);
			}
		});
		label.setFont(new Font("华文行楷", Font.BOLD, 18));
		label.setBounds(20, 80, 89, 25);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("权限管理");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				SelectStudent window = new SelectStudent(frame);
			}
		});
		label_1.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_1.setBounds(20, 115, 89, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u4FE1\u606F\u76D1\u63A7");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "当前系统未检测到违规信息", "安全", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		label_2.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_2.setBounds(20, 153, 89, 25);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u7F51\u7EDC\u7EF4\u62A4");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null, "当前网络状态良好", "安全", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		label_3.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_3.setBounds(20, 188, 89, 26);
		frame.getContentPane().add(label_3);
		
		JLabel dataSave = new JLabel("数据备份");
		dataSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null, "数据已备份", "哎呀呀", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		dataSave.setFont(new Font("华文行楷", Font.BOLD, 18));
		dataSave.setBounds(20, 224, 89, 25);
		frame.getContentPane().add(dataSave);

		JLabel label_4 = new JLabel("返回");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginframe.setVisible(true);
				frame.dispose();
			}
		});
		label_4.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_4.setBounds(42, 259, 112, 25);
		frame.getContentPane().add(label_4);
		dataSave.setFont(new Font("华文行楷", Font.BOLD, 18));
		
		JLabel label_5 = new JLabel("\u67E5\u770B\u6240\u6709");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminShowGUI window = new AdminShowGUI(frame);
				frame.setVisible(false);
			}
		});
		label_5.setFont(new Font("华文行楷", Font.BOLD, 18));
		label_5.setBounds(20, 45, 89, 25);
		frame.getContentPane().add(label_5);
		//管理员头像
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setMargin(new Insets(0,0,0,0));
		button.setIcon(new ImageIcon("images/guanliyuan.jpg"));
		button.setBounds(163, 48, 95, 95);
		frame.getContentPane().add(button);
		
	}
}
