package br.edu.ifrs.osorio.parte5TesteFXmaven.model;

import java.util.stream.Stream;

public enum Urgencia {
	MUITO_BAIXA(1), BAIXA(2), MEDIA(3), ALTA(4), MUITO_ALTA(5);

	public int value;

	private Urgencia(int i) {
		this.value = i;
	}

	public static Urgencia getType(int codigo) {
		for (Urgencia type : Urgencia.values()) {
			if (type.value == codigo) {
				return type;
			}
		}

		throw new IllegalArgumentException("valor deve ser entre 1 e 5");
	}
	
	public static Urgencia getUrgencia(String urgencia) {
		return Stream.of(Urgencia.values())
			.filter(urg -> urg.toString().equals(urgencia))
			.findFirst().orElseThrow(()-> new IllegalArgumentException("urgencia invalida"));
	}
}
