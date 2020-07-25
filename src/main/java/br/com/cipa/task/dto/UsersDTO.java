package br.com.cipa.task.dto;


import br.com.cipa.task.entity.Users;
import org.hibernate.annotations.Type;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "USERS")
@AttributeOverrides({
        @AttributeOverride(name = "id",           column = @Column(name = "ID_ZENDESK")),
        @AttributeOverride(name = "externalId",   column = @Column(name = "USER_EXTERNAL_ID")),
        @AttributeOverride(name = "name",         column = @Column(name = "USERNAME")),
        @AttributeOverride(name = "sincronizado", column = @Column(name = "CUSTOM_FIELD_SINCRONIZADO")),
})
public class UsersDTO extends Users {

}