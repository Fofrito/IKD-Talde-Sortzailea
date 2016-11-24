import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Alumno {

	String nombre;
	int [] preferencias;
	String centro;
	int nRetos;
	boolean euskera;
	
	public String getNombre() {
		return nombre;
	}
	public String getCentro() {
		return centro;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int[] getPreferencias() {
		return preferencias;
	}
	
	public void setPreferencias(int[] preferencias) {
		this.preferencias = preferencias;
	}
	
	public Alumno(String nombre, String preferencia, String centro, boolean euskera) {
		this.nombre = nombre;
		String[] AuxPreferencias = preferencia.split(",");
		this.preferencias= new int[this.nRetos];
		for(int i=0; i<nRetos; i++){
			this.preferencias[i]= Integer.parseInt(AuxPreferencias[i]);
		}
		this.centro=centro;
		this.euskera=euskera;
	}
	
	/*public Alumno(String nombre, String centro, boolean euskera) {
		this.nombre = nombre;
		this.centro=centro;
		this.euskera=euskera;
		ArrayList<Integer> pref = new ArrayList<Integer>();
		pref.add(1);
		pref.add(2);
		pref.add(3);
		pref.add(4);
		pref.add(5);
		pref.add(6);
		pref.add(7);
		pref.add(8);
		pref.add(9);
		Collections.shuffle(pref);
		int[] pref2 = {pref.get(0),pref.get(1),pref.get(2),pref.get(3),pref.get(4),pref.get(5),pref.get(6),pref.get(7),pref.get(8)};
		this.preferencias = pref2;
		/*Random  rnd = new Random();
		Vector <Integer> aux = new Vector<Integer>();
		aux.add(1);
		aux.add(2);
		aux.add(3);
		aux.add(4);
		aux.add(5);
		aux.add(6);
		aux.add(7);
		aux.add(8);
		this.nombre = nombre;
		this.preferencias= new int[9];
		int a = rnd.nextInt() % 9;
		this.preferencias[0]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		a = rnd.nextInt() % 8;
		this.preferencias[1]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		a = rnd.nextInt() % 7;
		this.preferencias[2]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		a = rnd.nextInt() % 6;
		this.preferencias[3]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		a = rnd.nextInt() % 5;
		this.preferencias[4]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		a = rnd.nextInt() % 4;
		this.preferencias[5]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		a = rnd.nextInt() % 3;
		this.preferencias[6]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		a = rnd.nextInt() % 2;
		this.preferencias[7]=aux.get(Math.abs(a));
		aux.remove(Math.abs(a));
		this.preferencias[8]=aux.get(0);
		this.centro=centro;
		this.euskera=euskera;
	}*/
	
	public void ajustarAlumno(){
		if(!euskera)
			this.preferencias[3]=9999;
	}
	
	public int preferido(int a){
		for(int i=0;i<9;i++)
		{
			if(this.preferencias[i]==a)
				return i;
		}
		return -1;
	}
	
}