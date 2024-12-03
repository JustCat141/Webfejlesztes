namespace Library.Models
{
    public class Loan : ObjectModel
    {
        public int MemberId { get; set; }
        public int BookId { get; set; }
        
        public DateTime LoanDate { get; set; }
        public DateTime ReturnDueDate { get; set; }
    }
}