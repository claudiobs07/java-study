package br.blog.cbs.chainresponsability.handler;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnicalSupportHandler extends AbstractSupportHandler {

    public TechnicalSupportHandler() {
        level = TECHNICAL;
    }

    @Override
    protected void handleRequest(List<String> actions) {
        actions.add("TechnicalSupportHandler");
    }

}
