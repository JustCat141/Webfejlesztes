using System.ComponentModel.DataAnnotations;

namespace Library.Models
{
    public class Member : ObjectModel
    {
        [Required(ErrorMessage = "First name is required.")]
        public string FirstName { get; set; }
        [Required(ErrorMessage = "Last name is required.")]
        public string LastName { get; set; }
        public string FullName =>
            $"{FirstName} {LastName}";

        [Required(ErrorMessage = "Date of birth is required.")]
        public DateTime BirthDate { get; set; }

        public int Age =>
            DateTime.Today.Year - BirthDate.Year - (
                DateTime.Today < BirthDate.AddYears(
                    DateTime.Today.Year - BirthDate.Year
                    ) ? 1 : 0);

        public Member() : base()
        {
            BirthDate = DateTime.Today;
        }
    }
}