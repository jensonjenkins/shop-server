package com.idp.server.order;

import jakarta.persistence.*;

@Entity
@Table
public class OrderTable {
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long id;
    private Long sessionId;

    public OrderTable() {
    }

    public OrderTable(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Long getId() {
        return id;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }
}
