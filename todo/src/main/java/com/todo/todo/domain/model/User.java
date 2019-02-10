package com.todo.todo.domain.model;

import com.todo.todo.domain.repository.ByteArrayConverter;
import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@EqualsAndHashCode (callSuper = true)
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends AuditModel {

    @Email
    private String email;


    @NotEmpty
    private String name;


    @Convert (converter = ByteArrayConverter.class)
    @JsonIgnore
    @NotEmpty
    @Size(min = 60)
    private String password;

}
