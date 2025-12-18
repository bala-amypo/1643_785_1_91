package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {
        String text = ticket.getDescription().toLowerCase();

        for (CategorizationRule rule : rules) {
            boolean matched = false;

            String keyword = rule.getKeyword().toLowerCase();

            switch (rule.getMatchType()) {
                case EXACT:
                    matched = text.equalsIgnoreCase(keyword);
                    break;

                case CONTAINS:
                    matched = text.contains(keyword);
                    break;

                case REGEX:
                    matched = Pattern.matches(keyword, text);
                    break;
            }

            if (matched) {
                ticket.setCategory(rule.getCategory());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setMatchedKeyword(keyword);
                log.setAssignedCategory(rule.getCategory().getName());
                logs.add(log);
            }
        }

        for (UrgencyPolicy policy : policies) {
            if (text.contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgency(policy.getUrgency());
            }
        }
    }
}
