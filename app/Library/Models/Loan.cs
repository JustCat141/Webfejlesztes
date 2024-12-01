namespace Library.Models
{
    public class Loan
    {
        public long Id { get; set; }
        public long MemberId { get; set; }
        public long BookId { get; set; }

        public LoanState State { get; set; }
        
        public DateTime LoanDate { get; set; }
        public DateTime ReturnDueDate { get; set; }
        public DateTime? ReturnDate { get; set; }

        public enum LoanState
        {
            Borrowed,
            Returned,
            NotReturned,
            LateReturned
        }
    }
}