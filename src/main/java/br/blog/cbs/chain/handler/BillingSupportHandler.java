package br.blog.cbs.chain.handler;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillingSupportHandler extends AbstractSupportHandler {

    public BillingSupportHandler() {
        super.level = BILLING;
    }

    @Override
    protected void handleRequest (List<String> actions){
        actions.add("BillingSupportHandler");
    }

}
