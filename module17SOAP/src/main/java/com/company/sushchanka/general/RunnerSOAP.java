package com.company.sushchanka.general;

import com.company.sushchanka.model.beans.User;
import com.company.sushchanka.service.UserWebServiceSEI;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import java.util.List;

/**
 * Created by alt-hanny on 02.11.2016.
 */
public class RunnerSOAP {
    public static void main(String[] args) {
        SOAPFromClient();
    }

    private static void SOAPFromClient() {
        String soapServiceURL="http://localhost:8080/soap/webserviceSOAP";

        JaxWsProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
        factoryBean.setServiceClass(UserWebServiceSEI.class);
        factoryBean.setAddress(soapServiceURL);

        UserWebServiceSEI userWS = (UserWebServiceSEI) factoryBean.create();
        List<User> users = userWS.findAllUsers();
        for(User user : users) {
            System.out.println(user.toString());
        }
    }
}
