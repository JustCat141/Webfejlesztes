using Library.Models;
using System.Diagnostics.CodeAnalysis;

public record LoanResponseDto
{
    public int Id { get; init; }
    [NotNull]
    public Member Member { get; init; }
    [NotNull]
    public Book Book { get; init; }
    public DateTimeOffset LoanDate { get; init; }
    public DateTimeOffset ReturnDueDate { get; init; }
    public DateTimeOffset CreatedDate { get; init; }
    public DateTimeOffset LastUpdateDate { get; init; }
}