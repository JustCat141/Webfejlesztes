using Library.Models;

namespace Library.Services
{
    public interface IMemberService
    {
        Task<IEnumerable<Member>?> GetAllMembersAsync();

        Task<Member?> GetMemberByIdAsync(int id);

        Task UpdateMemberAsync(Member member);

        Task DeleteMemberAsync(int id);

        Task CreateMemberAsync(Member member);
    }
}