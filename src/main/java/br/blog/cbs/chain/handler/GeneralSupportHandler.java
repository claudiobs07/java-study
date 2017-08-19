package br.blog.cbs.chain.handler;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralSupportHandler extends AbstractSupportHandler {

    public GeneralSupportHandler() {
        super.level = GENERAL;
    }

    @Override
    protected void handleRequest(List<String> actions) {
        actions.add("GeneralSupportHandler");
    }

}
