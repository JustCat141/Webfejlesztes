using System.Diagnostics.CodeAnalysis;

namespace Library.Models
{
    public class Book
    {
        public long Id { get; set; }
        public string Title { get; set; }
        public string Author { get; set; }
        public int PublicationYear { get; set; }
        public bool? IsLoaned { get; set; }
    }
}