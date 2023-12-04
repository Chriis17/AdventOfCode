import java.io.*;
public class Day1 {

	public static void main(String[] args) {
        String nome = "testoDay1";
        try {
            // apre il file in lettura
            FileReader filein = new FileReader(nome + ".txt");
            String num="";
            int next,cont=0,somma=0;
        	String numero;
            do {
                next = filein.read(); // legge il prossimo carattere
                
                if (next != -1) { // se non e' finito il file
                    char nextc = (char) next;
                    if(nextc!='\n') {
                    	if(nextc=='0' ||nextc=='1' ||nextc=='2' ||nextc=='3' ||nextc=='4' ||nextc=='5' ||nextc=='6' ||nextc=='7' ||nextc=='8' ||nextc=='9') {
	                    	cont++;
	                    	num+=nextc;
                    	}
                    }
                    else {
                    	if(cont>0) {
                    		numero=num.charAt(0)+""+num.charAt(cont-1)+"";
	                    	somma+= Integer.parseInt(numero);
	                    	num="";
	                    	cont=0;
                    	}
                    }
                }

            } while (next != -1);
            
            filein.close(); // chiude il file
            System.out.println("La somma totale è "+somma);
        } catch (IOException e) {
            System.out.println(e);
        }
	}
}
