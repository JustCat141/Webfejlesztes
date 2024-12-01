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
            await _httpClient.GetFromJsonAsync<IEnumerable<Book>?>("sample-data/books.json");

        // TODO
        public async Task<Book?> GetBookByIdAsync(int id)
        {
            var books = await GetAllBooksAsync();
            return books?.First(book => book.Id.Equals(id));
        }

        // TODO
        public async Task UpdateBookAsync(Book book) =>
            await _httpClient.PutAsJsonAsync("", book);

        public Task AddBookAsync(Book book)
        {
            throw new NotImplementedException();
        }

        public Task DeleteBookAsync(Book book)
        {
            throw new NotImplementedException();
        }
    }
}
