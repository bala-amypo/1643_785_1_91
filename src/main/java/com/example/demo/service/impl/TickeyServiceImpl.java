@Service
public class TicketServiceImpl implements TicketService{
    private final TicketRepository repo;
    public TicketServiceImpl(TicketRepository repo){
        this.repo = repo;
    }
    public Ticket createTicket(Ticket ticket){
        return repo.save(ticket);
    }
    public Ticket getTicket(Long id){
        return repo.findById(id)
                
    }
}