import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Day4 {

	public static void main(String[] args) {
		String nome = "testoDay4";
        try {
            // apre il file in lettura
            FileReader filein = new FileReader(nome + ".txt");
            int next,i=0,i1=0,pot=-1,tot=0;
            boolean duePunti=false,riga=false;
            String nVincenti[],nTuoi[],tuoiNum="",vincNum="";
            
            nVincenti= new String [10];
            nTuoi= new String [25];
            
            do {
                next = filein.read(); // legge il prossimo carattere
                
                if (next != -1) { // se non e' finito il file
                    char nextc = (char) next;
                    if(nextc!='\n') {
                    	if(nextc==':') {
                    		duePunti=true;
                    	}
                    	if(nextc=='|') {
                    		riga=true;
                    	}
                    	if(!riga && duePunti) {
                    		if(nextc=='0' ||nextc=='1' ||nextc=='2' ||nextc=='3' ||nextc=='4' ||nextc=='5' ||nextc=='6' ||nextc=='7' ||nextc=='8' ||nextc=='9') {
                    			vincNum+=nextc+"";
                    		}
                    		else if(nextc==' ' && !vincNum.equals("")) {
                    			nVincenti[i]=vincNum;
                    			vincNum="";
                    			if(nVincenti[i]!=null) {
                    				i++;
                    			}
                    		}
                    	}
                    	else if(riga && duePunti) {
                    		if(nextc=='0' ||nextc=='1' ||nextc=='2' ||nextc=='3' ||nextc=='4' ||nextc=='5' ||nextc=='6' ||nextc=='7' ||nextc=='8' ||nextc=='9') {
                    			tuoiNum+=nextc+"";
                    		}
                    		else if(nextc==' ' && !tuoiNum.equals("")) {
                    			nTuoi[i1]=tuoiNum;
                    			tuoiNum="";
                    			if(nTuoi[i1]!=null) {
                    				i1++;
                    			}
                    		}
                    	}
                    }
                    else {
                    	nTuoi[i1]=tuoiNum;
                    	for(int c=0;c<nVincenti.length;c++) {
                    		for(int z=0;z<nTuoi.length;z++) {
                    			if(nVincenti[c].equals(nTuoi[z])) {
                    				pot++;
                    			}
                    		}
                    	}
                    	tot+=Math.pow(2, pot);
                    	i=0;
                    	i1=0;
                    	nVincenti = new String[10];
                    	nTuoi= new String [25];
                    	pot=-1;
                    	tuoiNum="";
                    	duePunti=false;
                    	riga=false;
                    }
                }
            } while (next != -1);
            System.out.println(tot);
            filein.close(); // chiude il file
        } catch (IOException e) {
            System.out.println(e);
        }

	}

}
