package br.com.ticsocial.bemPetro.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstituicaoEnsino {
    @Id
    @Column(name = "ins_cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ins_tx_nome")
    private String nome;

    @Column(name = "ins_bl_ativo")
    private Boolean ativo;

    @Column(name = "ins_dt_cadastro")
    private LocalDate dataCadastro;

    @Column(name = "ins_dt_atualizacao")
    private LocalDate dataAtualizacao;

    @JsonIgnore
    @OneToMany(mappedBy = "instituicaoEnsino")
    private List<Pessoa> pessoa;

    public InstituicaoEnsino() {
        super();
    }

    public InstituicaoEnsino(Integer id, String nome, Boolean ativo, LocalDate dataCadastro, LocalDate dataAtualizacao,
            List<Pessoa> pessoa) {
        super();
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.pessoa = pessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

}
