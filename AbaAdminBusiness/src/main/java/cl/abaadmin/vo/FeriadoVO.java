package cl.abaadmin.vo;

public class FeriadoVO {
	
	private Integer id;
	private String start;
	private String title;
	
	public FeriadoVO() {
		super();
	}

	public FeriadoVO(Integer id, String start, String title) {
		super();
		this.id = id;
		this.start = start;
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
