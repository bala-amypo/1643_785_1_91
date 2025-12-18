public interface TicketService{
    Ticket createTicket(Ticket ticket);
    Ticket getTicket(Long id);
    List<Ticket> getAllTickets();
}