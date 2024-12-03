using System.Net.Http.Json;
using Library.Models;

namespace Library.Services
{
    public class MemberService : IMemberService
    {
        private readonly HttpClient _httpClient;

        public MemberService(HttpClient httpClient)
        {
            _httpClient = httpClient;
        }

        public async Task CreateMemberAsync(Member member) =>
            await _httpClient.PostAsJsonAsync("member/create", member);

        public Task DeleteMemberAsync(Member member)
        {
            throw new NotImplementedException();
        }

        public async Task<IEnumerable<Member>?> GetAllMembersAsync() =>
            await _httpClient.GetFromJsonAsync<IEnumerable<Member>?>("members");


        public async Task<Member?> GetMemberByIdAsync(int id)
        {
            var members = await GetAllMembersAsync();
            return members.First(m => m.Id.Equals(id));
        }

        public Task UpdateMemberAsync(Member member)
        {
            throw new NotImplementedException();
        }
    }
}
