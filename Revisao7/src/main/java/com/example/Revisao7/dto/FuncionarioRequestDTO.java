package com.example.Revisao7.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {
    @NotBlank(message = "O nome é Obrigatório")
    @Size(max = 200, message = "O nome deve ter menos de 200 caracteres.")
    private String nome;

    @NotBlank(message = "O email é Obrigatório")
    @Email(message = "Deve ser um email valido")
    private String email;

    @NotBlank(message = "A senha é Obrigatório")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.")
    @Size(max = 12, message = "A Senha deve ter no mínimo 12 caracteres.")
    private String senha;

    @NotBlank(message = "O telefone é Obrigatório")
    @Size(min = 10, max = 13, message = "O telefone deve ter entre 10 e 13 digitos.")
    private String telefone;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String email, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    public @NotBlank(message = "O nome é Obrigatório") @Size(max = 200, message = "O nome deve ter menos de 200 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é Obrigatório") @Size(max = 200, message = "O nome deve ter menos de 200 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O email é Obrigatório") @Email(message = "Deve ser um email valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é Obrigatório") @Email(message = "Deve ser um email valido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é Obrigatório") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.") @Size(max = 12, message = "A Senha deve ter no mínimo 12 caracteres.") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é Obrigatório") @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres.") @Size(max = 12, message = "A Senha deve ter no mínimo 12 caracteres.") String senha) {
        this.senha = senha;
    }

    public @NotBlank(message = "O telefone é Obrigatório") @Size(min = 10, max = 13, message = "O telefone deve ter entre 10 e 13 digitos.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é Obrigatório") @Size(min = 10, max = 13, message = "O telefone deve ter entre 10 e 13 digitos.") String telefone) {
        this.telefone = telefone;
    }
}
