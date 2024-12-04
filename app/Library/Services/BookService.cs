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

        public async Task<Book?> GetBookByIdAsync(int id)
        {
            var books = await GetAllBooksAsync();
            return books?.First(book => book.Id.Equals(id));
        }

        public async Task UpdateBookAsync(Book book) =>
            await _httpClient.PutAsJsonAsync("sample-data/books.json", book);

        public async Task CreateBookAsync(Book book) =>
            await _httpClient.PostAsJsonAsync("book/create", book);

        public async Task DeleteBookAsync(Book book)
        {
            throw new NotImplementedException();
        }
    }
}
