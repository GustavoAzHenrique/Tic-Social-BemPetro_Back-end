package br.com.ticsocial.bemPetro.dtos;

import javax.validation.constraints.NotNull;

public class InstituicaoEnsinoDTO {
	@NotNull
    private String nome;
    
    public InstituicaoEnsinoDTO() {
		super();
	}
    
    public InstituicaoEnsinoDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
