package br.blog.cbs.chain;


import br.blog.cbs.chain.handler.AbstractSupportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RequestorClient {

    @Autowired
    List<AbstractSupportHandler> supportHandlers;

    public  AbstractSupportHandler getHandlerChain(){

        supportHandlers.sort((handler1, handler2) -> (handler1.level < handler2.level ? 1 : -1));
        AbstractSupportHandler nextSupportHandler = null;
        for (AbstractSupportHandler supportHandler : supportHandlers) {
            supportHandler.setNextHandler(nextSupportHandler);
            nextSupportHandler = supportHandler;
        }
        return nextSupportHandler;
    }
}
