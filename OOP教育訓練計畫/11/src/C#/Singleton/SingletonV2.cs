namespace Singleton
{
public sealed class SingletonV2
{
    private static readonly SingletonV2 instance = new SingletonV2();

    private SingletonV2(){}

    public static SingletonV2 Instance
    {
        get
        {
            return instance;
        }
    }
}
}