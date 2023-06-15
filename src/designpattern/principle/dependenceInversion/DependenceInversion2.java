package designpattern.principle.dependenceInversion;

/**
 * @author flowerwine
 * @version 1.1
 * @projectName Algorithm
 * @description
 */
public class DependenceInversion2 {
    public static void main(String[] args) {
        new MyOpenOrClose().open(new Hasse());
    }
}

interface OpenOrClose {
    void open(Tv tv);
}

interface Tv {
    void play();
}

class MyOpenOrClose implements OpenOrClose {
    @Override
    public void open(Tv tv) {
        tv.play();
    }
}

class Hasse implements Tv {
    @Override
    public void play() {
        System.out.println("hasse 开启");
    }
}
