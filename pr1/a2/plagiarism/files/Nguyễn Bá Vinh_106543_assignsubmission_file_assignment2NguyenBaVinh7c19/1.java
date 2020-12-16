

public class Product implements Comparable<Product> {

	private String idnumber;
	private String tensanpham;
	private double giatien;
	private int soluong;


	public Product() {
	}

	public Product(String idnumber, String tensanpham, double giatien, int soluong) {
		this.tensanpham = tensanpham;
		this.idnumber = idnumber;
		this.giatien = giatien;
		this.soluong = soluong;
	}

	public String getName() {
		return tensanpham;
	}

	public void setName(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getId() {
		return idnumber;
	}

	public void setId(String idnumber) {
		this.idnumber = idnumber;
	}

	public double getPrice() {
		return giatien;
	}

	public void setPrice(double giatien) {
		this.giatien = giatien;
	}
	
	public int getQuantity() {
		return soluong;
	}
	
	public void setQuantity(int soluong) {
		this.soluong = soluong;
	}

	@Override
	public int compareTo(Product o) {
		if (this.giatien < o.giatien) {
			return -1;
		} else if (this.giatien > o.giatien) {
			return 1;
		} else {
			return 0;
		}
	}    
}