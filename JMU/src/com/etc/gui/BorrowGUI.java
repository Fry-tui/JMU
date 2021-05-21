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
		frame.setTitle("����");
		frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		newDays = new JTextField();
		newDays.setBounds(129, 101, 99, 24);
		frame.getContentPane().add(newDays);
		newDays.setColumns(10);
		
		JLabel label = new JLabel("��������:");
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
				//ͨ��lib.setDays���������������µ�����������������=��ѯ��������+�ı�������õ�����
				int x = Integer.parseInt(newDays.getText());
				int z = lib.getDays()+x;
				
				lib.setDays(z);
				if(lib2.modifyLibrary2(lib)){
					JOptionPane.showMessageDialog(null, "����ɹ�", "��ϲ", JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null, "��÷�ʡһ���Լ���ԭ��", "ʧ��", JOptionPane.INFORMATION_MESSAGE);
				}
				frame.dispose();
			}
		});
		button.setBounds(26, 171, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("�˳�");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		button_1.setBounds(183, 171, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("���黹ʣ����:");
		lblNewLabel.setBounds(16, 50, 103, 35);
		frame.getContentPane().add(lblNewLabel);
		
		bookday = new JLabel("");//��nowbGUI�л�ȡ��ʣ����
		bookday.setBounds(121, 60, 107, 25);
		frame.getContentPane().add(bookday);
		
		bnoText = new JTextField();//�������
		bnoText.setBounds(129, 19, 99, 24);
		frame.getContentPane().add(bnoText);
		bnoText.setColumns(10);
		
		JButton btnNewButton = new JButton("��ѯ����");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override//�������//bnoText
			public void mouseClicked(MouseEvent e) {
				//ʵ����....dao�� ,ʹlib2���Ե���dao���public����
				lib2 = new LibraryDao2();
				//ʵ����ͼ����--��lib���ڳн�lib2.findLibraryByBno(int sno1)�ķ���ֵ;
				lib = new Library2();
				//�ѻ���ı����string����ת����int����--->����
				int sno1 = Integer.parseInt(bnoText.getText());
				//lib�н���lib2.findLibraryByBno(int sno1)�ķ���ֵ
				lib = lib2.findLibraryByBno(sno1);
				
				if(lib == null){
					bookday.setText("û���Ȿ��");
				}else{
					//ʹlable�ı�����ı�Ϊlib�е�����
					bookday.setText(lib.getDays()+"");
					
				}
				
				
			}
		});
		btnNewButton.setBounds(283, 18, 120, 24);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("���:");
		lblNewLabel_2.setBounds(26, 17, 93, 23);
		frame.getContentPane().add(lblNewLabel_2);
	}

}
