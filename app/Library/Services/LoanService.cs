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

        public async Task CreateLoanAsync(int memberId, int bookId) =>
            await _httpClient.PostAsJsonAsync($"loan/loan-book/{memberId}/{bookId}", new Loan());

        public Task DeleteLoanAsync(Loan loan) => 
            throw new NotImplementedException();

        public async Task<IEnumerable<Loan>?> GetAllLoansAsync() =>
            await _httpClient.GetFromJsonAsync<IEnumerable<Loan>?>("loans");

        public Task<Book?> GetLoanByIdAsync(int id) 
            => throw new NotImplementedException();

        public async Task<IEnumerable<Loan>?> GetAllLoansByMemberIdAsync(int id) =>
            await _httpClient.GetFromJsonAsync<IEnumerable<Loan>?>($"loan/member/{id}");

        public Task UpdateLoanAsync(Loan loan) 
            => throw new NotImplementedException();

        public async Task<Loan?> GetLoanByBookIdAsync(int id)
        {
            try
            {
                return await _httpClient.GetFromJsonAsync<Loan?>($"loan/book/{id}");
            }
            catch
            {
                return null;
            }
        }
    }
}
