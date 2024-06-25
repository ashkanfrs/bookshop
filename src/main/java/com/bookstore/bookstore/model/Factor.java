package com.bookstore.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Factor extends BaseEntity {
    @ManyToOne
    //@JoinColumn(name = "user_id")
    private User user;
    @Enumerated(EnumType.STRING)
    private Payed payed;
}
