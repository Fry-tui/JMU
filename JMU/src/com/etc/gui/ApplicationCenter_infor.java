package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ApplicationCenter_infor {

	private JFrame frame;
	private JFrame Myframe;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationCenter_infor window = new ApplicationCenter_infor();
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
	public ApplicationCenter_infor(JFrame Myframe) {
		
		this.Myframe = Myframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 645, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("返回上一级");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Myframe.setVisible(true);
				frame.dispose();
			}
		});
		button.setBounds(250, 429, 113, 27);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u65B0\u95FB\u4E2D\u5FC3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(40, 38, 113, 89);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u901A\u77E5\u516C\u544A");
		btnNewButton_1.setBounds(207, 38, 113, 89);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button_1 = new JButton("\u5B98\u65B9\u5FAE\u535A");
		button_1.setBounds(387, 38, 113, 89);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u4EBA\u4E8B");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setBounds(40, 193, 113, 89);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u5B66\u5DE5");
		button_3.setBounds(207, 193, 113, 89);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\u6559\u52A1");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_4.setBounds(387, 193, 113, 89);
		frame.getContentPane().add(button_4);
	}
}
