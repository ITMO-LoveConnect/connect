package ru.itmo.loveconnect.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tag")
public class TagEntity extends AbstractPersistable<UUID> {

    private String name;

}
