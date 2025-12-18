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
                    if(text.c)
                })
    }
}