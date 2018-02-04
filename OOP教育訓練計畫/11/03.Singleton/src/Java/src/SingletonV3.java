public class SingletonV3 {
    private static SingletonV3 instance;
    private SingletonV3(){}
    public static synchronized SingletonV3 getInstance(){
        if(instance == null){
            instance = new SingletonV3();
        }
        return instance;
    }
}