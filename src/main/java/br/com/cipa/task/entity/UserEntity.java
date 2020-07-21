package br.com.cipa.task.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "")
public class UserEntity {

	@Column(name="ID_ZENDESK")
	private Long idZendesk;
	@Column(name="USER_EXTERNAL_ID")
	private String userExternalId;
	private String email;
	@Column(name = "USERNAME")
	private String nomeUsuario;
	@Column(name = "PHONE")
	private String telefone;
	@Column(name = "CUSTOM_FIELD_SINCRONIZADO", columnDefinition = "INT(1)")
	private boolean sincronizado;
}
