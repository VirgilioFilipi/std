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
        // adicionando algumas pessoas para facilitar os testes
        this.cadastrarPessoa(new Pessoa(null, "João", "juca@"));
        this.cadastrarPessoa(new Pessoa(null, "Maria", "ana@aluno"));
            
       }

    public List<Pessoa> buscarTodas(){
        return this.agenda;
    }

    public Pessoa cadastrarPessoa(Pessoa p){

        p.setId(this.contador.incrementAndGet());

        this.agenda.add(p);
        return p;
    }

    public Pessoa buscarPorId(Long id) {
        for (Pessoa p : agenda){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    
public Pessoa atualizar(Pessoa pessoa) {
Pessoa p = buscarPorId(pessoa.getId());
if (p != null) {
p.setNome(pessoa.getNome());

}
return p;
}
public boolean excluir(Long id) {
Pessoa p = buscarPorId(id);
if (p != null) {
this.agenda.remove(p);
return true;
}
return false;
}
}
