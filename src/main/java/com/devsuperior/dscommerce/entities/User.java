package com.devsuperior.dscommerce.entities;

import java.time.LocalDate;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @EqualsAndHashCode.Include
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @NonNull
    private String phone;

    @NonNull
    @CreationTimestamp(source = SourceType.DB)
    @Column(columnDefinition = "timestamp without time zone")
    private LocalDate birthdate;

    @NonNull
    private String password;

    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    @OneToMany(mappedBy = "client")
    private List<Order> orders;

}
