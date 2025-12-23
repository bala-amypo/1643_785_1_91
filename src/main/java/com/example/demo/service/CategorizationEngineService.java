import com.example.demo.repository.CategorizationLogRepository;

public interface CategorizationEngineService {
    Ticket categorizeTicket(Long ticketId);
    List<CategorizationLog> getLogsForTicket(Long ticketId);
    CategorizationLog getLog(Long id);
    CategorizationLogRepository getCategorizationLogRepository();
}
