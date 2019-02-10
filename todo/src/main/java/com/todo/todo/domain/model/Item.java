package com.todo.todo.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import lombok.*;
import lombok.experimental.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Item extends AuditModel{
    private String title;
    private String content;
}