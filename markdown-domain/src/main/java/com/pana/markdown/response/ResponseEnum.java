package com.pana.markdown.response;

/**
 * @author chenyang
 * @email chenyang@cheyipai.com
 * @date 2017/5/12 17:36
 */
public interface ResponseEnum {
    //sys code
    public static final String success_code = "0";
    public static final String system_error_code = "500";
    public static final String data_error_code = "400";

    public static final ResponseEnum SUCCESS = new ResponseEnum() {
        public String getMsg() {
            return "SUCCESS";
        }
        public String getCode() {
            return success_code;
        }
    };
    public static final ResponseEnum SYSTEM_ERROR = new ResponseEnum() {
        public String getMsg() {
            return "SYSTEM_ERROR";
        }
        public String getCode() {
            return system_error_code;
        }
    };
    public static final ResponseEnum DATAERROR = new ResponseEnum() {
        public String getMsg() {
            return "DATA ERROR";
        }
        public String getCode() {
            return data_error_code;
        }
    };
    public String getCode();
    public String getMsg();
}