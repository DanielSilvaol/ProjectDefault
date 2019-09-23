package br.edu.GEP.Domain.Commands.UsuarioCommand.Inputs;

import br.edu.GEP.Domain.Commands.BaseCommand;
import br.edu.GEP.Domain.Entity.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AtualizaUsuarioCommand implements BaseCommand
{
    public UsuarioEntity UsuarioEntity;
    private String username;
    private String password;

    @Override
    public void configuration()
    {
        this.UsuarioEntity.setLOGIN(this.username == null ? this.UsuarioEntity.getLOGIN() : this.username);
        this.UsuarioEntity.setSENHA(this.password == null ? this.UsuarioEntity.getSENHA() : this.password);
    }
}
