import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;






/**
 *
 * @author Aimelibers
 */
public class Ejercicio_1 {
    
     private int contador = 0, tope = 22;
     private ArrayList<Integer> numbers = new ArrayList<>(tope);
     String dato_1[][]=new String[22][3];
     
     public Ejercicio_1(){
         
     }
     
        /**
     * Método para cargar el Archivo con la información de la tabla
     * @param archivo File
     * @param alumnos
     * @return booleano, falso= hubo un error, true= cargado correctamente
     */
    protected String[][] cargarArchivo(File archivo,Datos alumnos[]){
        
        /**JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int resultado = fc.showSaveDialog(this);
        if (resultado == JFileChooser.CANCEL_OPTION){
            return;
            * 
        }
        File archivo = fc.getSelectedFile(); //A la variable archivo se le asigna el archivo seleccionado
        **/
        int contador_carga=0;
        
        try { //Por si hay errores no se detenga el programa
            FileReader fr = new FileReader(archivo); 
            BufferedReader bf = new BufferedReader(fr); //Cargar todo en memoria
            System.out.println("1");
            String linea;
            linea = bf.readLine(); //Cada línea se asigna a la cadena
            String[] lista = new String [3]; //Arreglo para cargar cada línea de la tabla
            System.out.println("1");
            while (linea!=null){ //Repetir hasta que las filas sean nulas
                StringTokenizer st = new StringTokenizer(linea, ","); //Porque cada columna está dividida por coma
                 lista[0]= st.nextToken();
                lista[1]= st.nextToken();
                lista[2]=st.nextToken();
                dato_1[contador_carga][0]=lista[0];
                dato_1[contador_carga][1]=lista[1];
                dato_1[contador_carga][2]=lista[2];
               
		contador_carga++;
                linea = bf.readLine();
                
            }
            bf.close();
            return dato_1;
        } catch (IOException | NumberFormatException e) { //Si hubo errores manda mensaje
            
            return null;
        }
         
    }
    public boolean guardar_datos(File archivo,String datos[][]){
        
    try{//Metodo utilizado por si hay algun error en el proceso
        FileWriter fw=new FileWriter(archivo);//Se instancia un objeto para una lectura de archivo
        PrintWriter pw=new PrintWriter(fw);//Y lo escribe, el como lo va a a escribir
            for(int i=0;i<22;i++){//Se va a leer todos los datos para poder leer el archivo
                for(int x=0;x<3;x++){
                    pw.print(datos[i][x]+",");//Lo escribe y lo separa por comas
                }
                pw.println();//Salto de fila
            }
            pw.close();//Se cierra la escritura
            return true;
    }catch(HeadlessException e){
        return false;
    }
    }
    
      public String elegir_al_azar(Datos alumnos[]){
          while(alumnos[numbers.get(contador)].isControl()==true){
              contador++;
        if(contador==tope){
            Collections.shuffle(numbers);
            contador=0;
            for(int i=0;i<tope;i++){
                alumnos[i].setControl(false);
            }
        }
        
          }
          alumnos[numbers.get(contador)].setControl(true);
        
        return alumnos[numbers.get(contador)].getNombre();
          
    }
    
    /**
     * PONER PRIMERO EN EL MAIN
     * Método para inicializar la lista de números al azar
     */
    public void inicializarArrayList(){
        for (int i=1;i<tope;i++){
                numbers.add(i);
        }
        Collections.shuffle(numbers);
    }
    
    
    
    
    
    
   /**
     * Método para validar si el número es tipo flotante o no, independientemente de la presencia del punto o no
     * @param cadena tipo String
     * @return tipo boolean, true= número flotante, false= no flotante
     */
    public boolean esNumentero(String cadena){
        try { //Intenta convertirlo a doble y si no hay error retorna verdadero
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e){ //Si sí hay error retorna falso
            return false;
        }
    }
    /**
     * Metodo para validar si solo tiene caracteres (Acepta acentos)
     * @param cadena String
     * @return entero
     * Si regresa 1 todos son caracteres y si regresa 0 incluye numeros y caracteres especiales
     */
        public int tieneNumConEspacio(String cadena){//Método para validar números y espacios
        int b=5;
        for(int i=0; i<cadena.length(); i++){
            int a= cadena.charAt(i);
            if(((a<91)&&(a>64))||((a<123)&&(a>96))||(a==193)||(a==201)||(a==205)||(a==211)||(a==218)||(a==225)||(a==233)||(a==237)||(a==243)||(a==250)||(a==32)){
                b=1; //Es letra
            } else {
                b=0; //Tiene un número
                break;
            }
        }//Cerrar ciclo for
        return b;
    }
        
   
    
    
   
    
}
