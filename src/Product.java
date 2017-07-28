public class Product {
	
	private String productDesc;
	private double price;


	public Product() {
		productDesc =" ";
		price = 0;

	}

	
	public void setProductDesc(String newProductDesc) {
		productDesc = newProductDesc;

	}

	public String getProductDesc() {
		return productDesc;
	}
	public void setPrice(double newPrice) {
		price = newPrice;
	}

	public double getPrice() {
		return price;
	}
	
}
