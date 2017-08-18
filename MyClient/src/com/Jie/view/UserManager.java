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
		JLabel label1 = new JLabel("欢迎你！  超级管理员:"+name);
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(204, 28, 270, 47);
		panel.add(label1);
		
		textField = new JTextField();
		textField.setBounds(123, 130, 402, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u589E\u52A0\u5458\u5DE5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] mess=textField.getText().split(",");  //对字符串进行分割
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
		
		JButton button_1 = new JButton("\u5220\u9664\u5458\u5DE5");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=textField.getText();
				if(Model.delUser(username)){
					textField.setText("删除成功！");
				}else{
					textField.setText("用户已存在！");
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(177, 217, 122, 39);
		panel.add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] mess=textField.getText().split(",");  //对字符串进行分割
				Entity e1=new Entity();
				e1.setFlag(7);
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
		
		JButton button_3 = new JButton("\u67E5\u8BE2\u5458\u5DE5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=textField.getText();
				String mess="";
				mess=Model.findUser(username);
				textField.setText(mess);
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 16));
		button_3.setBounds(441, 217, 122, 39);
		panel.add(button_3);
		
		//反馈操作信息
		String message ="";
		JLabel lblNewLabel = new JLabel(message);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(229, 303, 202, 24);
		panel.add(lblNewLabel);
	}
}
