package ir.webapp.springprojectapi.model.entity;

import ir.webapp.springprojectapi.model.entity.base.BaseEntity;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@Builder
@NoArgsConstructor

@Entity(name = "UserAccessEntity")
@Table(name = "UserAccessTable")
public class UserAccess extends BaseEntity {


    //LowerCase And Trim
    private String username;

    //Trim
    private String password;

    public UserAccess(String username, String password) {
        this.username = username.toLowerCase().trim();
        this.password = password.trim();
    }

    public UserAccess(Long id, String username, String password) {
        this.setId(id);
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAccess{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
