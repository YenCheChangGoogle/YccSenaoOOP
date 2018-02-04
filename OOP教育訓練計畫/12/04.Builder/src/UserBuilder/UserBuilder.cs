namespace DesignPatters.Builder.UserBuilder
{
    public class UserBuilder
    {
        public UserBuilder(string firstName, string lastName)
        {
            this.FirstName = firstName;
            this.LastName = lastName;
        }

        public string Address { get; set; }
        public int Age { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string Phone { get; set; }

        public User Build()
        {
            return new User(this);
        }

        public UserBuilder SetAddress(string address)
        {
            this.Address = address;
            return this;
        }

        public UserBuilder SetAge(int age)
        {
            this.Age = age;
            return this;
        }

        public UserBuilder SetPhone(string phone)
        {
            this.Phone = phone;
            return this;
        }
    }
}