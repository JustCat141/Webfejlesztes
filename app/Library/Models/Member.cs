namespace Library.Models
{
    public class Member
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public DateTime BirthDate { get; set; }

        public int Age =>
            DateTime.Today.Year - BirthDate.Year - (
                DateTime.Today < BirthDate.AddYears(
                    DateTime.Today.Year - BirthDate.Year
                    ) ? 1 : 0);

    }
}