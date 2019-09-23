package br.edu.GEP.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroDeFormTO {

    private String campo;
    private String erro;

}
