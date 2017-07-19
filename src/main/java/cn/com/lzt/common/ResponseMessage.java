package cn.com.lzt.common;/**
 * Created by Administrator on 2017/7/19.
 */

/**
 * 同意返回码
 *
 * @author WangH
 * @create 2017-07-19 16:50
 **/

import cn.com.lzt.common.util.JsonUtil;

/**
 * <p>ResponseMessage.java</p>
 * <p>响应结果类</p>
 * <p>Company: 国美小额贷款有限公司</p> 
 * <p>author: meigx</p>
 * <p>version: 1.0 2016年12月23日 上午10:04:23</p>
 * <p>修改者姓名 修改内容说明</p>
 */
public class ResponseMessage implements java.io.Serializable{

    /**
     * 序列化
     */
    private static final long serialVersionUID = 8320532078568526945L;

    private int code;        //响应码
    private String msg;      //响应信息
    private Object data;     //响应数据

    public static final ResponseMessage createSuccessMsg(Object data){
        ResponseMessage resMsg = new ResponseMessage(0, "成功", data);
        return resMsg;
    }

    public static final ResponseMessage createErrorMsg(Exception e){
       
        return new ResponseMessage(9998, "系统错误,请联系管理员", "系统错误,请联系管理员");
    }

    

    public ResponseMessage(){

    }


    public ResponseMessage(int code, String msg, Object data){
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



    public <T> T getData() {
        @SuppressWarnings("unchecked")
        T _data = (T) data;
        return _data;
    }

    public <T> void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JsonUtil.json2String(this);
    }

}
