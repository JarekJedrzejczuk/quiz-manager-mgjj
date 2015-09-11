package pl.agh.jj.jba.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	
	@ManyToMany
	@JoinTable
	private List<Pytanie> pytania;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.ALL)
	private List<Kategoria> kategorie;
	
	@OneToMany(mappedBy="quiz", cascade=CascadeType.ALL)
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
	public List<Podejscie> getPodejscie() {
		return podejscie;
	}
	public void setPodejscie(List<Podejscie> podejscie) {
		this.podejscie = podejscie;
	}
	/**
	 * @param q
	 * 
	 * Metoda ustawia puste pola obiektu. Celem tej metody jest ułatwienie ogranieczenia wymainy informacji między widokiem a kontrolerem.
	 * Chodzi o to, żeby nieużywane przez kontroler pola zostały przechowane w pamięci na serwerze.
	 * 
	 */
	public void setNullFields(Quiz q){
		if (this.dostepnyDo==null)
			this.dostepnyDo=q.getDostepnyDo();
		if (this.dostepnyOd==null)
			this.dostepnyOd=q.getDostepnyOd();
		if (this.losowaKolejnosc==null)
			this.losowaKolejnosc=q.getLosowaKolejnosc();
		if (this.kategorie==null)
			this.kategorie=q.getKategorie();
		if (this.limitCzasu==null)
			this.limitCzasu=q.getLimitCzasu();
		if (this.nazwa==null)
			this.nazwa=q.getNazwa();
		if (this.podejscie==null)
			this.podejscie=q.getPodejscie();
		if (this.pytania==null){
			this.pytania=q.getPytania();
			}
	}
	public Kategoria removeKategoria(Kategoria k){
		return this.kategorie.remove(this.kategorie.lastIndexOf(k));
		
	}
	public void deleteKategoria(Kategoria kategoriaDoUsuniecia) {
		if (this.kategorie==null) return;
		this.kategorie.remove(kategoriaDoUsuniecia);
	}
	
}
