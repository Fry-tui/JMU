package com.etc.gui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.etc.dao.LibraryDao;
import com.etc.entity.Library;
import java.awt.Color;

public class BhistoryGUI {

	private JFrame frame;
	private JFrame LibraryFrame;
	private JTable table;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BhistoryGUI window = new BhistoryGUI();
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
	public BhistoryGUI(JFrame frame1) {
		this.LibraryFrame = frame1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setVisible(true);
		frame.setBounds(100, 100, 290, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//fanhui
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setMargin(new Insets(0,0,0,0));
		btnNewButton.setIcon(new ImageIcon("images/fanhui.png"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LibraryFrame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(5, 0, 23, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B\u501F\u4E66\u5386\u53F2");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LibraryDao ldao = new LibraryDao();
				List<Library> list = ldao.findAllLibrary();
				
				Object[][] obj = new Object[list.size()][3];
				for(int i=0;i<list.size();i++){
					obj[i][0]=list.get(i).getBno();
					obj[i][1]=list.get(i).getBname();
					obj[i][2]=list.get(i).getData();
					
				}
				
				DefaultTableModel model = new DefaultTableModel(obj,
							new String[] {"书号","书名", "还剩还书天数"});

				table.setModel(model);
			}
		});
		btnNewButton_1.setBounds(56, 25, 135, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 86, 272, 172);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u65E5\u671F"
			}
		));
		scrollPane.setViewportView(table);
	}
}
