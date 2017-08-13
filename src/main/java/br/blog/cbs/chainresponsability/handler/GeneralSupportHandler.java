package br.blog.cbs.chainresponsability.handler;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GeneralSupportHandler extends AbstractSupportHandler {

    public GeneralSupportHandler() {
        level = GENERAL;
    }

    @Override
    protected void handleRequest(List<String> actions) {
        actions.add("GeneralSupportHandler");
    }

}
