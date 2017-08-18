package com.Jie.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.Jie.Entity.Entity;
import com.Jie.model.Model;

import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class CashierView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	String [] count1;
	public CashierView(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 426);
		
		
		JPanel panel =new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panel.setVisible(true);
		JLabel label1 = new JLabel("欢迎你！  收银员:"+name);
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(204, 22, 220, 47);
		panel.add(label1);
		
		JTextField textField1 = new JTextField();
		textField1.setBackground(Color.WHITE);
		textField1.setBounds(116, 79, 220, 44);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JButton button1 = new JButton("扫描");//创建扫描商品按钮
		button1.setBackground(Color.WHITE);
		
		//扫描按钮触发的事件
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String goodsid=textField1.getText();
				
				String message =Model.goodsFindById(goodsid);
				if(textField.getText().equals("")){
					textField.setText(message);
					String [] count ={
							message                       //创建数组，保存已扫描的商品信息
					};
					count1=count;
				}
				else if(textField_2.getText().equals("")){
					textField_2.setText(message);
					String [] count ={
							textField.getText(),message
					};
					count1=count;
				}
				else if(textField_3.getText().equals("")){
					textField_3.setText(message);
					String [] count ={
							textField.getText(),textField_2.getText(),message
					};
					count1=count;
				}
				else if(textField_4.getText().equals("")){
					textField_4.setText(message);
					String [] count ={
							textField.getText(),textField_2.getText(),textField_3.getText(),message
					};
					count1=count;
				}
				else if(textField_5.getText().equals("")){
					textField_5.setText(message);
					String [] count ={
							textField.getText(),textField_2.getText(),textField_3.getText(),textField_4.getText(),message
					};
					count1=count;
				}
				else{
					textField1.setText("购物车已满！");
				}
			}
			
		});
		button1.setFont(new Font("宋体", Font.PLAIN, 16));
		button1.setBounds(409, 77, 150, 44);
		panel.add(button1);
		
		JButton button = new JButton("打印凭条");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.getText();
				textField_2.getText();
				textField_3.getText();
				textField_4.getText();
				textField_5.getText();
				textField_10.getText();
				textField_11.getText();
				textField_12.getText();
				textField_13.getText();
				textField_14.getText();
				String me="    商品           "+"   数量        \n"+
						count1[0]+"  "+textField_10.getText()+"\n"+
						count1[1]+"  "+textField_11.getText()+"\n"+
						count1[2]+"  "+textField_12.getText()+"\n"+
						count1[3]+"  "+textField_13.getText()+"\n"+
						count1[4]+"  "+textField_14.getText()+"\n"+
				"总计："+"14元";
				Pingtiao p =new Pingtiao(me);
				p.setVisible(true);
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
			}

		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBackground(Color.WHITE);
		button.setBounds(409, 185, 150, 44);
		panel.add(button);
		
		JButton button_1 = new JButton("找零");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zhaoling z =new Zhaoling();
				z.setVisible(true);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(409, 278, 150, 44);
		panel.add(button_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("宋体", Font.BOLD, 18));
		//打印凭条、添加
		
		textField.setBounds(35, 156, 226, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("宋体", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(35, 202, 226, 27);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("宋体", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(35, 249, 226, 27);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setFont(new Font("宋体", Font.BOLD, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(35, 295, 226, 27);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setFont(new Font("宋体", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(35, 339, 226, 27);
		panel.add(textField_5);
		
		textField_10 = new JTextField();
		textField_10.setBounds(322, 161, 34, 21);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(322, 207, 34, 21);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(322, 254, 34, 21);
		panel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(322, 301, 34, 21);
		panel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(322, 344, 34, 21);
		panel.add(textField_14);
		
		JLabel label = new JLabel("\u6570\u91CF\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(271, 163, 48, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u6570\u91CF\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(271, 209, 48, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u6570\u91CF\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(271, 256, 48, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("\u6570\u91CF\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(271, 302, 48, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("\u6570\u91CF\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(271, 346, 48, 15);
		panel.add(label_4);
		
		JLabel lblid = new JLabel("\u5546\u54C1ID");
		lblid.setFont(new Font("宋体", Font.PLAIN, 16));
		lblid.setBounds(35, 93, 61, 15);
		panel.add(lblid);
		
	}
}
