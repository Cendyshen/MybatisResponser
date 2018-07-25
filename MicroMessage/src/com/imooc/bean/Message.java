package com.imooc.bean;

/**
 * 
 * 消息对应的实体类
 *
 */
public class Message {
	/**
	 * 主键
	 */
    private String id;
	/**
	 * 指令名称
	 */
	private String command;
	/**
	 * 主键
	 */
	private String description;
	/**
	 * 主键
	 */
	private String content;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
