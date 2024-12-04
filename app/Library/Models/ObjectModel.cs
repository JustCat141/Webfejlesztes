namespace Library.Models
{
    public class Object
    {
        public int Id { get; set; }

        public DateTimeOffset CreatedDate { get; set; }
        public DateTimeOffset LastUpdateDate { get; set; }

        public Object()
        {
            CreatedDate = DateTimeOffset.Now;
            LastUpdateDate = DateTimeOffset.Now;
        }
    }
}
