package designpattern.adapter.spring;

public interface HandlerAdapter {

    boolean supports(Controller obj);

    void handle(Controller controller);
}
