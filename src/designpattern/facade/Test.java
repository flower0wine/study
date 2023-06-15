package designpattern.facade;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class Test {
    private ProcedureA procedureA;
    private ProcedureB procedureB;
    private ProcedureC procedureC;

    public Test(ProcedureA procedureA, ProcedureB procedureB, ProcedureC procedureC) {
        this.procedureA = procedureA;
        this.procedureB = procedureB;
        this.procedureC = procedureC;
    }

    public void execute() {
        procedureA.execute();
        procedureB.execute();
        procedureC.execute();
    }

    public static void main(String[] args) {
        new Test(new ProcedureA(), new ProcedureB(), new ProcedureC()).execute();
    }
}
