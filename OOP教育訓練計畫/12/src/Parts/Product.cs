using System;
using System.Collections.Generic;

namespace Parts
{
    internal class Product
    {
        private IList<string> Parts = new List<string>();

        public void Add(string part)
        {
            this.Parts.Add((part));
        }

        public void Show()
        {
            foreach (string part in this.Parts)
            {
                Console.WriteLine(part);
            }
        }
    }
}