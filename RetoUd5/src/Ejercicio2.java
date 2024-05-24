import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		//Paso a) : Mostrar directorio actual y crear directorio y ficheros

		try {
			
			String directorioActual=System.getProperty("user.dir");
			
			System.out.println("Directorio actual: "+directorioActual);
			
			String rutaDirectorio = directorioActual + File.separator + "dirEjer2";
			
			crearDirYFich(rutaDirectorio);
			
		//Paso b)  Abrir fichero "dos.txt" para excritura
			
			String rutaFicheroDos = rutaDirectorio + File.separator + "dos.txt";
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(rutaFicheroDos));
			
		//Paso c):  Pedir al usuario que introduzca nombres
			
			System.out.println("\nIntroduce nombres de personas (escribe '-' para salir): ");
			
			escribirNombres(writer);
			
			writer.close();
		
					
		//Paso e): Abrir fichero "dos.txt" para lectura y mostrar contenido
			
		leerFichero(rutaFicheroDos);
			
		
		} catch (Exception e) {
			// TODO: handle exception
		}
			
		
	}
			
		//metodos 
		
		public static void crearDirYFich(String rutaDirectorio) throws IOException{
			
			File directorio=new File(rutaDirectorio);
			
			if(!directorio.exists()) {
				
				if(directorio.mkdirs()) {
					
					System.out.println("\nDirectorio 'dirEjer2' creado correctamente.");
				}else {
					
					throw new IOException("Error al crear el directorio 'dirEjer2'");
				}
			}
			
			//Crear fichero "uno.txt"
			
			String rutaFicheroUno = rutaDirectorio + File.separator + "uno.txt";
			
			File ficheroUno = new File(rutaFicheroUno);
			
			if(ficheroUno.createNewFile()) {
				
				System.out.println("\nFichero 'uno.txt' creado corectamente.");
			}else {
				
				System.out.println("\nEl fichero 'uno.txt' ya existe.");
			}
			
			//Crar fichero "dos.txt"
			
			String rutaFicheroDos = rutaDirectorio + File.separator + "dos.txt";
			
			File ficheroDos = new File(rutaFicheroDos);
			
			if(ficheroDos.createNewFile()) {
				
				System.out.println("\nFichero 'dos.txt' creado correctamente.");
			}else {
				
				System.out.println("\nEL fichero 'dos.txt, ya existe.");
			}
		
		}	
			
		public static void escribirNombres(BufferedWriter writer) throws IOException{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			String nombre;
			
			while(true) {
				
				nombre = reader.readLine();
				
				if(nombre.equals("-")) {
					
					break;
				}
				writer.write(nombre);
				writer.newLine();
			}
			reader.close();
		}
		
		public static void leerFichero(String rutaFichero) throws IOException{
			
			BufferedReader reader = new BufferedReader(new FileReader(rutaFichero));
			
			String linea;
			
			System.out.println("\nContenido del fichero 'dos.txt': ");
			
			while((linea = reader.readLine())!=null) {
				
				System.out.println(linea);
			}
			reader.close();
		}
		
		
		
		
		
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

