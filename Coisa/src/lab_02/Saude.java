package lab_02;

public class Saude {
	private String mental;
	private String fisica;
	private String emoji;
	
	
	
	public String getMental() {
		return mental;
	}
	public void setMental(String mental) {
		this.mental = mental;
	}
	public String getFisica() {
		return fisica;
	}
	public void setFisica(String fisica) {
		this.fisica = fisica;
	}
	public String getEmoji() {
		return emoji;
	}
	public void setEmoji(String emoji) {
		this.emoji = emoji;
	}
	
	public Saude(){
		this.mental = "boa";
		this.fisica = "boa";
		this.emoji = "";
	}
	
	public void defineSaudeMental(String estado) {
		this.mental = estado;
		
	}

	public void defineSaudeFisica(String estado) {
		this.fisica = estado;
		zerarEmoji();
	}
	

	public String geral() {
		if(emoji != "") {
			if (this.mental.equals("boa") && this.fisica.equals("boa")) {
				return "boa " + emoji;
			} else if(this.mental.equals("boa") || this.fisica.equals("boa")){
				return "ok " + emoji;
			} else {
				return "fraca " + emoji;
			}
		}else {
			if (this.mental.equals("boa") && this.fisica.equals("boa")) {
				return "boa";
			} else if(this.mental.equals("boa") || this.fisica.equals("boa")){
				return "ok";
			} else {
				return "fraca";
			}
		}
		
	}
	
	public void definirEmoji(String emoji){
		this.emoji = emoji;
	}
	
	public void zerarEmoji(){
		this.emoji = "";
	}

}

