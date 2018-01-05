using System;

namespace DesignPatters.Builder.UserBuilder
{
    internal class Program
    {
        public static User GetUser()
        {
            return new UserBuilder("Leo", "Shiang")
                .SetAge(30)
                .SetPhone("1234567")
                .SetAddress("Taiwan")
                .Build();
        }

        public static void Main(string[] args)
        {
            User user = GetUser();
            Console.WriteLine(user.ToString());
            Console.Read();
        }
    }
}