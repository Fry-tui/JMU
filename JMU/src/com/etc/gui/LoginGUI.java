package com.etc.gui;

import java.awt.EventQueue;

import javax.swing.ComboBoxEditor;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import com.etc.dao.AdminDao;
import com.etc.dao.StudentDao;
import com.etc.entity.Student;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI {

	private JFrame frame;
	private JPasswordField pwdText;
	private JTextField snoText;
	private JLabel showInfo;
	private JLabel showDefult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("登入...");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 290, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//选择身份
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(101, 81, 101, 27);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5B66\u751F", "\u6559\u5E08", "\u7BA1\u7406\u5458", "\u8BB8\u7389\u6CC9"}));
		frame.getContentPane().add(comboBox);
		
		
		JLabel label = new JLabel("帐号：");
		label.setBounds(21, 120, 54, 28);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setBounds(21, 172, 70, 15);
		frame.getContentPane().add(label_1);
		
		pwdText = new JPasswordField();
		pwdText.setBounds(101, 169, 101, 21);
		frame.getContentPane().add(pwdText);
		
		JLabel label_2 = new JLabel("登陆身份：");
		label_2.setBounds(10, 87, 81, 15);
		frame.getContentPane().add(label_2);
		
		JButton button = new JButton("登录");
		button.setBounds(51, 221, 171, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				showDefult.setText("");
				showInfo.setText("");
				
				if(comboBox.getSelectedItem().equals("学生")){
					//实例化StudentDao   声明一个变量sdao   使sdao可以使用StudentDao的所有publice方法
					StudentDao sdao = new StudentDao();
					//getText得到是String类型    但是我们的学号是int类型   我们使用Integer.parseInt进行转化
					int sno = Integer.parseInt(snoText.getText());
					//                               传参             
					String rs = sdao.login(sno, pwdText.getText());
					
					if(rs!=null){
						Student stu = new Student();
						stu = sdao.findStudentBySno(sno);
						
						frame.setVisible(false);
						MyGUI window = new MyGUI(stu,frame);
					}else{
						showDefult.setText("");
						showDefult.setText("有你这号人吗");
					}
					
				}else if(comboBox.getSelectedItem().equals("管理员")){
					AdminDao adao = new AdminDao();
					
					int ano = Integer.parseInt(snoText.getText());
					
					String re = adao.login(ano, pwdText.getText());
					if(re != null){
						frame.setVisible(false);
						CtrlGUI window = new CtrlGUI(ano,re,frame);
						
					}else{
						showDefult.setText("");
						showDefult.setText("有你这号人吗");
					}
				}else{
					showInfo.setText("您暂时不配这身份");
				}
			}
		});
		button.setBackground(new Color(255, 153, 51));
		frame.getContentPane().add(button);
		
		JButton registerButton = new JButton("用户注册");
		registerButton.setBounds(10, 254, 93, 23);
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				RegisterGUI window = new RegisterGUI(frame);
			}
		});
		registerButton.setForeground(new Color(51, 153, 255));
		registerButton.setBackground(SystemColor.control);
		frame.getContentPane().add(registerButton);
		
		
		JButton pwdbutton = new JButton("忘记密码");
		pwdbutton.setBounds(171, 254, 93, 23);
		pwdbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FindGUI window = new FindGUI(frame);
				frame.setVisible(false);
			}
		});
		pwdbutton.setForeground(new Color(51, 153, 255));
		pwdbutton.setBackground(SystemColor.control);
		frame.getContentPane().add(pwdbutton);
		
		JLabel label_3 = new JLabel("客服：9094-95961136");
		label_3.setBounds(70, 336, 152, 15);
		label_3.setForeground(new Color(153, 153, 153));
		frame.getContentPane().add(label_3);
		
		snoText = new JTextField();
		snoText.setBounds(101, 125, 101, 21);
		frame.getContentPane().add(snoText);
		snoText.setColumns(10);
		
		JLabel label_4 = new JLabel("集大通");
		label_4.setBounds(101, 10, 87, 46);
		label_4.setFont(new Font("宋体", Font.PLAIN, 21));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(label_4);
		
		showInfo = new JLabel("");
		showInfo.setForeground(Color.RED);
		showInfo.setBounds(83, 196, 115, 15);
		frame.getContentPane().add(showInfo);
		
		showDefult = new JLabel("");
		showDefult.setForeground(Color.RED);
		showDefult.setBounds(83, 196, 115, 15);
		frame.getContentPane().add(showDefult);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);//对按钮透明
		btnNewButton.setBorderPainted(false);//去掉按钮边框
		btnNewButton.setMargin(new Insets(0,0,0,0));//让按钮随按钮上图片变化
		btnNewButton.setIcon(new ImageIcon("images/XIAOBIAO.jpg"));//添加图片
		btnNewButton.setBounds(10, 16, 93, 52);
		frame.getContentPane().add(btnNewButton);
	}
}
