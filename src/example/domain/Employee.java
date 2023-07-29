package example.domain;


import example.Withdraw;

public abstract class Employee {
    protected Employee nextApprover;

    public void setNextApprover(
            Employee supervisor
    ){
        this.nextApprover = supervisor;
    }

    public abstract void processRequest(Withdraw request);

}
