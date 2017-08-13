package br.blog.cbs.chainresponsability.handler;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillingSupportHandler extends AbstractSupportHandler {

    public BillingSupportHandler() {
        level = BILLING;
    }

    @Override
    protected void handleRequest (List<String> actions){
        actions.add("BillingSupportHandler");
    }

}
