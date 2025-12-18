@Override
public List<CategorizationLog> getLog(Long ticketId) {
    return logRepo.findByTicket_Id(ticketId);
}
