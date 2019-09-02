package br.edu.projectdefault.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroDeFormTO {

    private String campo;
    private String erro;

}
