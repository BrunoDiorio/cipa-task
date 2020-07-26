package br.com.cipa.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Getter @Setter @ToString
@MappedSuperclass
public class Users {

	@Id
	private Long id;
	private String externalId;
	private String email;
	private String name;
	private String phone;
	@JsonIgnore
	private boolean sincronizado;

	public void wasSync() {
		this.sincronizado = true;
	}

	@JsonView
	public List<Identity> identities() {
		List<Identity> list = new ArrayList<>();
		list.addAll(this.normalizeIdentities(this.email.split(","), "email"));
		list.addAll(this.normalizeIdentities(this.email.split(","), "phone_number"));
		return list;
	}

	private List<Identity> normalizeIdentities(final String[] list, final String type) {
		AtomicInteger i = new AtomicInteger();
		return Arrays.stream(list)
				.map(s -> {
					Identity identity = new Identity();
					identity.setType(type);//phone_number
					identity.setPrimary(i.getAndIncrement() == 0);
					identity.setValue(s);
					identity.setId(id);
					return identity;
				}).collect(Collectors.toList());
	}
}
