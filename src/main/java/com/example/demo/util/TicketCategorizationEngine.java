package com.example.demo.util;

import java.util.*;
import com.example.demo.model.*;

public class TicketCategorizationEngine{
    public void categorization(
        Ticket t,
        List<Category> cats,
        List<CategorizationRule> rules,
        List<UrgencyPolicy> policies,
        List<CategorizationLog> logs
    ){
        String text = (t.getTitle() + " " + t.getDescription()).toLowerCase();
        rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .forEach(rule -> {
                    if(text.contains(rule,getKeyword().toLowerCase())){
                        t.setAssignedCategory(rule.getCategory());
                        t.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

                        CategorizationLog log = new CategorizationLog();
                        log.setTicket(t);
                        log.setAppliedRule(rule);
                        log.setMatchedKeyword(rule.getKwyword());
                        log.setAssignedCategory(rule.getCategory().gatCategoryName());
                        log.setAssignedUrgency(t.getUrgencyLevel());

                        logs.add(log);
                    }
                });
        policies.forEach(p -> {
            if(text.contains(p.getKeyword(). toLowerCase())){
                t.setUrgencyLevel(p.getUrgencyOverride());
            }
        });
    }
}