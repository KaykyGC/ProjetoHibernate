package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="musico")
public class Musico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMusico;
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "idevento")
	private Evento evento;
	
	
	public Integer getIdMusico() {
		return idMusico;
	}

	public void setIdMusico(Integer idMusico) {
		this.idMusico = idMusico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}



}
