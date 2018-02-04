namespace Singleton
{
    using System;

public sealed class SingletonV3
{
    private static readonly object SyncRoot = new Object();
    private static volatile SingletonV3 instance;
    private SingletonV3(){}
    public static SingletonV3 Instance
    {
        get
        {
            if (instance == null)
            {
                lock (SyncRoot)
                {
                    if (instance == null)
                        instance = new SingletonV3();
                }
            }

            return instance;
        }
    }
}
}