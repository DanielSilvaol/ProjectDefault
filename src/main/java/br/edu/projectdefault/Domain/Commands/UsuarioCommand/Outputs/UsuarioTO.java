package br.edu.projectdefault.Domain.Commands.UsuarioCommand.Outputs;

import br.edu.projectdefault.Domain.Entity.UsuarioEntity;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioTO {

    private Long ID;
    private String NOME;
    private String LOGIN;
    private String EMAIL ;
    private boolean BLOQUEADO ;
    private String CPF ;


    public UsuarioTO(UsuarioEntity entity) {
        this.ID = entity.getID();
        this.NOME = entity.getNOME();
        this.LOGIN = entity.getLOGIN();
        this.EMAIL = entity.getEMAIL();
        this.BLOQUEADO = entity.isBLOQUEADO();
        this.CPF = entity.getCPF();
    }

    public static List<UsuarioTO> converter(List<UsuarioEntity> users) {

        return users.stream().map(UsuarioTO::new).collect(Collectors.toList());
    }
}
