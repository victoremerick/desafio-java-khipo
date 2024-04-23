package br.victoremerick.khipoteste.infrastructure.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDTO {
    private String email;

    private String password;

    private String fullName;

}
