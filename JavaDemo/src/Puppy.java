public class Puppy {

    private int age;

    public Puppy() {
        // 午参数构造器
    }

    public Puppy(String name) {
        // 这个构造器仅有一个参数 name
        System.out.println("小狗的名字是：" + name);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    void run() {
        System.out.println("run");
    }
}
