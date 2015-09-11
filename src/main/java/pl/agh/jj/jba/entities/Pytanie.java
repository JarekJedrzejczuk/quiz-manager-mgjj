package pl.agh.jj.jba.entities;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="pytanie")
public class Pytanie {
	
	@Id
	@GeneratedValue
	private Integer pytanie_id;
	
	private String pytaniecol;
	private String trescPytania;
	private String informacjaZwrotna;
	
	private Integer maxIloscPunktow;
	private String poprawnaOdpowiedz;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable
	private List<Odpowiedz> odpowiedzi;
	
	@ManyToMany(mappedBy="pytania")
	private List<Quiz> quizy;
	
	private String nazwaPytania;
	
	@Transient
	private Boolean czyUsunac=false;
	 
	public Boolean getCzyUsunac() {
		return czyUsunac;
	}
	public void setCzyUsunac(Boolean czyUsunac) {
		this.czyUsunac = czyUsunac;
	}
	
	public List<Quiz> getQuizy() {
		return quizy;
	}
	public void setQuizy(List<Quiz> quizy) {
		this.quizy = quizy;
	}
	public List<Odpowiedz> getOdpowiedzi() {
		return odpowiedzi;
	}
	public void setOdpowiedzi(List<Odpowiedz> odpowiedzi) {
		this.odpowiedzi = odpowiedzi;
	}
	
	public Integer getPytanie_id() {
		return pytanie_id;
	}
	public void setPytanie_id(Integer pytanie_id) {
		this.pytanie_id = pytanie_id;
	}
	public String getPytaniecol() {
		return pytaniecol;
	}
	public void setPytaniecol(String pytaniecol) {
		this.pytaniecol = pytaniecol;
	}
	public String getNazwaPytania() {
		return nazwaPytania;
	}
	public void setNazwaPytania(String nazwaPytania) {
		this.nazwaPytania = nazwaPytania;
	}
	public String getTrescPytania() {
		return trescPytania;
	}
	public void setTrescPytania(String trescPytania) {
		this.trescPytania = trescPytania;
	}
	public String getInformacjaZwrotna() {
		return informacjaZwrotna;
	}
	public void setInformacjaZwrotna(String informacjaZwrotna) {
		this.informacjaZwrotna = informacjaZwrotna;
	}
	public Integer getMaxIloscPunktow() {
		return maxIloscPunktow;
	}
	public void setMaxIloscPunktow(Integer maxIloscPunktow) {
		this.maxIloscPunktow = maxIloscPunktow;
	}
	public String getPoprawnaOdpowiedz() {
		return poprawnaOdpowiedz;
	}
	public void setPoprawnaOdpowiedz(String poprawnaOdpowiedz) {
		this.poprawnaOdpowiedz = poprawnaOdpowiedz;
	}
	
	

}
