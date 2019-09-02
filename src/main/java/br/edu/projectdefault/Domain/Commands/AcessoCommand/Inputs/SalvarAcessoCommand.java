package br.edu.projectdefault.Domain.Commands.AcessoCommand.Inputs;

import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalvarAcessoCommand
{
    public String tipo;
    public UsuarioEntity entity;

}
