package pl.agh.jj.jba.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="quiz")
public class Quiz {
	@Id
	@GeneratedValue
	private Integer quiz_id;
	private String nazwa;
	private Boolean losowaKolejnosc;
	private Integer limitCzasu;
	private Date dostepnyOd;
	private Date dostepnyDo;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable
	private List<Pytanie> pytania;
	
	
	@OneToMany(mappedBy="quiz")
	private List<Kategoria> kategorie;
	
	@OneToMany(mappedBy="quiz")
	private List<Podejscie> podejscie;
	
	
	public List<Kategoria> getKategorie() {
		return kategorie;
	}
	public void setKategorie(List<Kategoria> kategorie) {
		this.kategorie = kategorie;
	}

	
	public Integer getQuiz_id() {
		return quiz_id;
	}
	public void setQuiz_id(Integer quiz_id) {
		this.quiz_id = quiz_id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public Boolean getLosowaKolejnosc() {
		return losowaKolejnosc;
	}
	public void setLosowaKolejnosc(Boolean losowaKolejnosc) {
		this.losowaKolejnosc = losowaKolejnosc;
	}
	public Integer getLimitCzasu() {
		return limitCzasu;
	}
	public void setLimitCzasu(Integer limitCzasu) {
		this.limitCzasu = limitCzasu;
	}
	public Date getDostepnyOd() {
		return dostepnyOd;
	}
	public void setDostepnyOd(Date dostepnyOd) {
		this.dostepnyOd = dostepnyOd;
	}
	public Date getDostepnyDo() {
		return dostepnyDo;
	}
	public void setDostepnyDo(Date dostepnyDo) {
		this.dostepnyDo = dostepnyDo;
	}
	public List<Pytanie> getPytania() {
		return pytania;
	}
	public void setPytania(List<Pytanie> pytania) {
		this.pytania = pytania;
	}
	
	
	
	
}
