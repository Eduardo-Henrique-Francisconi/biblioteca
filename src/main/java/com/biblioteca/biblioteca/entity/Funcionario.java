package com.biblioteca.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório.")
    @Pattern(regexp = "^(?!.*\\s{2,})[A-Za-zÀ-ÖØ-öø-ÿ]{2,}(\\s[A-Za-zÀ-ÖØ-öø-ÿ]+)+$", message = "O nome deve conter pelo menos 2 palavras.")
    private String nome;

    @NotNull(message = "A idade é obrigatória.")
    @Positive(message = "A idade não pode ser negativa.")
    private Integer idade;

    @Email(message = "O email deve ser válido.")
    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @Pattern(regexp = "^\\d{11}$", message = "O CPF deve ser válido.")
    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;

    @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "O CEP deve ser válido.")
    @NotBlank(message = "O CEP é obrigatório.")
    private String cep;

    @NotBlank(message = "O endereço é obrigatório.")
    private String endereco;

    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "O telefone deve ser válido.")
    @NotBlank(message = "O telefone é obrigatório.")
    private String telefone;
}

