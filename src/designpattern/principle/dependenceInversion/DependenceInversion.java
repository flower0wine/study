package designpattern.principle.dependenceInversion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class DependenceInversion {
    public static void main(String[] args) {
        new Person().receive(new WeiXin());
    }
}

interface Message {
    String getInfo();
}

class Email implements Message {
    @Override
    public String getInfo() {
        return "邮件消息";
    }
}

class WeiXin implements Message {
    @Override
    public String getInfo() {
        return "微信消息";
    }
}

class Person {
    public void receive(Message message) {
        System.out.println(message.getInfo());
    }
}
