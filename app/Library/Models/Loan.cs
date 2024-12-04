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

        /*public static Loan FromDto(LoanResponseDto dto)
        {
            return new Loan()
            {
                Id = dto.Id,
                MemberId = dto.Member.Id,
                BookId = dto.Book.Id,
                LoanDate = dto.LoanDate,
                ReturnDueDate = dto.ReturnDueDate,

                CreatedDate = dto.CreatedDate,
                LastUpdateDate = dto.LastUpdateDate
            };
        }*/

        public bool IsOverDue =>
            ReturnDueDate < DateTimeOffset.Now;
    }
}