package com.example.demo.util;

import com.example.demo.model.*;
import java.util.List;
import java.util.Optional;

@Component
public class TicketCategorizationEngine {

    public void categorize(Ticket ticket, 
                           List<Category> categories, 
                           List<CategorizationRule> rules, 
                           List<UrgencyPolicy> policies, 
                           List<CategorizationLog> logs) {

        String content = (Optional.ofNullable(ticket.getTitle()).orElse("") + " " + 
                         Optional.ofNullable(ticket.getDescription()).orElse("")).toLowerCase();

        CategorizationRule bestRule = rules.stream()
                .filter(rule -> content.contains(rule.getKeyword().toLowerCase()))
                .max((r1, r2) -> r1.getPriority().compareTo(r2.getPriority()))
                .orElse(null);

        if (bestRule != null) {
            ticket.setAssignedCategory(bestRule.getCategory());
            ticket.setUrgencyLevel(bestRule.getCategory().getDefaultUrgency());

            CategorizationLog log = new CategorizationLog();
            log.setTicket(ticket);
            log.setAppliedRule(bestRule);
            logs.add(log);
        }

        for (UrgencyPolicy policy : policies) {
            if (content.contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }
}