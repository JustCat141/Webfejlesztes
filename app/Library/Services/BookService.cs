using System.Net.Http.Json;
using Library.Models;

namespace Library.Services
{
    public class BookService : IBookService
    {
        private readonly HttpClient _httpClient;

        public BookService(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public async Task<IEnumerable<Book>?> GetAllBooksAsync() =>
            await _httpClient.GetFromJsonAsync<IEnumerable<Book>?>("books");

        public async Task<IEnumerable<Book>?> GetAllActiveBooksAsync() =>
            await _httpClient.GetFromJsonAsync<IEnumerable<Book>?>("books/available");

        public async Task<Book?> GetBookByIdAsync(int id) =>
            await _httpClient.GetFromJsonAsync<Book?>($"book/{id}");

        public async Task CreateBookAsync(Book book) =>
            await _httpClient.PostAsJsonAsync("book/create", book);

        public async Task UpdateBookAsync(Book book) =>
            await _httpClient.PutAsJsonAsync("book/update", book);

        public async Task DeleteBookAsync(int id) =>
            await _httpClient.DeleteAsync($"book/delete/{id}");

        public async Task ReturnBook(int id) =>
            await _httpClient.DeleteAsync($"book/return/{id}");
    }
}
