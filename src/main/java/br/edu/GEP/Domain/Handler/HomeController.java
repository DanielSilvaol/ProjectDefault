package br.edu.GEP.Domain.Handler;

import br.edu.GEP.Domain.Entity.SistemaEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @RequestMapping("/")
    public SistemaEntity get()
    {
        SistemaEntity sistemaEntity = new SistemaEntity();
        sistemaEntity.setNOME("Teste");
        return sistemaEntity;
    }
}
