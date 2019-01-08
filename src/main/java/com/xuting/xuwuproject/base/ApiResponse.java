package com.xuting.xuwuproject.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 响应统一api
 * @Author xuting
 * @Date 2019/1/7
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

    private int code;//状态码

    private String message;//描述信息

    private Object data;//响应内容

    private boolean more;//是否有更多

    public ApiResponse(int code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;

    }
    //静态方法
    public  static ApiResponse ofMessage(int code,String message) {
        return new ApiResponse(code,message,null);
    }

    public static ApiResponse ofSuccess(Object data){
        return new ApiResponse(Status.SUCCESS.getCode(), Status.SUCCESS.standardMessage,data);
    }

    public static ApiResponse ofStatus(Status status) {
        return new ApiResponse(status.SUCCESS.getCode(),status.getStandardMessage(),null);
    }

    //内部枚举
   public enum Status{
        SUCCESS(200,"OK"),
        BAD_REQUEST(400,"Bad Request"),
        NOT_FIND(404,"NOT Find"),
        INTERNAL_SERVER_ERROR(500,"Unknown Internal Error")
        ;
        private int code;
        private String standardMessage;
        Status(int code,String standardMessage){
            this.code = code;
            this.standardMessage = standardMessage;
        }
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getStandardMessage() {
            return standardMessage;
        }

        public void setStandardMessage(String standardMessage) {
            this.standardMessage = standardMessage;
        }
    }



}
