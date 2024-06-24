package com.bookstore.bookstore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class Factor extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
