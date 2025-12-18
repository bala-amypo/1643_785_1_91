@RestController
@RequestMapping("/api/tickets")
@Tag(name = "Tickets")
@SecurityRequirement(name = "bearerAuth")
public class TicketController{
    private final TicketService service;
    public TicketController(TicketService service){
        this.service = service;
    }
    @PostMapping
    public Ticket create(@RequestBody Ticket ticket){
        return service.createTicket(ticket);
    }
    @GetMapping
    public List<Ticket> list(){
        return service.getAllTickets();
    }
    @GetMapping("/{id}")
    public Ticket get(@PathVariable Long id){
        return service.getTicket(id);
    }
}