package controlers;

import java.util.ArrayList;

import entity.TipoElemento;

public class CtrlTipoElem {
	
	private ArrayList<TipoElemento> tipos;
	
	public CtrlTipoElem(){
		tipos= new ArrayList<TipoElemento>();
		tipos.add(new TipoElemento("Cochera",2));
		tipos.add(new TipoElemento("Proyector",3));
		tipos.add(new TipoElemento("Notebook",1));
		tipos.add(new TipoElemento("Impresora",2));
		
	}
	
	public void add(TipoElemento te) {
		this.tipos.add(te);
	}
	
	public void delete(TipoElemento te){
		this.tipos.remove(te);
	}
	
	public void update(TipoElemento te){
		this.delete(te);
		this.add(te);
	}

}
