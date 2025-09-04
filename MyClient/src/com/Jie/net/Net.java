package com.Jie.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.Jie.Entity.Entity;

public class Net {

	public static Entity conn(Entity e) {
		Socket socket = null;
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
			// 连接服务器
			socket = new Socket("127.0.0.1", 8887);
			// 创建数据传输流
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			// 发送数据并接收响应
			oos.writeObject(e);
			e = (Entity) ois.readObject();
			
		} catch (UnknownHostException e1) {
			System.err.println("无法连接到服务器: " + e1.getMessage());
			e1.printStackTrace();
			// 网络连接失败，返回默认失败状态
			Entity errorEntity = new Entity();
			errorEntity.setFlag(0); // 设置为失败状态
			errorEntity.setResult(false);
			return errorEntity;
		} catch (IOException e1) {
			System.err.println("网络通信错误: " + e1.getMessage());
			e1.printStackTrace();
			// 网络通信失败，返回默认失败状态
			Entity errorEntity = new Entity();
			errorEntity.setFlag(0);
			errorEntity.setResult(false);
			return errorEntity;
		} catch (ClassNotFoundException e1) {
			System.err.println("数据格式错误: " + e1.getMessage());
			e1.printStackTrace();
			// 数据格式错误，返回默认失败状态
			Entity errorEntity = new Entity();
			errorEntity.setFlag(0);
			errorEntity.setResult(false);
			return errorEntity;
		} finally {
			// 关闭连接和流
			try {
				if (ois != null) ois.close();
				if (oos != null) oos.close();
				if (socket != null) socket.close();
			} catch (IOException e1) {
				System.err.println("关闭连接时发生错误: " + e1.getMessage());
			}
		}
		return e;
	}
	
}
