package ir.webapp.springprojectapi.model.entity;

import ir.webapp.springprojectapi.model.entity.base.BaseEntity;
import ir.webapp.springprojectapi.model.entity.enumeration.Classification;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity(name = "UserAccessEntity")
@Table(name = "UserAccessTable")
public class UserAccess extends BaseEntity {


    //LowerCase And Trim
    private String username;

    //Trim
    private String password;

    @Enumerated(EnumType.STRING)
    private Classification classification;

    public UserAccess(String username, String password) {
        this.username = username.toLowerCase().trim();
        this.password = password.trim();
    }

    public UserAccess(Long id, String username, String password) {
        this.setId(id);
        this.username = username;
        this.password = password;
    }
}
