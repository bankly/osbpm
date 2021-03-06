package cn.linkey.ws.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390- Generated source version: 2.0
 * 
 */
@WebService(name = "WF_CallBack", targetNamespace = "http://server.ws.linkey.cn/")
public interface WFCallBack {

    /**
     * 
     * @param syspwd
     * @param userid
     * @param params
     * @return returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "callback", targetNamespace = "http://server.ws.linkey.cn/", className = "cn.linkey.ws.client.Callback")
    @ResponseWrapper(localName = "callbackResponse", targetNamespace = "http://server.ws.linkey.cn/", className = "cn.linkey.ws.client.CallbackResponse")
    public String callback(@WebParam(name = "params", targetNamespace = "") String params, @WebParam(name = "userid", targetNamespace = "") String userid,
            @WebParam(name = "syspwd", targetNamespace = "") String syspwd);

}
