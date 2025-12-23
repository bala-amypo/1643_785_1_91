import com.example.demo.repository.CategorizationLogRepository;
import com.example.demo.model.CategorizationLog;
import com.example.demo.model.Ticket;
import java.util.List;

public interface CategorizationEngineService {
    Ticket categorizeTicket(Long ticketId);
    List<CategorizationLog> getLogsForTicket(Long ticketId);
    CategorizationLog getLog(Long id);
    CategorizationLogRepository getCategorizationLogRepository();
}
