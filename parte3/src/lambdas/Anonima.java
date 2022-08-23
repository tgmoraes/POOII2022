package lambdas;
//FORMA 1------ Não utilizar
class Anonima implements Funcional<Integer> {
	@Override
	public Integer doisParaUm(Integer op1, Integer op2) {
		return op1 + op2;
	}
}