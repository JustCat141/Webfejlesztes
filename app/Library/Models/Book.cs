using System.ComponentModel.DataAnnotations;
using System.Diagnostics.CodeAnalysis;

namespace Library.Models
{
    public class Book
    {
        public int Id { get; set; }

        [Required(ErrorMessage = "Title is required.")]
        public string Title { get; set; }

        [Required(ErrorMessage = "Author is required.")]
        public string Author { get; set; }

        [Range(0, 9999, ErrorMessage = "Please enter a valid year.")]
        public int PublicationYear { get; set; }

        public bool? IsLoaned { get; set; }

        public Book()
        {
            PublicationYear = DateTime.Now.Year;
        }
    }
}