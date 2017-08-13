package br.blog.cbs.chainresponsability.handler;

import org.springframework.stereotype.Component;

@Component
public class TechnicalSupportHandler extends AbstractSupportHandler {

    public TechnicalSupportHandler() {
        level = TECHNICAL;
    }

    @Override
    protected void handleRequest(String message) {
        System.out.println("TechnicalSupportHandler: Processing request " + message);
    }

}
