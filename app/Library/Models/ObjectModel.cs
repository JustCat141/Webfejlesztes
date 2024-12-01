namespace Library.Models
{
    public class ObjectModel
    {
        public int Id { get; set; }

        public DateTime CreatedDate { get; set; }
        public DateTime LastUpdateDate { get; set; }

        public ObjectModel()
        {
            CreatedDate = DateTime.Now;
            LastUpdateDate = DateTime.Now;
        }
    }
}
