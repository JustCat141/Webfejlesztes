namespace Library.Models
{
    public class ObjectModel
    {
        public int Id { get; set; }

        public DateTimeOffset CreatedDate { get; set; }
        public DateTimeOffset LastUpdateDate { get; set; }

        public ObjectModel()
        {
            CreatedDate = DateTimeOffset.Now;
            LastUpdateDate = DateTimeOffset.Now;
        }
    }
}
