package com.example.demo.util;

import com.example.demo.model.*;
import com.example.demo.repository.CategorizationLogRepository;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            CategorizationLogRepository logRepository
    ) {

        String text = (ticket.getTitle() + " " + ticket.getDescription()).toLowerCase();

        rules.sort(Comparator.comparingInt(CategorizationRule::getPriority).reversed());

        for (CategorizationRule rule : rules) {
            String keyword = rule.getKeyword().toLowerCase();
            boolean matched = matches(rule.getMatchType(), keyword, text);

            if (matched) {
                Category category = rule.getCategory();

                ticket.setAssignedCategory(category);
                ticket.setUrgencyLevel(category.getDefaultUrgency());

                CategorizationLog log = new CategorizationLog(
                        ticket,
                        rule,
                        rule.getKeyword(),
                        category,
                        ticket.getUrgencyLevel()
                );

                logRepository.save(log);
                break;
            }
        }

        for (UrgencyPolicy policy : policies) {
            if (text.contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyOverride(policy.getUrgencyOverride());
                ticket.setUrgencyLevel(policy.getUrgencyOverride());

                CategorizationLog log = new CategorizationLog(
                        ticket,
                        null,
                        policy.getKeyword(),
                        ticket.getAssignedCategory(),
                        policy.getUrgencyOverride()
                );

                logRepository.save(log);
            }
        }
    }

    private boolean matches(String matchType, String keyword, String text) {
        switch (matchType.toUpperCase()) {
            case "EXACT":
                return text.equals(keyword);
            case "CONTAINS":
                return text.contains(keyword);
            case "REGEX":
                return Pattern.compile(keyword, Pattern.CASE_INSENSITIVE).matcher(text).find();
            default:
                return false;
        }
    }
}