package br.com.cipa.task.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Identity {
    private Long id;
    private Long userId;
    private boolean primary;
    private String value;
    private String type;
}
