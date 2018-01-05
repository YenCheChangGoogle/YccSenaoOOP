namespace Parts
{
    internal class ConcreteBuilderA : Builder
    {
        private readonly Product Product = new Product();

        public override void BuildPartA()
        {
            this.Product.Add("Part A");
        }

        public override void BuildPartB()
        {
            this.Product.Add("Part B");
        }

        public override Product GetResult()
        {
            return this.Product;
        }
    }
}