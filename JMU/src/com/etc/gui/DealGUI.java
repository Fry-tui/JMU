package com.etc.gui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import com.etc.dao.LibraryDao;
import java.awt.Color;

public class DealGUI {

	private JFrame frame;
	private JLabel reply;
	private JLabel reply2;
	private JTextField textField;
	private JLabel scorereply;
	private JTextField snoText;
	private JFrame MyGUIframe;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DealGUI window = new DealGUI();
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
	public DealGUI(JFrame MyGUIframe) {
		this.MyGUIframe = MyGUIframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setVisible(true);
		frame.setTitle("\u7F51\u4E0A\u529E\u4E8B\u5927\u5385");
		frame.setBounds(100, 100, 359, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton basic = new JButton("图书馆");
		basic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		basic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LibraryGUI window = new LibraryGUI(frame);// 创建一个新的窗口
				frame.setVisible(false);//把自己隐藏掉
				
			}
		});
		
		basic.setBounds(61, 421, 95, 23);
		frame.getContentPane().add(basic);
		
		JButton button = new JButton("成绩查询");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reply2.setText("请输入学号查询成绩");
			}
		});
		button.setBounds(155, 421, 95, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("关于");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
					JOptionPane.showMessageDialog(null, "版本号:2.3.1","关于软件",JOptionPane.INFORMATION_MESSAGE);
			
			
			        //frame.setVisible(false);
			
			
			
			}
		});
		button_1.setBounds(248, 421, 95, 23);
		frame.getContentPane().add(button_1);
		//键盘图片输入
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setMargin(new Insets(0,0,0,0));
		btnNewButton.setIcon(new ImageIcon("images/shuru.jpg"));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sno ;
				sno = Integer.parseInt(snoText.getText());
				LibraryDao sdao = new LibraryDao();
				
				if(sno==113){
					scorereply.setText("大学英语:75----大学物理:44----体育和健康:65");
				}
				if(sno==115){
					scorereply.setText("大学英语:59----大学物理:47----体育和健康:70");
				}
			}
		});
		btnNewButton.setBounds(0, 421, 64, 23);
		frame.getContentPane().add(btnNewButton);
		
		reply= new JLabel("欢迎登陆网上办事大厅！");
		reply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					
					
				
				/*try {
					System.out.println("欢迎登陆网上办事大厅");
					Thread.sleep(1000);
					System.out.println("");
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				
			}
		});
		reply.setBounds(0, 24, 233, 23);
		frame.getContentPane().add(reply);
		
		reply2 = new JLabel("");
		reply2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		reply2.setBounds(0, 44, 233, 29);
		frame.getContentPane().add(reply2);
		
		snoText = new JTextField();//学号输入框
		snoText.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*int sno ;
				sno = Integer.parseInt(snoText.getText());
				LibraryDao sdao = new LibraryDao();
				
				if(sno==113){
					scorereply.setText("该学生没有成绩");
				}*/
				
				
			}
		});
		snoText.setBounds(0, 387, 343, 21);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		scorereply = new JLabel("");
		scorereply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scorereply.setBounds(0, 78, 343, 37);
		frame.getContentPane().add(scorereply);
		//返回
		JButton button_2 = new JButton("");
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		button_2.setMargin(new Insets(0,0,0,0));
		button_2.setIcon(new ImageIcon("images/fanhui.png"));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);//把自己隐藏掉
				MyGUIframe.setVisible(true);
			}
		});
		button_2.setBounds(5, 0, 23, 23);
		frame.getContentPane().add(button_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setBounds(60, 86, 207, 123);
		frame.getContentPane().add(lblNewLabel);
	}
}
