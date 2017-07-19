package cn.com.lzt.common.inteceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;


/**
 * 
 * <p>SmsRequestListener.java</p>
 * <p>TODO</p>
 * <p>Company: </p> 
 * <p>author: </p>
 * <p>version: 1.0 2016年12月28日 上午11:50:04</p>
 * <p>修改者姓名 修改内容说明</p>
 */
public class SmsRequestListener implements ServletRequestAttributeListener,
        ServletRequestListener {
    
    private static final Logger LOG = LoggerFactory.getLogger(SmsRequestListener.class);
    
    @Override
    public void requestDestroyed(ServletRequestEvent event) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        
        boolean flag = true;
        
        //打印所有请求参数
        try{
            
            HttpServletRequest req = (HttpServletRequest) event.getServletRequest();
            req.setCharacterEncoding("UTF8");
            
            //获取请求的所有报文头信息并打印
            Enumeration<String> enumHeader = req.getHeaderNames();
            StringBuffer url=req.getRequestURL();
            if(url.toString().endsWith(".do")){
                StringBuffer sbHeader = new StringBuffer();
                sbHeader.append("\n");
                sbHeader.append("##################################################");
                sbHeader.append("\n");
                sbHeader.append("##########接收请求,url={"+req.getServletPath()+"},url全路径:{");
                sbHeader.append(req.getRequestURL()).append("}");
                sbHeader.append("\n");
                sbHeader.append("##########接收请求,报文头信息={");
                sbHeader.append("\n");
                while(enumHeader.hasMoreElements()){
                    String key = enumHeader.nextElement();
                    sbHeader.append("["+key+"] = {"+req.getHeader(key)+"}, ");
                    sbHeader.append("\n");
                }
                sbHeader.append("}");
                sbHeader.append("\n");

                //获取请求的所有参数信息并打印
                Enumeration<String> enumParam = req.getParameterNames();
                StringBuffer sbParam = new StringBuffer();
                sbParam.append("##########接收请求,参数信息={");
                sbParam.append("\n");
                while(enumParam.hasMoreElements()){
                    String key = enumParam.nextElement();
                    sbParam.append("["+key+"] = {"+req.getParameter(key).replace("\r|\n|\t", "")+"}, ");
                    sbParam.append("\n");
                }
                sbParam.append("}");
                sbParam.append("\n");

                if(true){
                    sbHeader.append(sbParam);
                    sbHeader.append("##################################################");
                    if(!sbHeader.toString().contains("druid")){
                        LOG.info(new String(sbHeader));
                    }
                }
            }
           
//            //去重
//            if(Constants.LOGBUTTON){
//                Constants.LOGBUTTON = false;
//                flag = false;
//            }
//            //去重
//            if(!Constants.LOGBUTTON&&flag){
//                Constants.LOGBUTTON = true;
//            }
        }catch(Exception e){
            LOG.info("##########接收请求异常,信息={"+e.getMessage()+"}");
        }
        
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        // TODO Auto-generated method stub

    }

}
