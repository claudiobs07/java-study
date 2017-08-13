package br.blog.cbs.chainresponsability.handler;

import java.util.List;

public abstract class AbstractSupportHandler {

    public static int TECHNICAL = 10;
    public static int BILLING = 20;
    public static int GENERAL = 30;

    protected  int level;
    protected AbstractSupportHandler nextHandler;

    public void setNextHandler(AbstractSupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void receiveRequest(int level, List<String> actions) {
        if (this.level <= level)
            handleRequest(actions);
        if (nextHandler != null)
            nextHandler.receiveRequest(level, actions);
    }

    abstract protected void handleRequest(List<String> actions);
}
