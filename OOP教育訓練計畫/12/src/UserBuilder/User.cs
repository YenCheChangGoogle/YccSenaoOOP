namespace DesignPatters.Builder.UserBuilder
{
    public class User
    {
        public User(UserBuilder builder)
        {
            this.FirstName = builder.FirstName;
            this.LastName = builder.LastName;
            this.Age = builder.Age;
            this.Phone = builder.Phone;
            this.Address = builder.Address;
        }

        public string Address { get; set; }
        public int Age { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Phone { get; set; }

        public override string ToString()
        {
            return base.ToString() + ": " + this.FirstName + "," + this.LastName + "," + this.Age + "," +
                   this.Phone + "," + this.Address;
        }
    }
}