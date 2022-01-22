package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@SuppressWarnings("serial") //Este ignora um aviso
@Entity //@Entity diz que a classe vai virar tabela
public class Evento implements Serializable {
	@Id //@Id diz que o atributo, que tem id, ser√° a chave primaria
    // A chave prim·ria vai ser fornecida pelo usuar·rio - n„o vai ser auto-incrementada
    //Column(name="codigoEvento")
	private int idEvento;
	private String nome;
	
	@OneToMany(mappedBy = "evento")
	private List<Musico> musicos;
	
	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Musico> getMusicos() {
		return musicos;
	}

	public void setMusicos(List<Musico> musicos) {
		this.musicos = musicos;
	}
	
	
}