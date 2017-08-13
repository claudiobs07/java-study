package br.blog.cbs.chainresponsability.handler;

import org.springframework.stereotype.Component;

@Component
public class BillingSupportHandler extends AbstractSupportHandler {

    public BillingSupportHandler() {
        level = BILLING;
    }

    @Override
    protected void handleRequest (String message){
        System.out.println("BillingSupportHandler: Processing request. " + message);
    }

}
