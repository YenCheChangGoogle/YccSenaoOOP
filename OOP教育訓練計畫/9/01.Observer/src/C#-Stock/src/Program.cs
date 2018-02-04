using System;
using System.Collections.Generic;

namespace DoFactory.GangOfFour.Observer.RealWorld
{
    public interface IInvestor
    {
        void Update(Stock stock);
    }

    public abstract class Stock
    {
        private readonly List<IInvestor> Investors = new List<IInvestor>();
        private double LatestPrice;

        protected Stock(string symbol, double latestPrice)
        {
            this.Symbol = symbol;
            this.LatestPrice = latestPrice;
        }

        public double Price
        {
            get => LatestPrice;
            set
            {
                if (this.LatestPrice == value) return;
                this.LatestPrice = value;
                Notify();
            }
        }

        public string Symbol { get; set; }

        public void Attach(IInvestor investor)
        {
            this.Investors.Add(investor);
        }

        public void Detach(IInvestor investor)
        {
            this.Investors.Remove(investor);
        }

        public void Notify()
        {
            foreach (IInvestor investor in this.Investors)
            {
                investor.Update(this);
            }
            Console.WriteLine("");
        }
    }

    public class Senao : Stock
    {
        public Senao(string symbol, double latestPrice) : base(symbol, latestPrice)
        {
        }
    }

    public class Investor : IInvestor
    {
        private readonly string Name;

        public Investor(string name)
        {
            this.Name = name;
        }

        public Stock _stock { get; set; }

        public void Update(Stock stock)
        {
            Console.WriteLine("通知 {0} 股票 {1} 價格變為 {2:C}", this.Name, stock.Symbol, stock.Price);
        }
    }

    public class MainApp
    {
        private static void Main()
        {
            Senao senao = new Senao("2450", 51.00);
            senao.Attach(new Investor("Leo Shiang"));
            senao.Attach(new Investor("Sam Xiao"));

            senao.Price = 51.40;
            senao.Price = 52.00;
            senao.Price = 120.75;
            Console.ReadKey();
        }
    }
}