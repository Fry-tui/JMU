package com.etc.gui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;//
import javax.swing.table.DefaultTableModel;//

import com.etc.dao.LibraryDao;//
import com.etc.dao.LibraryDao2;
import com.etc.entity.Library;//

import java.awt.event.MouseAdapter;//
import java.awt.event.MouseEvent;//
import java.util.List;
import java.awt.Color;//

public class NowbGUI {

	private JFrame frame;
	private JTable table;
	private JFrame LibraryFrame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NowbGUI window = new NowbGUI();
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
	public NowbGUI(JFrame frame1) {
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
		frame.setTitle("在借图书");
		frame.setBounds(100, 100, 450, 300);
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
		
		JButton btnNewButton_1 = new JButton("还剩还书天数");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LibraryDao2 ldao2 = new LibraryDao2();
				List<Library> list = ldao2.findAllLibrary();
				
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
		btnNewButton_1.setBounds(150, 0, 126, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 75, 359, 95);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.getValueAt(table.getSelectedRow(), 0);
				table.getValueAt(table.getSelectedRow(), 1);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u4E66\u53F7", "\u4E66\u540D", "\u8FD8\u5269\u8FD8\u4E66\u5929\u6570"
			}
		));
		scrollPane.setViewportView(table);
	}
		
	
}
