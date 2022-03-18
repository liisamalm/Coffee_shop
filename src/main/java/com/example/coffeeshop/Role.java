package com.example.coffeeshop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role extends AbstractPersistable<Long>{
    private String name;
}

