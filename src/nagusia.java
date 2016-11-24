import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class nagusia {
	
	
	public static void main(String [] args) throws IOException{
		
		LinkedList<Necesidad> RetoL = new LinkedList<Necesidad>();
		LinkedList<Alumno> AlumnoL = new LinkedList<Alumno>();
		LinkedList<Centro> CentroL = new LinkedList<Centro>();
		
		BufferedReader br = new BufferedReader(new FileReader("taldeFormatua.txt"));
		StringBuilder sb = new StringBuilder();
	    String line;
	    
	    int tamañoGrupo = Integer.parseInt(br.readLine());
	    
	    while((line = br.readLine()) != "ALUMNOS"){
	    	Centro aux = new Centro(line);
	    	CentroL.add(aux);
	    }
	    
	    while((line = br.readLine()) != "RETOS"){
	        String[] ikasleData = line.split(";");
	        boolean eusk = Boolean.parseBoolean(ikasleData[3]);
	        Alumno aux = new Alumno(ikasleData[0],ikasleData[1],ikasleData[2], eusk);
	        for(int i=0; i<CentroL.size(); i++){
	        	if(CentroL.get(i).nombre.equals(aux.centro)){
	        		CentroL.get(i).anadirAlumno(aux);
	        	}
	        }
	        AlumnoL.add(aux);
	    }
	    
	    int auxKont = 0;
	    while((line = br.readLine()) != null){
	    	String[] NecesiData = line.split(";");
	        boolean eusk = Boolean.parseBoolean(NecesiData[1]);
	    	Necesidad aux = new Necesidad(auxKont,NecesiData[0],eusk);
	    	RetoL.add(aux);
	    	auxKont++;
	    }
	    
	    for(int i=0; i<CentroL.size(); i++){
	    	CentroL.get(i).calcularExito();
	    }
		int atalasea = (CentroL.size())/2;
		int gruposLlenos = 0;
		int alumnosMetidos = 0;
		
		for(int nLoop=0; nLoop<100; nLoop++){	
		for(int i=0; i<CentroL.size(); i++){
			
			int Ret = CentroL.get(i).retoMenosPopular();
			int maxPunt = (RetoL.size()+1);
			int whatAlumn = -1;
			
			for(int j=0; j<CentroL.get(i).nAlumnos; j++){
				if((CentroL.get(i).getAlumnos()[j].getPreferencias()[Ret] < maxPunt) & (CentroL.get(i).getAlumnos()[j].getPreferencias()[Ret] < atalasea)){
					maxPunt = CentroL.get(i).getAlumnos()[j].getPreferencias()[Ret];
					whatAlumn = j;
				}
			}
			
			if((RetoL.get(Ret).nAlumnos < tamañoGrupo) & (whatAlumn > -1)){
				RetoL.get(Ret).anadirAlumno(CentroL.get(i).getAlumnos()[whatAlumn]);
				if(RetoL.get(Ret).nAlumnos == tamañoGrupo){gruposLlenos++;}
				CentroL.get(i).eliminarAlumno(whatAlumn);
				alumnosMetidos++;	
			}
			
			CentroL.get(i).exito[Ret] = -100;
			if(alumnosMetidos == AlumnoL.size()){break;}
		}
		if(alumnosMetidos == AlumnoL.size()){break;}
		}
		
		
		for(int i=0; i<8; i++){
			for(int j = 0; j < centros[i].nAlumnos; j++){
				for(int k=1; k < 10; k++){
					int pref2 = centros[i].getAlumnos()[j].preferido(k);
					if(retos[pref2].nAlumnos < 8){
						retos[pref2].anadirAlumno(centros[i].getAlumnos()[j]);
						alumnosMetidos++;
						break;
					}
				}
			}
		}
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(alumnosMetidos + "-----------------------------");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		for(int i=0; i<9; i++){
			System.out.println(retos[i].nombre);
			System.out.println("");
			for(int j = 0; j<retos[i].nAlumnos; j++){
				if(retos[i].alumnos[j] != null){
					System.out.println(retos[i].alumnos[j].nombre + "  " + retos[i].alumnos[j].getCentro() + "  " + retos[i].alumnos[j].getPreferencias()[i]);
				}else{System.out.println("error");}
			}
			System.out.println("");
			System.out.println("");
		}
		
	}
	
	
}