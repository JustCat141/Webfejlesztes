using System.Net.Http.Json;
using Library.Models;

namespace Library.Services
{
    public class LoanService : ILoanService
    {
        private readonly HttpClient _httpClient;

        public LoanService(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public async Task CreateLoanAsync(Loan loan) =>
            await _httpClient.PostAsJsonAsync("loan/loan-book", loan);

        public Task DeleteLoanAsync(Loan loan)
        {
            throw new NotImplementedException();
        }

        public async Task<IEnumerable<Loan>?> GetAllLoansAsync() =>
            await _httpClient.GetFromJsonAsync<IEnumerable<Loan>?>("loans");

        public Task<Book?> GetLoanByIdAsync(int id)
        {
            throw new NotImplementedException();
        }

        public Task UpdateLoanAsync(Loan loan)
        {
            throw new NotImplementedException();
        }
    }
}
