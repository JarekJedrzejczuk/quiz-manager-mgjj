package pl.agh.jj.jba.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="odpowiedz")
public class Odpowiedz {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String tresc;
	
	@ManyToMany(mappedBy="odpowiedzi")
	private List<Pytanie> pytania;
	
	public List<Pytanie> getPytania() {
		return pytania;
	}
	public void setPytania(List<Pytanie> pytania) {
		this.pytania = pytania;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTresc() {
		return tresc;
	}
	public void setTresc(String tresc) {
		this.tresc = tresc;
	}

}
