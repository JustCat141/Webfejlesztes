namespace Library.Models
{
    public class Loan : ObjectModel
    {
        public int MemberId { get; set; }
        public int BookId { get; set; }
        
        public DateTimeOffset LoanDate { get; set; }
        public DateTimeOffset ReturnDueDate { get; set; }
    }
}