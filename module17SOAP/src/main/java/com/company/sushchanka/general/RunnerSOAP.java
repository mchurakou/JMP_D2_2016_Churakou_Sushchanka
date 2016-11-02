package com.company.sushchanka.general;

import com.company.sushchanka.service.UserServiceImpl;

import javax.xml.ws.Endpoint;


/**
 * Created by alt-hanny on 02.11.2016.
 */
public class RunnerSOAP {
    public static void main(String[] args) {
        SOAPFromClient();
    }

    private static void SOAPFromClient() {
        Endpoint.publish("http://localhost:8080/module17", new UserServiceImpl());
    }
}
