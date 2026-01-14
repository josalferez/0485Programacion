public class EjemploFor {
	public static void main(String[] args) {
		int i = 0;
		
		System.out.println("Entro al for");
		for (i = 1; i < 11; i++) {
			System.out.println("NUMERO: " + i);
		}
		
		System.out.println("");
		System.out.println("Entro al while");
		i = 1;
		while (i<11){
			System.out.println("NUMERO: " + i);
			i++;
		}


		System.out.println("");
		System.out.println("Entro al do-while");
		i = 1;
		do{
			System.out.println("NUMERO: " + i);
			i++;
		}while (i<11);		
	}
}