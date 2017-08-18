package com.Jie.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.Jie.Entity.Entity;

public class Net {

	public static Entity conn(Entity e) {
		// TODO Auto-generated method stub
		try {
			//连接服务器
			Socket socket =new Socket("127.0.0.1",8887);
			//创建数据传输流
			ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
			try {
				oos.writeObject(e);
				e=(Entity) ois.readObject();
			} catch (Exception e2) {
				// TODO: handle exception
			}
			
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	
}
