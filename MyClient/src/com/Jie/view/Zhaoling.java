package com.Jie.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Zhaoling extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public Zhaoling() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 251, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u627E\u96F6");
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		label.setBounds(90, 20, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5E94\u6536\uFF1A");
		label_1.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		label_1.setBounds(35, 57, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5B9E\u6536\uFF1A");
		label_2.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		label_2.setBounds(35, 89, 54, 15);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(89, 55, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(90, 87, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(90, 149, 66, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u627E\u96F6");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int k = 0;
				k=Integer.valueOf(textField_1.getText())-Integer.valueOf(textField.getText());
				String s=k+"";
				textField_2.setText(s);
			}
		});
		btnNewButton_1.setBounds(10, 114, 66, 28);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 118, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
	}

}
