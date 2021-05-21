package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Timetable_infor {

	private JFrame frame;
	private JTable table;
	private JFrame timetable;
	private JButton button;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timetable_infor window = new timetable_infor();
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
	public Timetable_infor(JFrame timetable) {
		this.timetable = timetable;
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.getContentPane().setForeground(new Color(255, 102, 153));
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-1, 75, 279, 208);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"\u5468\u4E00", "\u5468\u4E8C", "\u5468\u4E09", "\u5468\u56DB", "\u5468\u4E94"
			}
		));
		scrollPane.setViewportView(table);
		
		button = new JButton("返回上一级");
		button.setFont(new Font("宋体", Font.BOLD, 15));
		button.setForeground(new Color(255, 51, 102));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				timetable.setVisible(true);
				
				frame.dispose();
				
			}
		});
		button.setBounds(84, 320, 131, 27);
		frame.getContentPane().add(button);
		
		label = new JLabel("\u672C\u5B66\u671F\u5DF2\u7ED3\u8BFE,\u8BF7\u4E0B\u5B66\u671F\u67E5\u770B!");
		label.setForeground(new Color(255, 102, 153));
		label.setFont(new Font("微软雅黑 Light", Font.BOLD, 18));
		label.setBounds(5, 17, 332, 51);
		frame.getContentPane().add(label);
	}

}
