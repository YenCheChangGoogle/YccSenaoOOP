public class SingletonV2 {
    private static SingletonV2 instance;
    private SingletonV2() {}
    public static SingletonV2 getInstance() {
        if (instance == null) {
            instance = new SingletonV2();
        }
        return instance;
    }
}