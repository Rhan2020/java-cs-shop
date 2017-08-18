package com.Jie.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.text.SimpleDateFormat;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Pingtiao extends JFrame {

	private JPanel contentPane;

	public Pingtiao(String messages) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.setBounds(121, 172, 99, 38);
		contentPane.add(btnNewButton);
		
		JTextArea txtrAaa = new JTextArea();
		txtrAaa.setText(messages);
		txtrAaa.setBounds(45, 31, 244, 131);
		contentPane.add(txtrAaa);
		
		
		//格式化时间操作
		Date d =new Date();
		SimpleDateFormat d2=new SimpleDateFormat("yyyy MM dd HH mm ss"); 
		JLabel lblNewLabel = new JLabel(d2.format(d));
		lblNewLabel.setBounds(85, 10, 204, 21);
		contentPane.add(lblNewLabel);
	}
}
