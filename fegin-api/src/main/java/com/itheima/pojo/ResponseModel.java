package com.itheima.pojo;

import lombok.Data;

@Data
public class ResponseModel {
    private String msg;
    private Object data;
    private String code;
    public static ResponseModel ok(Object data,String msg){
        ResponseModel ret = new ResponseModel();
        ret.setCode("000000");
        ret.setData(data);
        ret.setMsg(msg);
        return ret;
    }


    public static ResponseModel error(Object data,String msg){
        ResponseModel ret = new ResponseModel();
        ret.setCode("111111");
        ret.setData(data);
        ret.setMsg(msg);
        return ret;
    }
}
