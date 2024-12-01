namespace Library.Models
{
    public class Loan : ObjectModel
    {
        public int MemberId { get; set; }
        public int BookId { get; set; }

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