package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.text.JTextComponent;

import com.etc.dao.LibraryDao;
import com.etc.dao.LibraryDao2;
import com.etc.entity.Library;
import com.etc.entity.Library2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BorrowGUI {

	protected static final int bno = 121;
	private JFrame frame;
	private JTextField newDays;
	private JFrame LibraryFrame;
	private JTextField bnoText;
	protected JTextComponent Days;
	protected JTextComponent days;
	private JLabel bookday;
	private Library2 lib;
	private LibraryDao2 lib2;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowGUI window = new BorrowGUI();
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
	public BorrowGUI() {
		this.LibraryFrame=LibraryFrame;
		initialize();
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("续借");
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		newDays = new JTextField();
		newDays.setBounds(129, 101, 99, 24);
		frame.getContentPane().add(newDays);
		newDays.setColumns(10);
		
		JLabel label = new JLabel("续借天数:");
		label.setBounds(26, 95, 99, 35);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("\u7EED\u501F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//通过lib.setDays函数，进行设置新的续借天数，新天数=查询到的天数+文本输入框获得的天数
				int x = Integer.parseInt(newDays.getText());
				int z = lib.getDays()+x;
				
				lib.setDays(z);
				if(lib2.modifyLibrary2(lib)){
					JOptionPane.showMessageDialog(null, "续借成功", "恭喜", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "你该反省一下自己的原因", "失败", JOptionPane.INFORMATION_MESSAGE);
				}
				frame.dispose();
			}
		});
		button.setBounds(26, 171, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("退出");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(183, 171, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("还书还剩天数:");
		lblNewLabel.setBounds(16, 50, 103, 35);
		frame.getContentPane().add(lblNewLabel);
		
		bookday = new JLabel("");//从nowbGUI中获取还剩天数
		bookday.setBounds(121, 60, 107, 25);
		frame.getContentPane().add(bookday);
		
		bnoText = new JTextField();//获得书名
		bnoText.setBounds(129, 19, 99, 24);
		frame.getContentPane().add(bnoText);
		bnoText.setColumns(10);
		
		JButton btnNewButton = new JButton("查询天数");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override//获得天数//bnoText
			public void mouseClicked(MouseEvent e) {
				//实例化....dao类 ,使lib2可以调出dao里的public方法
				lib2 = new LibraryDao2();
				//实例化图书类--》lib用于承接lib2.findLibraryByBno(int sno1)的返回值;
				lib = new Library2();
				//把获得文本框的string类型转化成int类型--->传参
				int sno1 = Integer.parseInt(bnoText.getText());
				//lib承接了lib2.findLibraryByBno(int sno1)的返回值
				lib = lib2.findLibraryByBno(sno1);
				
				if(lib == null){
					bookday.setText("没有这本书");
				}else{
					//使lable文本框的文本为lib中的天数
					bookday.setText(lib.getDays()+"");
					
				}
				
				
			}
		});
		btnNewButton.setBounds(283, 18, 120, 24);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("书号:");
		lblNewLabel_2.setBounds(26, 17, 93, 23);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
