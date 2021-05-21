package com.etc.gui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class LibraryGUI {

	private JFrame frame;
	private JFrame dealFrame;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryGUI window = new LibraryGUI(null);
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
	public LibraryGUI(JFrame dealFrame) {
		this.dealFrame = dealFrame;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("\u56FE\u4E66\u9986");
		frame.setVisible(true);
		frame.setBounds(100, 100, 328, 450);
		/*
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		*/
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("我的借书历史");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				BhistoryGUI window = new BhistoryGUI(frame);
			}
		});
		btnNewButton.setBounds(0, 351, 125, 52);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("在借图书");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				NowbGUI window = new NowbGUI(frame);
			}
		});
		btnNewButton_1.setBounds(125, 351, 93, 52);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("续借");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(true);
				BorrowGUI window = new BorrowGUI();
			}
		});
		btnNewButton_2.setBounds(217, 351, 93, 52);
		frame.getContentPane().add(btnNewButton_2);
		//fanhui
		JButton button = new JButton("");
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setMargin(new Insets(0,0,0,0));
		button.setIcon(new ImageIcon("images/fanhui.png"));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dealFrame.setVisible(true);
				frame.dispose();
				
				}

			
		});
		button.setBounds(5, 0, 23, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setMargin(new Insets(0,0,0,0));
		btnNewButton_3.setIcon(new ImageIcon("images/XIAOBIAO.jpg"));
		btnNewButton_3.setBounds(15, 5, 93, 52);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel label = new JLabel("\u8BDA\u6BC5\u5927\u5B66\u56FE\u4E66\u9986\u6B22\u8FCE\u60A8\uFF01");
		label.setFont(new Font("宋体", Font.BOLD, 18));
		label.setBounds(101, 18, 209, 18);
		frame.getContentPane().add(label);
	}
}
