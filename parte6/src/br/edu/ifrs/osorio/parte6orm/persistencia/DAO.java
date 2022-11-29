package br.edu.ifrs.osorio.parte6orm.persistencia;

import java.util.List;

public interface DAO <T> {
	public void inserir(T obj);
	public List<T> listar(int limit, int offset);
	public void deletar(int id);
	public T buscar(int id);
	public void alterar(T obj);
}
