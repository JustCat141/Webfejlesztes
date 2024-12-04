using Library.Models;

namespace Library.Services
{
    public interface ILoanService
    {
        Task<IEnumerable<Loan>?> GetAllLoansAsync();
        
        Task<IEnumerable<Loan>?> GetAllLoansByMemberIdAsync(int id);

        Task CreateLoanAsync(int memberId, int bookId);

        Task<Loan?> GetLoanByIdAsync(int id);

        Task UpdateLoanAsync(Loan loan);

        Task DeleteLoanAsync(Loan loan);
    }
}
