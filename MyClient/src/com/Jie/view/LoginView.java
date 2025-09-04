package com.Jie.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Jie.model.Model;

import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public LoginView() {
		
		/*
		 * Swing 页面布局生成部分 
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 426);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("欢迎进入超市管理系统");
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(212, 10, 180, 47);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(159, 126, 78, 32);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(170, 188, 54, 26);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(228, 128, 194, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 185, 194, 29);
		contentPane.add(passwordField);
		
		JButton button = new JButton("登录");//登录按钮
		button.addActionListener(new ActionListener() {
			/*
			 * 登录逻辑
			 * 点击登录按钮执行登录逻辑
			 */
			public void actionPerformed(ActionEvent arg0) {
				String username=textField.getText();
				@SuppressWarnings("deprecation")
				String password=passwordField.getText();
				boolean able=!username.equals("");
				if (able) {
					
					int flag=0;
					flag=Model.doLogin(username, password);
					if(flag==1){
						dispose();//关闭原窗口
						/*
						 * 收银员页面
						 */
						CashierView ts=new CashierView(username);
						ts.setVisible(true);
					}
					if(flag==2){
						dispose();//关闭原窗口
						/*
						 * 仓库管理员页面
						 */
						WarehouseView wv=new WarehouseView(username);
						wv.setVisible(true);
						
					}
					if(flag==3){
						/*
						 * 系统管理员页面
						 */
						dispose();//关闭原窗口
						UserManager um =new UserManager(username);
						um.setVisible(true);
					}
					if(flag==0||flag==9){
						/*
						 * 显示错误提示页面
						 */
						
						dispose();//关闭原窗口
						LoginFailureView lfv =new LoginFailureView();
						lfv.setVisible(true);
					}
				}else{
					/*
					 * 显示用户名或密码错误
					 */
					dispose();//关闭原窗口
					ReloginView rl =new ReloginView();
					rl.setVisible(true);
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(241, 261, 150, 44);
		contentPane.add(button);
	}
}