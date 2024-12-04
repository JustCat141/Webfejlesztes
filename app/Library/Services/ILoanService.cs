using Library.Models;

namespace Library.Services
{
    public interface ILoanService
    {
        Task<IEnumerable<Loan>?> GetAllLoansAsync();
        
        Task<IEnumerable<Loan>?> GetAllLoansByMemberIdAsync(int id);

        Task<Loan?> GetLoanByBookIdAsync(int id);

        Task CreateLoanAsync(int memberId, int bookId);

        Task DeleteLoanAsync(Loan loan);
    }
}
