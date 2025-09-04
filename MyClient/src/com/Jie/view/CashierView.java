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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.Jie.Entity.Entity;
import com.Jie.model.Model;
import com.Jie.utils.PriceCalculator;

import javax.swing.JTree;

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
		JLabel label1 = new JLabel("欢迎您！  收银员:"+name);
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(204, 22, 220, 47);
		panel.add(label1);
		
		JTextField textField1 = new JTextField();
		textField1.setBackground(Color.WHITE);
		textField1.setBounds(116, 79, 220, 44);
		panel.add(textField1);
		textField1.setColumns(10);
		
		JButton button1 = new JButton("扫描");//扫描商品按钮
		button1.setBackground(Color.WHITE);
		
		//扫描按钮点击事件
		button1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String goodsid=textField1.getText();
				
				String message =Model.goodsFindById(goodsid);
				
				// 检查商品是否找到
				if (message == null) {
					// 商品不存在，显示错误信息
					javax.swing.JOptionPane.showMessageDialog(null, "商品不存在，请检查商品ID！", "错误", javax.swing.JOptionPane.ERROR_MESSAGE);
					textField1.setText(""); // 清空输入框
					return;
				}
				
				if(textField.getText().equals("")){
					textField.setText(message);
					String [] count ={
							message                       //商品数组，存储扫描到的商品信息
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
					textField1.setText("购物车已满");
				}
			}
			
		});
		button1.setFont(new Font("宋体", Font.PLAIN, 16));
		button1.setBounds(409, 77, 150, 44);
		panel.add(button1);
		
		JButton button = new JButton("打印凭条");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 检查是否有商品
				if (count1 == null || count1.length == 0) {
					javax.swing.JOptionPane.showMessageDialog(null, "请先扫描商品！", "提示", javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// 检查是否有有效的商品和数量
				boolean hasValidItem = false;
				String[] quantities = {
					textField_10.getText(),
					textField_11.getText(),
					textField_12.getText(),
					textField_13.getText(),
					textField_14.getText()
				};
				
				for (int i = 0; i < count1.length && i < quantities.length; i++) {
					if (count1[i] != null && !count1[i].trim().isEmpty() && 
						quantities[i] != null && !quantities[i].trim().isEmpty()) {
						try {
							int qty = Integer.parseInt(quantities[i].trim());
							if (qty > 0) {
								hasValidItem = true;
								break;
							}
						} catch (NumberFormatException ex) {
							// 忽略无效数量
						}
					}
				}
				
				if (!hasValidItem) {
					javax.swing.JOptionPane.showMessageDialog(null, "请输入有效的商品数量！", "提示", javax.swing.JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				// 验证库存充足性
				String stockValidation = PriceCalculator.validateStock(count1, quantities);
				if (stockValidation != null) {
					javax.swing.JOptionPane.showMessageDialog(null, stockValidation, "库存不足", javax.swing.JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// 计算总价
				double totalPrice = 0.0;
				try {
					totalPrice = PriceCalculator.calculateTotal(count1, quantities);
				} catch (IllegalArgumentException ex) {
					javax.swing.JOptionPane.showMessageDialog(null, ex.getMessage(), "库存不足", javax.swing.JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				String me="    商品           "+"   数量        \n"+
						(count1 != null && count1.length > 0 && count1[0] != null ? count1[0]+"  "+textField_10.getText()+"\n" : "")+
						(count1 != null && count1.length > 1 && count1[1] != null ? count1[1]+"  "+textField_11.getText()+"\n" : "")+
						(count1 != null && count1.length > 2 && count1[2] != null ? count1[2]+"  "+textField_12.getText()+"\n" : "")+
						(count1 != null && count1.length > 3 && count1[3] != null ? count1[3]+"  "+textField_13.getText()+"\n" : "")+
						(count1 != null && count1.length > 4 && count1[4] != null ? count1[4]+"  "+textField_14.getText()+"\n" : "")+
				"总计："+PriceCalculator.formatPrice(totalPrice);
				Pingtiao p =new Pingtiao(me);
				p.setVisible(true);
				// 清空商品列表和数量输入
				textField.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				textField_13.setText("");
				textField_14.setText("");
				count1 = null; // 清空商品数组
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
		//打印凭条商品信息
		
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
		
		JLabel label = new JLabel("数量：");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(271, 163, 48, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("数量：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(271, 209, 48, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("数量：");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(271, 256, 48, 15);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("数量：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(271, 302, 48, 15);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("数量：");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(271, 346, 48, 15);
		panel.add(label_4);
		
		JLabel lblid = new JLabel("商品ID");
		lblid.setFont(new Font("宋体", Font.PLAIN, 16));
		lblid.setBounds(35, 93, 61, 15);
		panel.add(lblid);
		
	}
}