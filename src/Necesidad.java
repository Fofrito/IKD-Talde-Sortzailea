
public class Necesidad {

	Alumno [] alumnos;
	int nAlumnos;
	int indice;
	String nombre;
	boolean eusk;
	
	public Necesidad(int i, String n, boolean eus) {
		this.alumnos = new Alumno [10];
		nAlumnos=0;
		indice = i;
		this.nombre = n;
		eusk = eus;
	}
	
	public void anadirAlumno (Alumno a){
		alumnos[this.nAlumnos]=a;
		this.nAlumnos++;
	}
	
	public void imprimir ()
	{
		System.out.println(this.indice+"    "+this.nombre);
		for(int i=0;i<nAlumnos;i++)
		{
			System.out.println("\t" + (i+1)+ " " + this.alumnos[i].nombre + " " + this.alumnos[i].preferencias[indice]+" "+this.alumnos[i].euskera);
		}
	}
}
