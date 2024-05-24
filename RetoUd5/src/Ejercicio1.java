import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {

		String nombreArchivo1,nombreArchivo2;
		Scanner sc = new Scanner(System.in); 

		do {
			System.out.print("Introduce el nombre del primer fichero: ");
			nombreArchivo1=sc.next();
			System.out.print("Introduce el nombre del segundo fichero: ");
			nombreArchivo2=sc.next();
		}while(nombreArchivo1.length()<3|| nombreArchivo2.length()<3);
		System.out.println("\nEl nombre del primer archivo es válido.");
		System.out.println("\nEl nombre del segundo archivo es válido.");
		
		
		//Apartado B
		
		String directorioActual=System.getProperty("user.dir");
		System.out.println("\nRuta del directorio actual: "+directorioActual);
	
		
		//Apartado C 
		
		String rutaCompletaFich1 = directorioActual + File.separator + nombreArchivo1; 
		String rutaCompletaFich2 = directorioActual + File.separator + nombreArchivo2; 
		
		if(!comprobarExiste(new File(rutaCompletaFich1))) {
			
			crearFichero(nombreArchivo1);
		}else {
			System.out.println("\nEl fichero "+nombreArchivo1+" ya existe en la ruta actual.");
		}
		
		if(!comprobarExiste(new File(rutaCompletaFich2))) {
			
			crearFichero(nombreArchivo2);
		}else {
			System.out.println("\nEl fichero "+nombreArchivo2+" ya existe en la ruta actual.");
		}
		
		//Apartado E  ------> 
		
		if(comprobarExiste(new File(rutaCompletaFich1))) {
			
			escribirEnFichero(nombreArchivo1);
			System.out.println("\nNúmeros del 0-10 escritos en el fichero: "+nombreArchivo1);
		}
	
		//Apartado F
		
		if(comprobarExiste(new File(rutaCompletaFich1))) {
			
			leerDeFichero(nombreArchivo1);
		}
		
		//Apartado G
		
		if(comprobarExiste(new File(rutaCompletaFich1))) {
			
			mostrarDatosFichero(nombreArchivo1);
			
		}else {
			
			System.out.println("El fichero "+ nombreArchivo1+" no existe.");
		}
		
		//Apartado h
		
		duplicarFicheros(new File(rutaCompletaFich1),new File(rutaCompletaFich2));

		//Apartado I 
		
		borrarFichero(new File(rutaCompletaFich1)); 
		
		//Apartado J 
	
		System.out.println("\nDatos del fichero: "+nombreArchivo2);
		leerDeFichero(nombreArchivo2);

		//Apartado K 
		
		String rutaDirectorio=directorioActual+ File.separator+"dirEjer1";

		if(!comprobarExiste(new File(rutaDirectorio))) {
			
			crearDirectorio(rutaDirectorio);
		}else {
			
			System.out.println("\nEl directorio 'dirEjer1' ya existe en la ruta actual.");
		}
		
	}
		
	
	
	
	
	//metodos 
	
	
	public static void crearFichero(String nombre) {
		
		try {
            File fichero = new File(nombre);
            if (fichero.createNewFile()) {
                System.out.println("El fichero " + nombre + " ha sido creado.");
            } else {
                System.out.println("El fichero " + nombre + " no pudo ser creado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	public static boolean comprobarExiste(File fichero){
		
		return fichero.exists(); 
		
	}

	public static boolean escribirEnFichero(String nombre) {
		
		try(FileWriter file= new FileWriter(nombre)){
			
			for(int i =0;i<=10;i++) {
				
				file.write(String.valueOf(i)+"\n");
			}
			
			return true;
			
		}catch(IOException e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public static boolean leerDeFichero(String nombre) {
		
		try(BufferedReader br=new BufferedReader(new FileReader(nombre))){
			
			String linea;
			
			while((linea=br.readLine())!=null) {
				
				System.out.println(linea);
			}
			return true;
		}catch(IOException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	 public static void mostrarDatosFichero(String nombre) {
	
        File fichero = new File(nombre);
        System.out.println("\nNombre del archivo: " + fichero.getName());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        System.out.println("Ruta del directorio padre: " + fichero.getParent());
        System.out.println("Tamaño del fichero: " + fichero.length() + " bytes");
        System.out.println("¿Es un fichero o un directorio?: " + (fichero.isFile() ? "Fichero" : "Directorio"));
        System.out.println("Permiso de lectura: " + fichero.canRead());
        System.out.println("Permiso de escritura: " + fichero.canWrite());
        System.out.println("Permiso de ejecución: " + fichero.canExecute());
        System.out.println("¿Está oculto?: " + fichero.isHidden());
   }
	
	 public static void duplicarFicheros(File origen,File destino) {
			
			try(FileReader fr=new FileReader(origen);
				BufferedReader br=new BufferedReader(fr);
				FileWriter fw=new FileWriter(destino);
				BufferedWriter bw=new BufferedWriter(fw)){
				
				String linea;
				
				while((linea=br.readLine())!=null) {
					
					bw.write(linea+"\n");
				}
			}catch(IOException e) {
				
				e.printStackTrace();
			}
		}
	
	 public static boolean borrarFichero(File fichero) {
		 
		 if(fichero.delete()) {
				
				System.out.println("\nEl fichero "+fichero.getName()+" ha sido borrado");
				return true;
			}else {
				
				System.out.println("\nEl fichero "+fichero.getName()+" no pudo ser borrado");
				return false;
			}
	 }
	 
	 public static boolean crearDirectorio(String rutaDirectorio) {
	        File directorio = new File(rutaDirectorio);
	        if (directorio.mkdirs()) {
	            System.out.println("\nEl directorio 'dirEjer1' ha sido creado.");
	            return true;
	        } else {
	            System.out.println("\nEl directorio 'dirEjer1' no pudo ser creado.");
	            return false;
	        }
	   }
	 
	 
	 
}
