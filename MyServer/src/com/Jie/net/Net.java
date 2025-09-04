package com.Jie.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.Jie.Entity.Entity;
import com.Jie.model.Model;

public class Net {

	static Socket socket2;

	public static void main(String[] args) throws Exception {
		// 启动服务器
		Model model = new Model();
		ServerSocket ss = new ServerSocket(8887);
		System.out.println("服务器启动，监听端口8887...");
		// 等待客户端连接
		while (true) {
			Socket socket = null;
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;
			try {
				socket = ss.accept();
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				// 接收格式化数据
				Entity e = (Entity) ois.readObject();
				// 业务处理
				e = model.service(e);
				// 返回数据结果
				oos.writeObject(e);
			} catch (Exception e) {
				System.err.println("处理客户端请求时发生错误: " + e.getMessage());
				e.printStackTrace();
			} finally {
				// 关闭流和连接
				try {
					if (ois != null) ois.close();
					if (oos != null) oos.close();
					if (socket != null) socket.close();
				} catch (Exception e) {
					System.err.println("关闭连接时发生错误: " + e.getMessage());
				}
			}
		}

	}

}
