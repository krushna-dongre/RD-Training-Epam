package inventory;

public class LoadDataForList {
	
	private LoadDataForList() {
		
	}
	
	public static void addProducts() {
		ProductList.addProduct(new Product(1001, 101, "Samsung TV", 12, 30000));
		ProductList.addProduct(new Product(1002, 101, "Onida TV", 15, 20000));
		ProductList.addProduct(new Product(1003, 102, "Oppo Mobile", 20, 25000));
		ProductList.addProduct(new Product(1004, 102, "Vivo Mobile", 10, 22000));
		ProductList.addProduct(new Product(1005, 103, "Hier WashingMachine", 8, 7000));
		ProductList.addProduct(new Product(1006, 103, "Whirlpool WashingMachine", 16, 9000));
		ProductList.addProduct(new Product(1007, 104, "Denims Jacket", 25, 1200));
		ProductList.addProduct(new Product(1008, 104, "Trousers", 22, 800));
		ProductList.addProduct(new Product(1009, 105, "Tops", 30, 500));
		ProductList.addProduct(new Product(1010, 105, "Plazzo", 24, 900));
		ProductList.addProduct(new Product(1011, 6, "Frocks", 21, 1000));
		ProductList.addProduct(new Product(1012, 6, "Pants", 27, 700));

	}

	public static void addSubCategories() {

		SubCategoryList.addSubCategory(new SubCategory(101, 1, "TV"));
		SubCategoryList.addSubCategory(new SubCategory(102, 1, "Mobiles"));
		SubCategoryList.addSubCategory(new SubCategory(103, 1, "Washing Machine"));
		SubCategoryList.addSubCategory(new SubCategory(104, 2, "Men Wear"));
		SubCategoryList.addSubCategory(new SubCategory(105, 2, "Women Wear"));
		SubCategoryList.addSubCategory(new SubCategory(106, 2, "Kids Wear"));

	}

	public static void addCategories() {

		CategoryList.addCategory(new Category(1, "Electronics"));
		CategoryList.addCategory(new Category(2, "Fashion"));

	}

}
