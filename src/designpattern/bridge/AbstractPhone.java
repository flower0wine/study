package designpattern.bridge;

public abstract class AbstractPhone implements Phone {
    protected PhoneStyle phoneStyle;

    public AbstractPhone(PhoneStyle phoneStyle) {
        this.phoneStyle = phoneStyle;
    }
}
