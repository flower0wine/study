package designpattern.adapter.spring;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class AnnotationHandlerAdapter implements HandlerAdapter {

    @Override
    public boolean supports(Controller obj) {
        return obj instanceof AnnotationController;
    }

    @Override
    public void handle(Controller controller) {
        ((AnnotationController) controller).doAnnotation();
    }
}
