package br.com.skillup.skillupsoaapi.security.auth;

import lombok.Data;

@Data
public class AuthRequestDTO {

    private String email;
    private String password;
}
