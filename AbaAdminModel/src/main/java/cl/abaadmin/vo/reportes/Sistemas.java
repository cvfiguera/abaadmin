package cl.abaadmin.vo.reportes;

public enum Sistemas {
	
	WEB(0, "Web ABA"), ADMIN(1, "Admin ABA");
	
	private int id;
	private String nombre;
	
	Sistemas(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int id() {
        return id;
    }
	
	public String nombre() {
		return nombre;
	}
}
