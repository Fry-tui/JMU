package com.etc.gui;

import java.awt.EventQueue;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import com.etc.dao.StudentDao;
import com.etc.entity.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindGUI {

	private JFrame frame;
	private JTextField snoText;
	private JTextField codeText;
	private JPasswordField pwdText;
	private JPasswordField npwdText;
	private JFrame loginframe;
	private int rdm;
	private JLabel tipModify;
	private int com = 0;
	private JLabel tipCheck;
	private JTextField stnText;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FindGUI window = new FindGUI();
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
	public FindGUI(JFrame loginframe) {
		this.loginframe = loginframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setVisible(true);
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel snolabel = new JLabel("\u5B66\u53F7");
		snolabel.setBounds(33, 31, 54, 15);
		frame.getContentPane().add(snolabel);
		
		JLabel stnlabel = new JLabel("\u624B\u673A\u53F7");
		stnlabel.setBounds(22, 67, 54, 15);
		frame.getContentPane().add(stnlabel);
		
		snoText = new JTextField();
		snoText.setBounds(86, 28, 115, 21);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		JLabel lblGetCode = new JLabel("get code");
		lblGetCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//get code
				if(snoText.getText().length()==0||stnText.getText().length()!=11){
					JOptionPane.showMessageDialog(null, "�ֻ��Ż�ѧ������", "������", JOptionPane.CANCEL_OPTION);
				}else{
					//else:���������   ���ж��ܲ��ܸ��������ı����õ�ѧ���ҵ������
					StudentDao sdao = new StudentDao();
					Student stu = new Student();
					stu = sdao.findStudentBySno(Integer.parseInt(snoText.getText()));
					if(stu == null){
						JOptionPane.showMessageDialog(null, "�������޴���Ŷ", "ɧ����", JOptionPane.CANCEL_OPTION);
					}else if(stnText.getText().length()==0){
						JOptionPane.showMessageDialog(null, "��д�ֻ��ž���Ҫ��֤�룿", "��", JOptionPane.CANCEL_OPTION);
					}else if(stnText.getText().equals(stu.getStn())){
						Random rd = new Random();
						rdm = (int)(rd.nextDouble()*8999)+1000;
						JOptionPane.showMessageDialog(null, rdm, "��!����߱���", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "��ѧ��Ԥ���ֻ��������벻��", "����ļ���", JOptionPane.CANCEL_OPTION);
					}
				}
			}
		});
		lblGetCode.setForeground(SystemColor.textHighlight);
		lblGetCode.setBounds(210, 67, 54, 15);
		frame.getContentPane().add(lblGetCode);
		
		JLabel codelabel = new JLabel("\u9A8C\u8BC1\u7801");
		codelabel.setBounds(22, 103, 54, 15);
		frame.getContentPane().add(codelabel);
		
		codeText = new JTextField();
		codeText.setColumns(10);
		codeText.setBounds(86, 100, 115, 21);
		frame.getContentPane().add(codeText);
		
		tipModify = new JLabel("");
		tipModify.setForeground(Color.RED);
		tipModify.setBounds(34, 171, 190, 15);
		frame.getContentPane().add(tipModify);
		
		JButton btnSure = new JButton("SURE");
		btnSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				if(rdm!=Integer.parseInt(codeText.getText())){
					JOptionPane.showMessageDialog(null, "�ⶼ�ܴ�", "��֤������", JOptionPane.CANCEL_OPTION);
				}else{
					//��ʾ�޸�����
					tipModify.setText("Ϊ��֤�˻���ȫ ��������������");
					//snameText.setEditable(false);
					snoText.setEditable(false);
					codeText.setEditable(false);
					stnText.setEditable(false);
					//
					com = 119;
				}
			}
		});
		btnSure.setBounds(86, 138, 93, 23);
		frame.getContentPane().add(btnSure);
		
		JLabel pwdlabel = new JLabel("\u65B0\u5BC6\u7801");
		pwdlabel.setBounds(11, 225, 76, 15);
		frame.getContentPane().add(pwdlabel);
		
		JLabel npwdlabel = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		npwdlabel.setBounds(11, 262, 76, 15);
		frame.getContentPane().add(npwdlabel);
		
		pwdText = new JPasswordField();
		pwdText.setBounds(97, 221, 104, 21);
		frame.getContentPane().add(pwdText);
		
		npwdText = new JPasswordField();
		npwdText.setBounds(97, 258, 104, 21);
		frame.getContentPane().add(npwdText);
		
		JButton btnenter = new JButton("ENTER");
		btnenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(com!=119){
					tipCheck.setText("��������ȷ����֤��");
				}else{
					//��ָ���쳣
					Student s1 = new Student();
					s1.setSpwd(pwdText.getText());
					if(npwdText.getText().equals(s1.getSpwd())){
						Student stu = new Student();
						StudentDao sdao = new StudentDao();
						stu.setSpwd(pwdText.getText());
						stu.setSno(Integer.parseInt(snoText.getText()));
						stu.setStn(stnText.getText());
						if(sdao.modifyStudent(stu)){
							JOptionPane.showMessageDialog(null, "�޸ĳɹ�", "boom", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(null, "��÷�ʡһ���Լ�����ΪʲôŪ����", "�޸�ʧ��", JOptionPane.CANCEL_OPTION);
						}
					}else{
						JOptionPane.showMessageDialog(null, "�㻹�����λ���", "ǰ��һ", JOptionPane.CANCEL_OPTION);
					}
				}
			}
		});
		btnenter.setBounds(86, 306, 93, 23);
		frame.getContentPane().add(btnenter);
		
		/*JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginframe.setVisible(true);
				frame.dispose();
			}
		});
		label.setForeground(SystemColor.textHighlight);
		label.setBounds(235, 336, 29, 15);
		frame.getContentPane().add(label);*/
		
		tipCheck = new JLabel("");
		tipCheck.setBounds(65, 196, 123, 15);
		frame.getContentPane().add(tipCheck);
		
		stnText = new JTextField();
		stnText.setBounds(86, 64, 115, 21);
		frame.getContentPane().add(stnText);
		stnText.setColumns(10);
		//
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginframe.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setMargin(new Insets(0,0,0,0));
		btnNewButton.setIcon(new ImageIcon("images/fanhui.png"));
		btnNewButton.setBounds(5, 5, 23, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
