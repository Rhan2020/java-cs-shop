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
		// 开启服务器
		Model model = new Model();
		ServerSocket ss = new ServerSocket(8887);
		// 等待客户端连接
		while (true) {
			Socket socket = ss.accept();
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			// 接受格式化数据
			Entity e = (Entity) ois.readObject();
			// 处理数据

			e = model.service(e);
			// 返回数据结果
			oos.writeObject(e);
			// 关闭传输流
			ois.close();
			oos.close();
		}

	}

}
