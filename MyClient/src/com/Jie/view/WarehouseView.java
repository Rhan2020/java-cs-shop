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
		JLabel label1 = new JLabel("欢迎你！  仓库管理员:"+name);
		label1.setFont(new Font("宋体", Font.PLAIN, 18));
		label1.setBounds(204, 28, 270, 47);
		panel.add(label1);
		
		textField = new JTextField();
		textField.setBounds(123, 130, 402, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u589E\u52A0\u5546\u54C1");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] mess=textField.getText().split(",");  //对字符串进行分割
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
		
		JButton button_1 = new JButton("\u5220\u9664\u5546\u54C1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Entity e1=new Entity();
				e1.setFlag(6);
				e1.setGoodsid(textField.getText());
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
		
		JButton button_2 = new JButton("\u4FEE\u6539\u5546\u54C1");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] mess=textField.getText().split(",");  //对字符串进行分割
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
		
		JButton button_3 = new JButton("\u67E5\u8BE2\u5546\u54C1");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entity e1=new Entity();
				e1.setFlag(8);
				e1.setGoodsid(textField.getText());
				String mess="";
				mess=Model.goodsFindById(e1.getGoodsid());
					textField.setText(mess);
			}
		});
		button_3.setFont(new Font("宋体", Font.PLAIN, 16));
		button_3.setBounds(441, 217, 122, 39);
		panel.add(button_3);
		
	}
}
