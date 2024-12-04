using System.Diagnostics.CodeAnalysis;

namespace Library.Models
{
    public class Loan : Object
    {
        [NotNull]
        public Member Member { get; init; }
        [NotNull]
        public Book Book { get; init; }

        public DateTimeOffset LoanDate { get; set; }
        public DateTimeOffset ReturnDueDate { get; set; }

        public bool IsOverDue =>
            ReturnDueDate < DateTimeOffset.Now;
    }
}