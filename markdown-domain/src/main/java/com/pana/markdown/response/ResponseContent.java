package com.pana.markdown.response;

import java.io.Serializable;

/**
 * @author chenyang
 * @email chenyang@cheyipai.com
 * @date 2017/5/12 17:36
 */
public class ResponseContent<T> implements Serializable {
    private static final long serialVersionUID = 7210037741374526146L;
    private String code;
    private String msg;
    private T data;
    public ResponseContent(String code,String msg){
        this(code,msg,null);
    }
    public ResponseContent(String code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
//

    /**
     * 创建不带业务数据，不带跨域的返回类型
     * @param responseEnum
     * @return
     */
    public final static <T> ResponseContent<T> createResult(ResponseEnum responseEnum){
        return createResult(responseEnum,null);
    }
    /**
     * 创建带业务数据和跨域的放回类型
     * @param responseEnum
     * @param data 任意类型的业务数据
     * @return
     */
    public final static <T> ResponseContent<T> createResult(ResponseEnum responseEnum,T data){
        ResponseContent<T> result = new ResponseContent<T>(responseEnum.getCode(), responseEnum.getMsg(), data);
//		if(ResponseEnum.success_code.equals(responseEnum.getCode())){
//			result.setSuccess(true);
//		}
        return result;
    }

    /**
     * 创建带业务数据和跨域的放回类型
     * @param code
     * @param msg
     * @param data 任意类型的业务数据
     * @param <T>
     * @return
     */
    public final static <T> ResponseContent<T> createResult(String code,String msg,T data){
        ResponseContent<T> result = new ResponseContent<T>(code, msg, data);
        return result;
    }
}