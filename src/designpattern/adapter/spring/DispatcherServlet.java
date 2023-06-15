package designpattern.adapter.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class DispatcherServlet {

    private List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    public DispatcherServlet() {
        handlerAdapters.add(new AnnotationHandlerAdapter());
    }

    public void doDispatch() {
        Controller controller = new AnnotationController();

        HandlerAdapter handler = getHandler(controller);
        handler.handle(controller);
    }

    private HandlerAdapter getHandler(Controller controller) {
        for(HandlerAdapter adapter : this.handlerAdapters) {
            if(adapter.supports(controller)) {
                return adapter;
            }
        }
        return null;
    }
}
