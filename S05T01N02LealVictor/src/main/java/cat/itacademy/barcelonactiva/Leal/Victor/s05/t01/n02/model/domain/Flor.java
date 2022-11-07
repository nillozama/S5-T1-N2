package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="flors")
public class Flor {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int pk_FlorID;
	@Column (name="nom")
	private String nomFlor;
	@Column (name="pais")
	private String paisFlor;
	

	public int getPk_FlorID() {
		return pk_FlorID;
	}
	public void setPk_FlorID(int pk_FlorID) {
		this.pk_FlorID = pk_FlorID;
	}
	public String getNomFlor() {
		return nomFlor;
	}
	public void setNomFlor(String nomFlor) {
		this.nomFlor = nomFlor;
	}
	public String getPaisFlor() {
		return paisFlor;
	}
	public void setPaisFlor(String paisFlor) {
		this.paisFlor = paisFlor;
	}
}
