using System;

namespace Parts
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            Director director = new Director();
            Builder budilerA = new ConcreteBuilderA();
            Builder budilerB = new ConcreteBuilderB();

            director.Construct(budilerA);
            Product productA = budilerA.GetResult();
            productA.Show();

            director.Construct(budilerB);
            Product productB = budilerB.GetResult();
            productB.Show();

            Console.Read();
        }
    }
}