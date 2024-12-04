using Library.Models;
using System.Linq;

namespace Library.Services
{
    public interface IBookService
    {
        Task<IEnumerable<Book>?> GetAllBooksAsync();

        Task<IEnumerable<Book>?> GetAllActiveBooksAsync();

        Task<Book?> GetBookByIdAsync(int id);

        Task UpdateBookAsync(Book book);

        Task CreateBookAsync(Book book);

        Task DeleteBookAsync(int id);

        Task ReturnBook(int id);
    }
}
