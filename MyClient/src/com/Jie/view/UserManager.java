package com.Jie.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Jie.Entity.Entity;
import com.Jie.model.Model;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public UserManager(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 426);
		
		
		JPanel panel =new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panel.setVisible(true);
		JLabel label1 = new JLabel("欢迎您！  系统管理员:"+name);
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(204, 28, 270, 47);
		panel.add(label1);
		
		textField = new JTextField();
		textField.setBounds(123, 130, 402, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("添加员工");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				if (input == null || input.trim().isEmpty()) {
					textField.setText("请输入用户信息！格式：用户名,密码,角色(1-收银员/2-仓库管理员/3-系统管理员)");
					return;
				}
				
				String [] mess = input.split(",");  //用字符串分割分隔符
				if (mess.length != 3) {
					textField.setText("格式错误！请按照：用户名,密码,角色 格式输入");
					return;
				}
				
				// 验证数据不为空
				for (int i = 0; i < mess.length; i++) {
					if (mess[i] == null || mess[i].trim().isEmpty()) {
						textField.setText("用户信息不能为空！");
						return;
					}
					mess[i] = mess[i].trim(); // 去除空格
				}
				
				// 验证角色有效性
				try {
					int role = Integer.valueOf(mess[2]);
					if (role < 1 || role > 3) {
						textField.setText("角色值错误！请输入1-3之间的数字");
						return;
					}
				} catch (NumberFormatException ex) {
					textField.setText("角色必须是数字！");
					return;
				}
				
				Entity e1=new Entity();
				e1.setFlag(10);
				e1.setUsername(mess[0]);
				e1.setPassword(mess[1]);
				e1.setRole(Integer.valueOf(mess[2]));
				if(Model.addUser(e1)){
					textField.setText("添加成功！");
				}else{
					textField.setText("用户已存在！");
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(45, 217, 122, 39);
		panel.add(button);
		
		JButton button_1 = new JButton("删除员工");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				if (username == null || username.trim().isEmpty()) {
					textField.setText("请输入要删除的用户名！");
					return;
				}
				
				if(Model.delUser(username.trim())){
					textField.setText("删除成功！");
				}else{
					textField.setText("用户不存在！");
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(177, 217, 122, 39);
		panel.add(button_1);
		
		JButton button_2 = new JButton("修改信息");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				if (input == null || input.trim().isEmpty()) {
					textField.setText("请输入用户信息！格式：用户名,密码,角色(1-收银员/2-仓库管理员/3-系统管理员)");
					return;
				}
				
				String [] mess = input.split(",");  //用字符串分割分隔符
				if (mess.length != 3) {
					textField.setText("格式错误！请按照：用户名,密码,角色 格式输入");
					return;
				}
				
				// 验证数据不为空
				for (int i = 0; i < mess.length; i++) {
					if (mess[i] == null || mess[i].trim().isEmpty()) {
						textField.setText("用户信息不能为空！");
						return;
					}
					mess[i] = mess[i].trim(); // 去除空格
				}
				
				// 验证角色有效性
				try {
					int role = Integer.valueOf(mess[2]);
					if (role < 1 || role > 3) {
						textField.setText("角色值错误！请输入1-3之间的数字");
						return;
					}
				} catch (NumberFormatException ex) {
					textField.setText("角色必须是数字！");
					return;
				}
				
				Entity e1=new Entity();
				e1.setFlag(12); // 修正flag值，12表示修改用户信息
				e1.setUsername(mess[0]);
				e1.setPassword(mess[1]);
				e1.setRole(Integer.valueOf(mess[2]));
				if(Model.updateUser(e1)){
					textField.setText("修改成功！");
				}else{
					textField.setText("修改失败！");
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 16));
		button_2.setBounds(309, 217, 122, 39);
		panel.add(button_2);
		
		JButton button_3 = new JButton("查询员工");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				if (username == null || username.trim().isEmpty()) {
					textField.setText("请输入要查询的用户名！");
					return;
				}
				
				String mess = Model.findUser(username.trim());
				if (mess != null && !mess.trim().isEmpty() && !mess.contains("null")) {
					textField.setText(mess);
				} else {
					textField.setText("用户不存在！");
				}
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 16));
		button_3.setBounds(441, 217, 122, 39);
		panel.add(button_3);
		
		//显示操作信息
		String message ="";
		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(229, 303, 202, 24);
		panel.add(lblNewLabel);
	}
}