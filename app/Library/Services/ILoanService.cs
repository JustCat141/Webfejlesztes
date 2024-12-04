using Library.Models;

namespace Library.Services
{
    public interface ILoanService
    {
        Task<IEnumerable<Loan>?> GetAllLoansAsync();

        Task<Book?> GetLoanByIdAsync(int id);

        Task UpdateLoanAsync(Loan loan);

        Task DeleteLoanAsync(Loan loan);

        Task CreateLoanAsync(Loan loan);
    }
}
