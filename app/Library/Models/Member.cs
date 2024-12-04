using System.ComponentModel.DataAnnotations;

namespace Library.Models
{
    public class Member : Object
    {
        public const int MINIMUM_MEMBER_AGE = 6;

        [Required(ErrorMessage = "First name is required.")]
        public string FirstName { get; set; }
        [Required(ErrorMessage = "Last name is required.")]
        public string LastName { get; set; }
        public string FullName =>
            $"{FirstName} {LastName}";

        [Required]
        [EmailAddress(ErrorMessage = "Invalid email")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Date of birth is required.")]
        [DataType(DataType.Date)]
        public DateTimeOffset BirthDate { get; set; }

        public int Age =>
          DateTimeOffset.Now.Year - BirthDate.Year - (
              DateTimeOffset.Now.Date < BirthDate.AddYears(DateTimeOffset.Now.Year - BirthDate.Year).Date
              ? 1 : 0);

        public Member() : base()
        {
            BirthDate = DateTimeOffset.Now;
        }
    }
}