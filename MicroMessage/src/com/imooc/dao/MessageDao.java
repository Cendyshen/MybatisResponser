package com.imooc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Message;
import com.imooc.db.DBAccess;
/**
 * 
 * search message
 *
 */
public class MessageDao {

//通过mybatis连接的方法
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageList(message);
//			messageList = sqlSession.selectList("Message.queryMessageList",message);
			//通过sql执行SQL语句
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;

	}
	
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();
			//通过sql执行SQL语句
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();
			//通过sql执行SQL语句
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
//	
//	public static void main(String[] args) {
//		MessageDao messageDao = new MessageDao();
//		messageDao.queryMessageList("", "");
//	}
	
//通过数据库直接连接方法
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<Message>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/MicroMessage?serverTimezone=UTC&useSSL=true", "root", "935575731Aa");
//			StringBuilder sql = new StringBuilder(" select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
//			List<String> paramList = new ArrayList<String>();
//	        if(command!=null&&!"".equals(command.trim())){
//	            sql.append(" and COMMAND=? ");
//	            System.out.println("添加command成功，SQL语句"+sql.toString());
//	            paramList.add(command);
//
//	        }
//	        if(description!=null&&!"".equals(description.trim())){
//	            sql.append(" and DESCRIPTION like '%' ? '%' ");
//	            //System.out.println("添加description成功，SQL语句"+sql.toString());
//	            paramList.add(description);
//	        }
//	     
//			PreparedStatement statement = conn.prepareStatement(sql.toString());
//			System.out.print(sql.toString());
//			for(int i=0; i<paramList.size(); i++) {
//				statement.setString(i+1, paramList.get(i));
//			}
//			ResultSet rs = statement.executeQuery();
//			while(rs.next()) {
//				System.out.print(rs);
//				Message message = new Message();
//				messageList.add(message);
//				message.setId(rs.getString("ID"));
//				message.setCommand(rs.getString("COMMAND"));
//				message.setDescription(rs.getString("DESCRIPTION"));
//				message.setContent(rs.getString("CONTENT"));
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return messageList;
//	}
}
