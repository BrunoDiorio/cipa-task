package br.com.cipa.task.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "USERS")
public class UserEntity {

	@Id
	@Column(name="ID_ZENDESK")
	private Long idZendesk;
	@Column(name="USER_EXTERNAL_ID")
	private String userExternalId;
	private String email;
	@Column(name = "USERNAME")
	private String nomeUsuario;
	@Column(name = "PHONE")
	private String telefone;
	@Type(type = "numeric_boolean")
	@Column(name = "CUSTOM_FIELD_SINCRONIZADO")
	private boolean sincronizado;
}
