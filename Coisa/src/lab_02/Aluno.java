package lab_02;

import java.util.ArrayList;

/**
* Representação de um estudante matriculado da UFCG, especificamente de
* computação. Todo aluno precisa ter uma matrícula e é identificado unicamente
* por esta matrícula.
*
* @author Áxel Medeiros
*/

public class Aluno {
	private String nome;
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<ContaLaboratorio> contaLaboratorio;
	private ArrayList<ContaCantina> contaCantina;
	private Saude saude;
	
	
	public Aluno(String nome){
		this.nome = nome;
		this.disciplinas = new ArrayList<Disciplina>();
		this.contaLaboratorio = new ArrayList<ContaLaboratorio>();
		this.contaCantina = new ArrayList<ContaCantina>();
		this.saude = new Saude();
		
	}
	
	public void cadastraLaboratorio(String nomeLaboratorio){
		this.contaLaboratorio.add(new ContaLaboratorio(nomeLaboratorio));
	}


	public void cadastraLaboratorio(String nomeLaboratorio, int cota){
		this.contaLaboratorio.add(new ContaLaboratorio(nomeLaboratorio, cota));
		
	}
	
	public void consomeEspaco(String nomeLaboratorio, int mbytes){		
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		this.contaLaboratorio.get(pos).consomeEspaco(mbytes);
	}
	
	
	public void liberaEspaco(String nomeLaboratorio, int mbytes){
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		this.contaLaboratorio.get(pos).liberaEspaco(mbytes);
	}
	
	public boolean atingiuCota(String nomeLaboratorio){
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		return this.contaLaboratorio.get(pos).atingiuCota();
	}
	
	public String laboratorioToString(String nomeLaboratorio){
		int pos = contaLaboratorio.indexOf(new ContaLaboratorio(nomeLaboratorio));
		return this.contaLaboratorio.get(pos).toString();
	}
	
	
	public void cadastraDisciplina(String nomeDisciplina) {
		this.disciplinas.add(new Disciplina(nomeDisciplina));
	}
	
	
	public void cadastraHoras(String nomeDisciplina, int horas) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		this.disciplinas.get(pos).cadastraHoras(horas);
	}
	
	public void cadastraNota(String nomeDisciplina, int nota, double valorNota) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		this.disciplinas.get(pos).cadastraNota(nota, valorNota);
	}
	
	public boolean aprovado(String nomeDisciplina) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		return this.disciplinas.get(pos).aprovado();	
	}
	
	public String disciplinaToString(String nomeDisciplina) {
		int pos = disciplinas.indexOf(new Disciplina(nomeDisciplina));
		return this.disciplinas.get(pos).toString();
	}
	
	
	public void cadastraCantina(String nomeCantina) {
		this.contaCantina.add(new ContaCantina(nomeCantina));
	}
	
	public void cadastraLanche(String nomeCantina, int qtdItens, int valorCentavos) {
		int pos = contaCantina.indexOf(new ContaCantina(nomeCantina));
		this.contaCantina.get(pos).cadastraLanche(qtdItens, valorCentavos);
	}
	
	public void pagarConta(String nomeCantina, int valorCentavos) {
		int pos = contaCantina.indexOf(new ContaCantina(nomeCantina));
		this.contaCantina.get(pos).pagaConta(valorCentavos);
	}
	
	public String cantinaToString(String nomeCantina) {
		int pos = contaCantina.indexOf(new ContaCantina(nomeCantina));
		return this.contaCantina.get(pos).toString();
	}
	
	public void defineSaudeMental(String estado) {
		this.saude.defineSaudeMental(estado);
	}
	public void defineSaudeFisica(String estado) {
		this.saude.defineSaudeFisica(estado);
	}
	
	public String geral() {
		return "Saude: " + this.saude.geral();
	}
	
	@Override
	public String toString(){
		String saida = "";
		saida += this.nome;
		saida += System.lineSeparator();
		saida += geral();
		return saida;
	}
}


