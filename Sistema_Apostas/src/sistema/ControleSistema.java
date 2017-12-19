package sistema;

import java.util.ArrayList;

public class ControleSistema {

	private ArrayList<Cenario> cenarios;
	private Financas financeiro;


	public ControleSistema(double porcetagemCasa, double caixaAtual){
		this.cenarios = new ArrayList<Cenario>();
		this.financeiro = new Financas(porcetagemCasa, caixaAtual);
	}
	
	public int getCaixaAtual(){ return (int)(this.financeiro.getCaixaAtual()); }
	
	public void cadastrarCenario(String descricaoCenario){
		this.cenarios.add(new Cenario(descricaoCenario));
	}
	
	public int getNumCenario(String descricaoCenario){
		for (int i = 0; i < this.cenarios.size(); i++) {
			if (this.cenarios.get(i).getDescricao().equals(descricaoCenario)) {
				return i;
			}
		}
		
		throw new IndexOutOfBoundsException("Numerador de cenario não existente");
	}
	
	public boolean adicionarApostaCenario(int numFornecidoUsuario, String nomeApostador, double qtnAposta, String previsaoString){
		boolean previsao = true;
	    if(previsaoString.equals("VAI ACONTECER")){
            previsao = true;
        }else if(previsaoString.equals("N VAI ACONTECER")){
            previsao = false;
        } else{
            throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
        }

		String[] mensagensExcecoes = {"Erro no cadastro de aposta: Cenario invalido",
							  		  "Erro no cadastro de aposta: Cenario nao cadastrado"};

	    tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		int numCenario = numFornecidoUsuario - 1;
	    Aposta aposta = new Aposta(nomeApostador, qtnAposta, previsao);

	    this.cenarios.get(numCenario).adicionarAposta(aposta);
		return true;
	}
	
	public String exibirCenario(int numFornecidoUsuario){
		String[] mensagensExcecoes = {"Erro na consulta de cenario: Cenario invalido",
				              "Erro na consulta de cenario: Cenario nao cadastrado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

        int numCenario = numFornecidoUsuario - 1;
	    return this.cenarios.get(numCenario).toString(numFornecidoUsuario);
	}
	
	public String exibirTodosCenarios(){
		String saida = "";
		for (int i = 0; i < this.cenarios.size(); i++) {
			saida += this.cenarios.get(i).toString(i);
		}
		
		return saida;
	}

	public int retornarNumApostaCenario(int numFornecidoUsuario){
		String[] mensagensExcecoes = {"Erro na consulta do total de apostas: Cenario invalido",
							  "Erro na consulta do total de apostas: Cenario nao cadastrado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

		int numCenario = numFornecidoUsuario - 1;
	    return this.cenarios.get(numCenario).getNumApostas();
    }

    public String exibirApostas(int numFornecidoUsuario){
		return this.cenarios.get(numFornecidoUsuario - 1).exibeApostas();
    }

    public int retornarValorTotalApostas(int numFornecidoUsuario){
		String[] mensagensExcecoes = {"Erro na consulta do valor total de apostas: Cenario invalido",
				"Erro na consulta do valor total de apostas: Cenario nao cadastrado"};

		tratarErroSelecionarCenario(numFornecidoUsuario, mensagensExcecoes);

	
	    return (int) this.cenarios.get(numFornecidoUsuario - 1).getValorTotalApostas();
    }

    public int getCaixaCenario(int numFornecidoUsuario){
	    double totalApostas = this.cenarios.get(numFornecidoUsuario - 1).getValorTotalApostas();

	    return (int)(totalApostas * this.financeiro.getPorcetagemCasa());
	}


    public void fecharAposta(int numFornecidoUsuario, boolean ocorreu){
		int numCenario = numFornecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario);
		cenario.setResultadoCenario(ocorreu);
		double valorParaCaixa = cenario.valorRecolhido() * this.financeiro.getPorcetagemCasa();

		this.financeiro.adicionarValorCaixa(valorParaCaixa);
    }


    public int getTotalRateioCenario(int numFonecidoUsuario){
        int numCenario = numFonecidoUsuario - 1;

		Cenario cenario = this.cenarios.get(numCenario - 1);
		return (int) Math.floor((cenario.valorRecolhido() - cenario.valorRecolhido() * financeiro.getPorcetagemCasa()));
	}



	private void tratarErroSelecionarCenario(int numFornecidoUsuario, String[] mensagens){
		tratarErrosCenarioInvalido(numFornecidoUsuario, mensagens[0]);
		tratarErrosCenarioNaoCadastrado(numFornecidoUsuario, mensagens[1]);
	}


	private void tratarErrosCenarioInvalido(int numFornecidoUsuario, String mensagem){
		if (numFornecidoUsuario < 1){
			throw new IllegalArgumentException(mensagem);
		}
	}

	private void tratarErrosCenarioNaoCadastrado(int numFornecidoUsuario, String mensagem){
		if (numFornecidoUsuario > this.cenarios.size()){
			throw new IllegalArgumentException(mensagem);
		}
	}
}
