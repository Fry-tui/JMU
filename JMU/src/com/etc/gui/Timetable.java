package com.etc.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.etc.gui.MyGUI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class Timetable {

	private JFrame frame;
	private JFrame mainFrame;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timetable window = new timetable();
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
	public Timetable(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		initialize();
		frame.setVisible(true);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.getContentPane().setForeground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("查看全部课程");
		button.setFont(new Font("宋体", Font.BOLD, 17));
		button.setForeground(new Color(255, 0, 51));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//课程表表格
				Timetable_infor window = new Timetable_infor(frame);
				frame.setVisible(false);
				
			}
		});
		button.setBounds(41, 116, 156, 78);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("返回主界面");
		button_1.setFont(new Font("宋体", Font.BOLD, 15));
		button_1.setForeground(new Color(255, 0, 51));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mainFrame.setVisible(true);
				
				frame.dispose();
				
			}
		});
		button_1.setBounds(54, 240, 137, 27);
		frame.getContentPane().add(button_1);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u73ED\u7EA7:");
		label.setFont(new Font("宋体", Font.BOLD, 17));
		label.setForeground(new Color(255, 0, 51));
		label.setBounds(11, 13, 110, 32);
		frame.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "\u7269\u80541891", "\u7269\u80541892", "\u7269\u80541893", "\u7269\u80541894", "..."}));
		comboBox.setBounds(36, 49, 168, 24);
		frame.getContentPane().add(comboBox);
	}
}
