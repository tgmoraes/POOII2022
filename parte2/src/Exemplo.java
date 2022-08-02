

public class Exemplo  {
	
	public <T> void printa(T elem) {
		System.out.println(elem);
	}
	public <T, V> boolean mesmoTipo(T obj1, V obj2) {
		return obj1.getClass().equals(obj2.getClass());
		
	}

	public <T extends Number> double inverso(T num) {
		return 1/num.doubleValue();
	}

	public <E extends Comparable<E>> E maior(E a, E b, E c) {
		E max = a;
		if (max.compareTo(b) < 0)
			max = b;
		if (max.compareTo(c) < 0)
			max = c;

		return max;
	}
}	
	
	
	
	









	
//	
//	public <T extends Number> double inverso(T num){
//		return 1/num.doubleValue();
//	}
//	public <E extends Comparable<E>> E maior(E a, E b, E c) {
//		E max = a;
//		if(max.compareTo(b)<0) max = b;
//		if(max.compareTo(c)<0) max = c;
//		
//		return max;
//	}
//}
