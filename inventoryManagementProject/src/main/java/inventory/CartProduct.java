package inventory;

public class CartProduct {
	int productId;
	int subCatId;
	String productName;
	int productRequiredQuantity;
	int totalProductPrice;
	
	
	public CartProduct(int productId, int subCatId, String productName, int productRequiredQuantity,
			int totalProductPrice) {
		this.productId = productId;
		this.subCatId = subCatId;
		this.productName = productName;
		this.productRequiredQuantity = productRequiredQuantity;
		this.totalProductPrice = totalProductPrice;
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
	public int getProductRequiredQuantity() {
		return productRequiredQuantity;
	}
	public void setProductRequiredQuantity(int productRequiredQuantity) {
		this.productRequiredQuantity = productRequiredQuantity;
	}
	public int getTotalProductPrice() {
		return totalProductPrice;
	}
	public void setTotalProductPrice(int totalProductPrice) {
		this.totalProductPrice = totalProductPrice;
	}
	public CartProduct getInstance() {
		return this;
	}
	@Override
	public String toString() {
		return "CartProduct [productId=" + productId + ", subCatId=" + subCatId + ", productName=" + productName
				+ ", productRequiredQuantity=" + productRequiredQuantity + ", totalProductPrice=" + totalProductPrice
				+ "]";
	}
	
	
	

}
