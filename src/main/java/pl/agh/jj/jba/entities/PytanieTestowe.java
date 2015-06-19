package pl.agh.jj.jba.entities;

import java.util.Random;

public class PytanieTestowe {
	private Pytanie pytanie;
	private String tresc;
	private String udzielonaOdpowiedz;
	private String[] odpowiedzi;
	private Integer idxPrawidlowejOdp;
	private Integer idxUdzielonejOdp;
	private Integer zdobytePunkty;
	public PytanieTestowe(Pytanie p){
		this.udzielonaOdpowiedz="@#$%^&*";
		this.idxUdzielonejOdp=10000;
		this.zdobytePunkty=0;
		this.pytanie=p;
		this.tresc=p.getTrescPytania();
		Integer n=0;
				n=p.getOdpowiedzi().size();
		String[] o=new String[n+1];
		Random r= new Random();
		if(n!=0)
			n=r.nextInt(n)+1;
		o[n]=p.getPoprawnaOdpowiedz();
		this.idxPrawidlowejOdp=n;
		int i=0;
		for(Odpowiedz odp: p.getOdpowiedzi()){
			if(i==n){
				i++;
			}
			o[i]=odp.getTresc();
			i++;
		}
		this.odpowiedzi=o;
	}
	public Integer sprawdzOdpowiedz(Integer idx){
		Integer wynik=0;
		if(this.idxPrawidlowejOdp==idx)
			wynik=pytanie.getMaxIloscPunktow();
		return wynik;
	}
	public Integer sprawdzOdpowiedz(String odp){
		Integer wynik=0;
		if(this.pytanie.getPoprawnaOdpowiedz()==odp)
			wynik=pytanie.getMaxIloscPunktow();
		return wynik;
	}
	public Integer sprawdzOdpowiedz(Odpowiedz odp){
		Integer wynik=0;
		if(this.pytanie.getPoprawnaOdpowiedz()==odp.getTresc())
			wynik=pytanie.getMaxIloscPunktow();
		return wynik;
	}
	public Pytanie getPytanie() {
		return pytanie;
	}
	public String getTresc() {
		return tresc;
	}
	public String[] getOdpowiedzi() {
		return odpowiedzi;
	}
	public Integer getIdxPrawidlowejOdp() {
		return idxPrawidlowejOdp;
	}
	public String getUdzielonaOdpowiedz() {
		return udzielonaOdpowiedz;
	}
	public void setUdzielonaOdpowiedz(String udzielonaOdpowiedz) {
		if(udzielonaOdpowiedz==this.pytanie.getPoprawnaOdpowiedz()){
			this.idxUdzielonejOdp=this.idxPrawidlowejOdp;
			this.zdobytePunkty=this.pytanie.getMaxIloscPunktow();
		}
			
		this.udzielonaOdpowiedz = udzielonaOdpowiedz;
	}
	public Integer getIdxUdzielonejOdp() {
		return idxUdzielonejOdp;
	}
	public void setIdxUdzielonejOdp(Integer idxUdzielonejOdp) {
		if(this.idxPrawidlowejOdp==idxUdzielonejOdp){
			this.udzielonaOdpowiedz=this.pytanie.getPoprawnaOdpowiedz();
			this.zdobytePunkty=this.pytanie.getMaxIloscPunktow();
		}
		this.idxUdzielonejOdp = idxUdzielonejOdp;
	}
	public Integer getZdobytePunkty() {
		if(this.zdobytePunkty==0){
			if(this.idxPrawidlowejOdp==idxUdzielonejOdp){
				this.zdobytePunkty=this.pytanie.getMaxIloscPunktow();
			}
			if(this.pytanie.getPoprawnaOdpowiedz().contentEquals(udzielonaOdpowiedz)){
				this.zdobytePunkty=this.pytanie.getMaxIloscPunktow();
			}
		
		}
		return this.zdobytePunkty;
	}
	public void setZdobytePunkty(Integer zdobytePunkty) {
		this.zdobytePunkty = zdobytePunkty;
	}
	
}
