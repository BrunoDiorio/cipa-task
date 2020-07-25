package br.com.cipa.task.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter @Setter @ToString
@MappedSuperclass
public class Users {

	@Id
	private Long id;
	private String externalId;
	private String email;
	private String name;
	private String phone;
	@Type(type = "numeric_boolean")
	private boolean sincronizado;
}
