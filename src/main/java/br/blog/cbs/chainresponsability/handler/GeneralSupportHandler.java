package br.blog.cbs.chainresponsability.handler;

import org.springframework.stereotype.Component;

@Component
public class GeneralSupportHandler extends AbstractSupportHandler {

    public GeneralSupportHandler() {
        level = GENERAL;
    }

    @Override
    protected void handleRequest(String message) {
        System.out.println("GeneralSupportHandler: Processing request. " + message);
    }

}
