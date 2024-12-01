using System.ComponentModel.DataAnnotations;

namespace Library.Models
{
    public class Member : ObjectModel
    {
        public const int MINIMUM_MEMBER_AGE = 6;

        [Required(ErrorMessage = "First name is required.")]
        public string FirstName { get; set; }
        [Required(ErrorMessage = "Last name is required.")]
        public string LastName { get; set; }
        public string FullName =>
            $"{FirstName} {LastName}";

        [EmailAddress(ErrorMessage = "Invalid email")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Date of birth is required.")]
        [DataType(DataType.Date)]
        [CustomValidation(typeof(Member), nameof(ValidateBirthDate))]
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

        public static ValidationResult ValidateBirthDate(DateTime birthDate, ValidationContext context)
        {
            if (birthDate > DateTime.Today)
            {
                return new ValidationResult("Birth date cannot be in the future.");
            }

            int age = DateTime.Today.Year - birthDate.Year - (
                DateTime.Today < birthDate.AddYears(
                    DateTime.Today.Year - birthDate.Year
                ) ? 1 : 0);

            if (age < MINIMUM_MEMBER_AGE)
            {
                return new ValidationResult($"Members must be at least {MINIMUM_MEMBER_AGE} years old.");
            }

            return ValidationResult.Success;
        }
    }
}