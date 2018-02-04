public class Main {

    public static void main(String[] args) {
        SingletonV1 instance1 = SingletonV1.getSingleton();
        SingletonV1 instance2 = SingletonV1.getSingleton();
        if (instance1 == instance2) {
            System.out.println("instance1 and instance2 are the same.");
        } else {
            System.out.println("instance1 and instance2 are not the same.");
        }
    }
}
