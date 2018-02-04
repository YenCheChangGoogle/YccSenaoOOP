namespace Singleton
{
public class SingletonV1
{
    private static SingletonV1 instance;

    private SingletonV1() { }

    public static SingletonV1 Instance
    {
        get
        {
            if (instance == null)
            {
                instance = new SingletonV1();
            }
            return instance;
        }
    }
}
}