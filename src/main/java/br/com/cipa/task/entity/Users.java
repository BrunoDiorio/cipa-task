package br.com.cipa.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "USERS")
@Getter @Setter
public class Users {

	@Id
	@Column(name="ID_ZENDESK")
	private Long idZendesk;
	@Column(name="USER_EXTERNAL_ID")
	private String userExternalId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "USERNAME")
	private String nomeUsuario;
	@Column(name = "PHONE")
	private String telefone;
	@Column(name = "CUSTOM_FIELD_SINCRONIZADO")
	private boolean sincronizado;
}
