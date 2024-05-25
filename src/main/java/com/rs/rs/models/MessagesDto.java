package com.rs.rs.models;


//Data Transfer Object DTO
public class MessagesDto {

    private int id;
    private int admin_id;
    private String msg;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAdmin_id() {
        return admin_id;
    }
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public MessagesDto(int id, int admin_id, String msg) {
        this.id = id;
        this.admin_id = admin_id;
        this.msg = msg;
    }
    public MessagesDto() {
        
    }

    
}
