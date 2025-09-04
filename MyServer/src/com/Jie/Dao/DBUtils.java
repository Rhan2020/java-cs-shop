package com.Jie.Dao;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.ResourceBundle;
/**
 * Created by Jie on 2016/01/15.
 */
public class DBUtils {
    //���ݿ����ӵ�ַ
    public static String URL;
    //�û���
    public static String USERNAME;
    //����
    public static String PASSWORD;
    //mysql��������
    public static String DRIVER;
    private DBUtils(){
    	
    }
    //使用静态块初始化数据库配置
    static{
        loadConfig();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 加载配置文件
     */
    private static void loadConfig() {
        Properties props = new Properties();
        InputStream input = null;
        try {
            // 从类路径加载配置文件
            input = DBUtils.class.getClassLoader().getResourceAsStream("config.properties");
            if (input != null) {
                props.load(input);
                URL = props.getProperty("db.url", "jdbc:mysql://localhost:3306/shop");
                USERNAME = props.getProperty("db.username", "root");
                PASSWORD = props.getProperty("db.password", "root");
                DRIVER = props.getProperty("db.driver", "com.mysql.jdbc.Driver");
            } else {
                // 如果配置文件不存在，使用默认值
                URL = "jdbc:mysql://localhost:3306/shop";
                USERNAME = "root";
                PASSWORD = "root";
                DRIVER = "com.mysql.jdbc.Driver";
                System.out.println("配置文件未找到，使用默认数据库配置");
            }
        } catch (IOException e) {
            // 加载失败时使用默认配置
            URL = "jdbc:mysql://localhost:3306/shop";
            USERNAME = "root";
            PASSWORD = "root";
            DRIVER = "com.mysql.jdbc.Driver";
            System.err.println("加载配置文件失败，使用默认数据库配置: " + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //����һ����ȡ���ݿ����ӵķ���
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            // 设置连接超时时间
            if (conn != null) {
                conn.setAutoCommit(true);
                // 测试连接有效性
                if (!conn.isValid(3)) {
                    conn.close();
                    conn = null;
                    System.err.println("数据库连接无效");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("获取数据库连接失败: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
                conn = null;
            }
        }
        finally {
            return conn;
        }
    }
    /**
     * �ر����ݿ�����
     */
    public static void close(ResultSet rs,Statement stat,Connection conn){
        try {
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
