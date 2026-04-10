public class sensorTemperatura{
	public static void main(String[] args){
		int temperaturas[] = {-5,10,5,10,20,15,5,0};
		
		imprimoArray(temperaturas);
		encontrarTemperaturaFrecuente(temperaturas);
	}
	
	public static int encontrarTemperaturaFrecuente(int[] temperaturas){
		
		int[][] temp = new int[2][8];
		boolean estaArray = false;
		int contadorTemp = 0;
		
		// Meto en otro array las temperaturas no repetidas
		for(int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++){
				if (temperaturas[i] == temp[i][j] ){ 
					estaArray = true;
					break;
				}
			}
			if (!estaArray){
				temp[i][contadorTemp] = temperaturas[i];
				contadorTemp++;
			}
		}
		System.out.println();
		imprimoArray(temp);
		return 0;
	}
	
	public static void imprimoArray(int[] array){
		for(int i = 0; i < 8; i++){
			System.out.print(array[i] + " ");
		}
	}
}