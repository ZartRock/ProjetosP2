package lab_02;

/**
* Representação da saúde de universitário voltada para o uso dos estudantes,
* direcionado para alunos de computação, na UFCG.
* 
* @author Áxel Medeiros
*/

public class Saude {
	private String mental;
	private String fisica;
	private String emoji;
	
	
	/**
	   * Constrói a Saude de um aluno, com base em parâmentros iniciais
	   * fixos.
	   * 
	 */
	
	public Saude(){
		this.mental = "boa";
		this.fisica = "boa";
		this.emoji = "";
	}
	
	
	/**
	 * Representa a definição da saude mental de um aluno para um
	 * novo estado.
	 * 
	 * @param estado String que representa essa nova condição do aluno.
	 */
	
	public void defineSaudeMental(String estado) {
		this.mental = estado;
		
	}
	
	/**
	 * Representa a definição da saude física de um aluno para um
	 * novo estado.
	 * 
	 * @param estado String que representa essa nova condição do aluno.
	 */
	
	public void defineSaudeFisica(String estado) {
		this.fisica = estado;
		zerarEmoji();
	}
	
	/**
	 * Representa a definição de um Emoji utilizada pelo aluno para
	 * resumir o seu estado de saúde.
	 * 
	 * @param emoji String que é o novo Emoji a ser atualizado.
	 */
	public void definirEmoji(String emoji){
		this.emoji = emoji;
	}
	
	/**
	 * Representa apagar o emoji que representa o estado de saúde
	 * atual.
	 * 
	 */
	
	public void zerarEmoji(){
		this.emoji = "";
	}
	
	/**
	 * Retorna uma string contendo o resumo da saúde, podendo ter ou
	 * não um emoji.
	 * 
	 * @return String que contem essas informações.
	 */
	
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

}

