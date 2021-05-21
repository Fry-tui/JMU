package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.etc.dao.AdminDao;
import com.etc.dao.StudentDao;
import com.etc.entity.Admin;
import com.etc.entity.Student;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectStudent {

	private JFrame frame;
	private JTextField snoText;
	private JFrame Admframe;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectStudent window = new SelectStudent();
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
	public SelectStudent(JFrame frame) {
		this.Admframe = frame;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//pic
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 319, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ѡ��ѧ��:");
		label.setBounds(14, 13, 72, 18);
		frame.getContentPane().add(label);
		
		snoText = new JTextField();
		snoText.setBounds(104, 9, 86, 24);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		JLabel label_1 = new JLabel("�Ƿ�ȷ���޸Ĵ�ͬѧȨ��?");
		label_1.setBounds(21, 65, 202, 18);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("���ù���Ա");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//ȷ�����ø�ѧ��Ϊ����Ա
				if(snoText.getText().length()==0) {
					JOptionPane.showMessageDialog(null, "��ѡһ��ͬѧ!", "����!", JOptionPane.CANCEL_OPTION);
				}else {
					
					StudentDao sdao = new StudentDao();
					Student stu = new Student();
					int temp = Integer.parseInt(snoText.getText());
					stu = sdao.findStudentBySno(temp);
					
					AdminDao adao = new AdminDao();
					
					if(adao.compareAno(stu.getSno())) {
						JOptionPane.showMessageDialog(null, "̰��", "�ظ�", JOptionPane.CANCEL_OPTION);
					}else {
						Admin adm = new Admin();
						adm.setAno(stu.getSno());
						adm.setAname(stu.getSname());
						adm.setApwd(stu.getSpwd());
						
						
						if(adao.addAdmin(adm)){

							JOptionPane.showMessageDialog(null, "���л����", "��ϲ", JOptionPane.INFORMATION_MESSAGE);
							
							Admframe.setVisible(true);
							frame.setVisible(false);
						}else {
							JOptionPane.showMessageDialog(null, "��", "��ϲ", JOptionPane.INFORMATION_MESSAGE);
						}			
					}
					
				}
				
			}
		});
		button.setBounds(47, 104, 135, 27);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("�����ù���Ա");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int g=0;
				while(g<5) {
					JOptionPane.showMessageDialog(null, "��˵�����ͳ���???", "�ظ�", JOptionPane.CANCEL_OPTION);
					g--;
				}
				/*Admframe.setVisible(true);
				frame.setVisible(false);*/
				
			}
		});
		btnNewButton.setBounds(47, 142, 132, 27);
		frame.getContentPane().add(btnNewButton);
	}
}
