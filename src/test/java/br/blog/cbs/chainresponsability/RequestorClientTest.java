package br.blog.cbs.chainresponsability;

import br.blog.cbs.Application;
import br.blog.cbs.chainresponsability.handler.AbstractSupportHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static br.blog.cbs.chainresponsability.handler.AbstractSupportHandler.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
public class RequestorClientTest {

    @Autowired
    RequestorClient requestorClient;

    @Test
    public void testGetHandlerChain() {
        AbstractSupportHandler handler = requestorClient.getHandlerChain();
        handler.receiveRequest(TECHNICAL, " I'm having problem with my internet connectivity.");
        System.out.println("............................................");
        handler.receiveRequest(BILLING, "Please resend my bill of this month.");
        System.out.println("............................................");
        handler.receiveRequest(GENERAL, "Please send any other plans for home users.");
    }


}
