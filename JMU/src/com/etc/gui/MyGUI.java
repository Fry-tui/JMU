package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFormattedTextField;

import com.etc.entity.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyGUI {

	private JFrame frame;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField null1;
	private JFrame loginFrame;
	private Student stu;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel label;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyGUI window = new MyGUI();
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
	public MyGUI(Student stu,JFrame frame1) {
		loginFrame = frame1;
		this.stu = stu;
		initialize(this.stu);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Student stu) {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 290, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setBounds(91, 123, 0, 74);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBackground(new Color(0, 0, 0));
		textField_5.setBounds(86, 123, 0, 74);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBackground(new Color(0, 0, 0));
		textField_7.setBounds(91, 81, 1, 100);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBackground(new Color(0, 0, 0));
		textField_8.setBounds(191, 80, 1, 100);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_1 = new JLabel("\u60A8\u5F53\u524D\u65E0\u53EF\u505A\u4EFB\u52A1");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.setVisible(true);
				frame.dispose();
			}
		});
		label_1.setFont(new Font("华文细黑", Font.BOLD, 17));
		label_1.setForeground(new Color(255, 0, 51));
		label_1.setBounds(58, 188, 151, 23);
		frame.getContentPane().add(label_1);
		
		null1 = new JTextField();
		null1.setBackground(Color.BLACK);
		null1.setColumns(10);
		null1.setBounds(0, 178, 274, 1);
		frame.getContentPane().add(null1);
		//用户头像
		button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setMargin(new Insets(0,0,0,0));
		button.setIcon(new ImageIcon("images/yonghu.jpg"));
		button.setBounds(106, 10, 60, 60);
		frame.getContentPane().add(button);
		//课表
		button_1 = new JButton("");
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		button_1.setMargin(new Insets(0,0,0,0));
		button_1.setIcon(new ImageIcon("images/kechengbiao.jpg"));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Timetable window = new Timetable(frame);
				
				frame.setVisible(false);
			}
		});
		button_1.setBounds(10, 91, 55, 55);
		frame.getContentPane().add(button_1);
		//背包
		button_2 = new JButton("");
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setMargin(new Insets(0,0,0,0));
		button_2.setIcon(new ImageIcon("images/beibao.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Bakepack_infor window = new Bakepack_infor(stu,frame);
				frame.setVisible(false);
			}
		});
		button_2.setBounds(116,91,55,55);
		frame.getContentPane().add(button_2);
		//应用中心
		button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		button_3.setMargin(new Insets(0,0,0,0));
		button_3.setIcon(new ImageIcon("images/yingyongzhongxin.jpg"));
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ApplicationCenter_infor window = new ApplicationCenter_infor(frame);
				frame.setVisible(false);
			}
		});
		button_3.setBounds(206, 91, 55, 55);
		frame.getContentPane().add(button_3);
		//news
		btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "可以期待哦宝贝", "oo", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setMargin(new Insets(0,0,0,0));
		btnNewButton.setIcon(new ImageIcon("images/news.jpg"));
		btnNewButton.setBounds(0, 317, 50, 50);
		frame.getContentPane().add(btnNewButton);
		//朋友圈
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "可以期待哦宝贝", "oo", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setMargin(new Insets(0,0,0,0));
		btnNewButton_1.setIcon(new ImageIcon("images/pengyouquan.jpg"));
		btnNewButton_1.setBounds(50, 317, 50, 50);
		frame.getContentPane().add(btnNewButton_1);
		//life
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "可以期待哦宝贝", "oo", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setMargin(new Insets(0,0,0,0));
		btnNewButton_2.setIcon(new ImageIcon("images/life.jpg"));
		btnNewButton_2.setBounds(100, 294, 73, 73);
		frame.getContentPane().add(btnNewButton_2);
		//msge
		btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DealGUI window = new DealGUI(frame);
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setMargin(new Insets(0,0,0,0));
		btnNewButton_3.setIcon(new ImageIcon("images/xingxi.jpg"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(173, 317, 50, 50);
		frame.getContentPane().add(btnNewButton_3);
		//my
		btnNewButton_4 = new JButton("");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "可以期待哦宝贝", "oo", JOptionPane.CANCEL_OPTION);
			}
		});
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setMargin(new Insets(0,0,0,0));
		btnNewButton_4.setIcon(new ImageIcon("images/my.jpg"));
		btnNewButton_4.setBounds(221, 317, 50, 50);
		frame.getContentPane().add(btnNewButton_4);
		
		textField = new JTextField();
		textField.setBackground(Color.BLACK);
		textField.setBounds(0, 80, 274, 1);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(0, 280, 274, 1);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		//退回登录页面
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setMargin(new Insets(0,0,0,0));
		btnNewButton_5.setIcon(new ImageIcon("images/fanhui.png"));
		btnNewButton_5.setBounds(5, 5, 23, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		label = new JLabel("\u8BFE\u7A0B\u8868");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(5, 151, 72, 18);
		frame.getContentPane().add(label);
		
		label_2 = new JLabel("\u80CC\u5305");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(105, 151, 72, 18);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("\u5E94\u7528");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(191, 151, 72, 18);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("\u65B0\u95FB");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(0, 380, 50, 18);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("\u670B\u53CB\u5708");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(40, 380, 72, 18);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("\u751F\u6D3B");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(106, 380, 62, 18);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("\u6D88\u606F");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(176, 380, 52, 18);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("\u4E2A\u4EBA");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(224, 380, 55, 18);
		frame.getContentPane().add(label_8);
	}
}
