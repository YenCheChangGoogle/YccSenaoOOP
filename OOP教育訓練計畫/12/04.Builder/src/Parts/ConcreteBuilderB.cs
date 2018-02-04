namespace Parts
{
    internal class ConcreteBuilderB : Builder
    {
        private readonly Product Product = new Product();

        public override void BuildPartA()
        {
            this.Product.Add("Part X");
        }

        public override void BuildPartB()
        {
            this.Product.Add("Part Y");
        }

        public override Product GetResult()
        {
            return this.Product;
        }
    }
}