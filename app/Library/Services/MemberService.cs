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

        public Task AddMemberAsync(Member member)
        {
            throw new NotImplementedException();
        }

        public Task DeleteMemberAsync(Member member)
        {
            throw new NotImplementedException();
        }

        public async Task<IEnumerable<Member>?> GetAllMembersAsync() =>
            await _httpClient.GetFromJsonAsync<IEnumerable<Member>?>("sample-data/members.json");


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
