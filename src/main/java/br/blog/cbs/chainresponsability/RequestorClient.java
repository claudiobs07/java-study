package br.blog.cbs.chainresponsability;


import br.blog.cbs.chainresponsability.handler.AbstractSupportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Component
public class RequestorClient {

    @Autowired
    List<AbstractSupportHandler> supportHandlers;

    public  AbstractSupportHandler getHandlerChain(){

        Collections.reverse(supportHandlers);
        Iterator<AbstractSupportHandler> it = supportHandlers.iterator();
        AbstractSupportHandler nextSupportHandler = it.next();
        while (it.hasNext()) {
            AbstractSupportHandler supportHandler = it.next();
            supportHandler.setNextHandler(nextSupportHandler);
            nextSupportHandler = supportHandler;
        }
        return nextSupportHandler;
    }
}
