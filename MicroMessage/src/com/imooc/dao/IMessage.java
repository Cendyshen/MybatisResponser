package com.imooc.dao;

import java.util.List;

import com.imooc.bean.Message;

//与Message对应的接口

public interface IMessage {
	public List<Message> queryMessageList(Message message);
	
}
