using Library.Models;

namespace Library.Services
{
    public interface IMemberService
    {
        Task<IEnumerable<Member>?> GetAllMembersAsync();

        Task<Member?> GetMemberByIdAsync(int id);

        Task UpdateMemberAsync(Member member);

        Task DeleteMemberAsync(Member member);

        Task AddMemberAsync(Member member);
    }
}