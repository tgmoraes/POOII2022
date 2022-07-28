import java.time.LocalDate;
import java.util.Objects;

public class Jogo implements Comparable<Jogo> {
	private final String nome;
	private final String empresa;
	private final LocalDate dataLancamento; // o passado!
	// construtor
	public Jogo(String nome, String empresa, LocalDate dataLancamento) {
		//validacoes:
		Objects.requireNonNull(nome, "Nome não deve ser nulo");
		Objects.requireNonNull(empresa, "Empresa não deve ser nulo");
		Objects.requireNonNull(dataLancamento, "Data de Lançamento não deve ser nulo");

		if(dataLancamento.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("Data lançamento não deve ser posterior a hoje");
		
		this.nome = nome;
		this.empresa = empresa;
		this.dataLancamento = dataLancamento;
	}

	// getters setters
	public String getNome() {
		return nome;
	}
	public String getEmpresa() {
		return empresa;
	}
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Jogo)) return false;
		if(this==o) return true;
		Jogo j = (Jogo)o;
		return 	j.empresa.equals(this.empresa) && 
				j.nome.equals(this.nome) &&
				j.dataLancamento.equals(this.dataLancamento);
	}
	@Override
	public String toString() {
		return this.nome + " ("+this.dataLancamento.getDayOfMonth()+"/"+
				this.dataLancamento.getMonthValue()+"/"+
				this.dataLancamento.getYear()+") - empresa:"+
				this.empresa+"\n";
	}

	@Override
	public int compareTo(Jogo jogo) {
		// TODO Auto-generated method stub
		int ret = this.dataLancamento.compareTo(jogo.dataLancamento);
		if(ret==0) ret = this.nome.compareTo(jogo.nome);
		return ret;
	}

	public String paraCSV() {
		return (this.nome + ";" + 
				this.empresa + ";" + 
				this.dataLancamento.getDayOfMonth() + "/" 
				+ this.dataLancamento.getMonthValue() + "/" 
				+ this.getDataLancamento().getYear() );
	}

	
}
