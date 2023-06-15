package designpattern.builder;

public abstract class Builder {
    protected abstract void collect();
    protected abstract void make();
    protected abstract void check();
    protected abstract void sell();
}
