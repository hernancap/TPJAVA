package controlers;

import java.util.ArrayList;

import entity.Elemento;

public class CtrlElemento {
	
private ArrayList<Elemento> elem;
	
	public CtrlElemento(){
		elem = new ArrayList<Elemento>();
		elem.add(new Elemento("Coch_1","Cochera",2));
		elem.add(new Elemento("Proy_1","Proyector",3));
		elem.add(new Elemento("Lenovo_1","Notebook",1));
		elem.add(new Elemento("EPSON_COL_1","Impresora",2));
		elem.add(new Elemento("Coch_2","Cochera",2));
		elem.add(new Elemento("Proy_2","Proyector",3));
		elem.add(new Elemento("Lenovo_2","Notebook",1));
		elem.add(new Elemento("EPSON_ByN_1","Impresora",2));
		
		
		
	}
	
	public void add(Elemento el) {
		this.elem.add(el);
	}
	
	public void delete(Elemento el){
		this.elem.remove(el);
	}
	
	public void update(Elemento el){
		this.delete(el);
		this.add(el);
	}

}
