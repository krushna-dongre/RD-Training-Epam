package inventory;

public class Product {

	int productId;
	int subCatId;
	String productName;
	int productAvailableQuantity;
	int productPrice;
	public Product(int productId, int subCatId, String productName, int productAvailableQuantity, int productPrice) {
		this.productId = productId;
		this.subCatId = subCatId;
		this.productName = productName;
		this.productAvailableQuantity = productAvailableQuantity;
		this.productPrice = productPrice;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductAvailableQuantity() {
		return productAvailableQuantity;
	}

	public void setProductAvailableQuantity(int productAvailableQuantity) {
		this.productAvailableQuantity = productAvailableQuantity;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", subCatId=" + subCatId + ", productName=" + productName
				+ ", productAvailableQuantity=" + productAvailableQuantity + ", productPrice=" + productPrice + "]";
	}

}
