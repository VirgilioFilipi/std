package engtelecom.std.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;

import engtelecom.std.entities.Pessoa;

@Component
public class PessoaService {

    private ArrayList<Pessoa> agenda;
    private AtomicLong contador;

    public PessoaService(){
        this.agenda = new ArrayList<>();
        this.contador = new AtomicLong();    
       }

    public List<Pessoa> buscarTodas(){
        return this.agenda;
    }

    public Pessoa cadastrarPessoa(Pessoa p){

        p.setId(this.contador.incrementAndGet());

        this.agenda.add(p);
        return p;
    }
    
}
