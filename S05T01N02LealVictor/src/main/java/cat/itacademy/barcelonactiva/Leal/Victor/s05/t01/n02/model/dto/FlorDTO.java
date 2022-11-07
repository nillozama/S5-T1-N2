package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n02.model.dto;

import java.util.Arrays;
import java.util.List;

public class FlorDTO {
	
	private int pk_FlorID;
	private String nomFlor;
	private String paisFlor;
	private String tipusFlor;
	private List<String> europeanCountryList=Arrays.asList("ALEMANIA", "BELGICA", "CROACIA", "DINAMARCA", "ESPAÑA", "FRANCIA",
			"IRLANDA", "LETONIA", "LUXEBURGO", "PAISES BAJOS", "SUECIA",
			"BULGARIA", "ESLOVENIA", "ESTONIA", "GRECIA", "MALTA", "POLONIA", "REPUBLICA CHECA",
			"AUSTRIA", "CHIPRE", "ESLOVENIA", "FINLANDIA", "HUNGRIA", "ITALIA", "LITUANIA", "PORTUGAL", "RUMANIA");
	
	public FlorDTO() {
		
	}

	public FlorDTO(int pk_FlorID, String nomFlor, String paisFlor) {
		super();
		this.pk_FlorID = pk_FlorID;
		this.nomFlor = nomFlor;
		this.paisFlor = paisFlor;
		tipusFlor=getTipusFlor();
	}
	


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

	public String getTipusFlor() {

		return europeanCountryList.contains(paisFlor.toUpperCase())?"EU":"Not EU";
	}

	
	
	@Override
	public String toString() {
		return "FlorDTO [pk_FlorID=" + pk_FlorID + ", nomFlor=" + nomFlor + ", paisFlor=" + paisFlor + ", tipusFlor="
				+ tipusFlor + ", europeanCountryList=" + europeanCountryList + "]";
	}
}
