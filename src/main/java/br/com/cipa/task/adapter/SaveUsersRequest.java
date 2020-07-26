package br.com.cipa.task.adapter;

import java.util.List;

import br.com.cipa.task.dto.UsersDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveUsersRequest {
	
	private List<UsersDTO> users;
}
