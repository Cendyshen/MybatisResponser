package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

public class CommandDao {
	
	/**
	 * 与指令表对应的数据库操作类
	 */
	public List<Command> queryCommandList(String name, String description) {
		DBAccess dbAccess = new DBAccess();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);
			commandList = sqlSession.selectList("Command.queryCommandList",command);
			//通过sql执行SQL语句
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return commandList;

	}

}
