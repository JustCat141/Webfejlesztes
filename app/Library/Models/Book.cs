using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;

namespace Library.Models
{
    public class Book : ObjectModel
    {
        [Required(ErrorMessage = "Title is required.")]
        public string Title { get; set; }

        [Required(ErrorMessage = "Author is required.")]
        public string Author { get; set; }

        [Range(0, 9999, ErrorMessage = "Please enter a valid year.")]
        public int PublicationYear { get; set; }

        public Book() : base()
        {
            PublicationYear = DateTimeOffset.Now.Year;
        }
    }
}