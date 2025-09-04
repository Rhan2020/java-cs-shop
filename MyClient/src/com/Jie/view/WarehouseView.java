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

public class WarehouseView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public WarehouseView(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 426);
		
		
		JPanel panel =new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		panel.setVisible(true);
		JLabel label1 = new JLabel("欢迎您！  仓库管理员:"+name);
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(204, 28, 270, 47);
		panel.add(label1);
		
		textField = new JTextField();
		textField.setBounds(123, 130, 402, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("添加商品");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				if (input == null || input.trim().isEmpty()) {
					textField.setText("请输入商品信息！格式：ID,名称,价格,库存");
					return;
				}
				
				String [] mess = input.split(",");  //用字符串分割分隔符
				if (mess.length != 4) {
					textField.setText("格式错误！请按照：ID,名称,价格,库存 格式输入");
					return;
				}
				
				// 验证数据不为空
				for (int i = 0; i < mess.length; i++) {
					if (mess[i] == null || mess[i].trim().isEmpty()) {
						textField.setText("商品信息不能为空！");
						return;
					}
					mess[i] = mess[i].trim(); // 去除空格
				}
				
				Entity e1=new Entity();
				e1.setFlag(5);
				e1.setGoodsid(mess[0]);
				e1.setGoodsname(mess[1]);
				e1.setGoodsprice(mess[2]);
				e1.setGoodscount(mess[3]);
				if(Model.addGoods(e1)){
					textField.setText("添加成功！");
				}else{
					textField.setText("商品已存在！");
				}
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(45, 217, 122, 39);
		panel.add(button);
		
		JButton button_1 = new JButton("删除商品");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String goodsId = textField.getText();
				if (goodsId == null || goodsId.trim().isEmpty()) {
					textField.setText("请输入要删除的商品ID！");
					return;
				}
				
				Entity e1=new Entity();
				e1.setFlag(6);
				e1.setGoodsid(goodsId.trim());
				if(Model.delGoods(e1)){
					textField.setText("删除成功！");
				}else{
					textField.setText("商品不存在！");
				}
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(177, 217, 122, 39);
		panel.add(button_1);
		
		JButton button_2 = new JButton("修改商品");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = textField.getText();
				if (input == null || input.trim().isEmpty()) {
					textField.setText("请输入商品信息！格式：ID,名称,价格,库存");
					return;
				}
				
				String [] mess = input.split(",");  //用字符串分割分隔符
				if (mess.length != 4) {
					textField.setText("格式错误！请按照：ID,名称,价格,库存 格式输入");
					return;
				}
				
				// 验证数据不为空
				for (int i = 0; i < mess.length; i++) {
					if (mess[i] == null || mess[i].trim().isEmpty()) {
						textField.setText("商品信息不能为空！");
						return;
					}
					mess[i] = mess[i].trim(); // 去除空格
				}
				
				Entity e1=new Entity();
				e1.setFlag(7);
				e1.setGoodsid(mess[0]);
				e1.setGoodsname(mess[1]);
				e1.setGoodsprice(mess[2]);
				e1.setGoodscount(mess[3]);
				if(Model.updateGoods(e1)){
					textField.setText("修改成功！");
				}else{
					textField.setText("修改失败！");
				}
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 16));
		button_2.setBounds(309, 217, 122, 39);
		panel.add(button_2);
		
		JButton button_3 = new JButton("查询商品");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String goodsId = textField.getText();
				if (goodsId == null || goodsId.trim().isEmpty()) {
					textField.setText("请输入商品ID！");
					return;
				}
				
				String mess = Model.goodsFindById(goodsId.trim());
				if (mess != null) {
					textField.setText(mess);
				} else {
					textField.setText("商品不存在！");
				}
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 16));
		button_3.setBounds(441, 217, 122, 39);
		panel.add(button_3);
		
	}
}