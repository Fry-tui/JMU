package com.etc.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import com.etc.dao.StudentDao;
import com.etc.entity.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.awt.SystemColor;

public class RegisterGUI {

	private JFrame frame;
	private JFrame loginframe;
	private JPasswordField snameText;
	private JTextField snoText;
	private JTextField codeText;
	private JPasswordField snumText;
	private JLabel lblGetCode;
	private JButton sureBtn;
	private JLabel tipNull;
	private JLabel tipNum;
	private JLabel tipCode;
	private int x;
	private JLabel lblNewLabel;
	private JLabel label_4;
	private JPasswordField pwdText;
	private JPasswordField rpwdText;
	private JLabel label_5;
	private JPasswordField birText;
	private JLabel tipDif;
	private JLabel tipBir;
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI window = new RegisterGUI();
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
	public RegisterGUI(JFrame loginframe) {
		this.loginframe = loginframe;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBackground(SystemColor.control);
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setTitle("注册...");
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final StudentDao sdao = new StudentDao();
		
		JLabel label = new JLabel("姓名");
		label.setBounds(59, 46, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("学号");
		label_1.setBounds(59, 13, 54, 15);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("手机号");
		label_2.setBounds(47, 116, 54, 15);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("验证码");
		label_3.setBounds(47, 159, 54, 15);
		frame.getContentPane().add(label_3);
		
		snameText = new JPasswordField();
		snameText.setBounds(103, 46, 101, 21);
		frame.getContentPane().add(snameText);
		
		snoText = new JTextField();
		snoText.setBounds(103, 10, 101, 21);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		codeText = new JTextField();
		codeText.setColumns(10);
		codeText.setBounds(103, 156, 101, 21);
		frame.getContentPane().add(codeText);
		
		snumText = new JPasswordField();
		snumText.setBounds(103, 113, 101, 21);
		frame.getContentPane().add(snumText);
		
		
		
		sureBtn = new JButton("Sure");
		sureBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tipCode.setText("");
				
				int temp = Integer.parseInt(codeText.getText());
				if(temp!=x){
					JOptionPane.showMessageDialog(null, "这都能错？", "验证码有误", JOptionPane.CANCEL_OPTION);
				}else{
					if(pwdText.getText().equals(rpwdText.getText())){
						Student stu = new Student();
						stu.setFlower(3);
						stu.setSname(snameText.getText());
						stu.setSpwd(pwdText.getText());
						stu.setSno(Integer.parseInt(snoText.getText()));
						stu.setStn(snumText.getText());
						SimpleDateFormat stf = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date date = null;
						try {
							date = stf.parse(birText.getText());
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						stu.setBirthday(birText.getText());
						Date now = new Date(System.currentTimeMillis());
						int age = (now.getYear()-date.getYear());
						stu.setSage(age);
						
						sdao.addStudent(stu);
						JOptionPane.showMessageDialog(null, "你也是毅家人了", "恭喜", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, "注册成功，送你三朵小花", "恭喜", JOptionPane.INFORMATION_MESSAGE);
						loginframe.setVisible(true);
						frame.dispose();
					}
				}
			}
		});
		sureBtn.setBounds(103, 314, 93, 23);
		frame.getContentPane().add(sureBtn);
		
		tipNull = new JLabel("");
		tipNull.setForeground(Color.RED);
		tipNull.setBounds(95, 190, 121, 15);
		frame.getContentPane().add(tipNull);
		
		tipNum = new JLabel("");
		tipNum.setForeground(Color.RED);
		tipNum.setBounds(113, 190, 80, 15);
		frame.getContentPane().add(tipNum);
		
		tipCode = new JLabel("");
		tipCode.setForeground(Color.RED);
		tipCode.setBounds(103, 289, 83, 15);
		frame.getContentPane().add(tipCode);
		
		lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setBounds(59, 215, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		label_4 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_4.setBounds(35, 246, 54, 15);
		frame.getContentPane().add(label_4);
		
		pwdText = new JPasswordField();
		pwdText.setBounds(103, 212, 101, 21);
		frame.getContentPane().add(pwdText);
		
		rpwdText = new JPasswordField();
		rpwdText.setBounds(103, 243, 101, 21);
		frame.getContentPane().add(rpwdText);
		
		label_5 = new JLabel("\u751F\u65E5");
		label_5.setBounds(59, 85, 54, 15);
		frame.getContentPane().add(label_5);
		
		birText = new JPasswordField();
		birText.setBounds(103, 82, 101, 21);
		frame.getContentPane().add(birText);
		
		tipDif = new JLabel("");
		tipDif.setForeground(Color.RED);
		tipDif.setBounds(103, 274, 101, 15);
		frame.getContentPane().add(tipDif);
		
		tipBir = new JLabel("");
		tipBir.setForeground(Color.RED);
		tipBir.setBounds(103, 187, 101, 15);
		frame.getContentPane().add(tipBir);
		
		JLabel getCode = new JLabel("get code");
		getCode.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tipNull.setText("");
				tipNum.setText("");
				int z = Integer.parseInt(snoText.getText());
				if(snameText.getText().length() ==0||snoText.getText().length() ==0){
					tipNull.setText("姓名与学号不匹配");
				}else if(snumText.getText().length()!=11){
					tipNum.setText("手机号有误");
				}else if(birText.getText().length()!=10){
					tipBir.setText("生日格式有误");
				}else if(snoText.getText().length() !=0&&sdao.compareSno(z)){
					tipNull.setText("");
					tipNull.setText("学号已存在");
					
				}else{
					snameText.setEditable(false);
					snoText.setEditable(false);
					snumText.setEditable(false);
					birText.setEditable(false);
					Random rd = new Random();
					x = (int)(rd.nextDouble()*8999)+1000;
					JOptionPane.showMessageDialog(null, x, "嘘!别告诉别人", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		getCode.setForeground(SystemColor.textHighlight);
		getCode.setBounds(214, 159, 54, 15);
		frame.getContentPane().add(getCode);
	}
}
