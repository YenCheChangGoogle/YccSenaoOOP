public class SingletonV1 {
    private static SingletonV1 singleton = new SingletonV1();
    private SingletonV1() {}
    public static SingletonV1 getSingleton() {
        return singleton;
    }
}