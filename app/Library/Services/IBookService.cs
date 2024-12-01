using Library.Models;
using System.Linq;

namespace Library.Services
{
    public interface IBookService
    {
        Task<IEnumerable<Book>?> GetAllBooksAsync();

        Task<Book?> GetBookByIdAsync(int id);

        Task UpdateBookAsync(Book book);

        Task DeleteBookAsync(Book book);

        Task AddBookAsync(Book book);
    }
}
