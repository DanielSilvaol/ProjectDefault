package br.edu.projectdefault.Domain.Commands.UsuarioCommand.Outputs;

import lombok.Getter;

@Getter
public class UsuarioLoginCommand
{
    private String username;
    private String password;
}
