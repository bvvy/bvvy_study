/**
 * Created by bvvy on 2017/8/14.
 */
public class Cat {

    protected Cat() {

    }

    public void a() {

    }
}

class BlackCat extends Cat {

    private String a;


    public BlackCat(String a) {
        super();
        this.a = a;
    }

    public void say() {
        System.out.println(a);
    }

}