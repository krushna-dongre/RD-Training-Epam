package inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductList {

	private ProductList() {
	}
	private static final Logger logger = LogManager.getLogger(ProductList.class);

	static List<Product> productsList = new ArrayList<>();

	public static void productListDisplay(int subCategoryId, Scanner scannerObject) {
		if (productsList.stream().noneMatch((Product s) -> s.getSubCatId() == subCategoryId)) {
			logger.info("Sub-Category Id is invalid. Please re-enter it.");
			CartOperation.readingSubCategoryId(scannerObject);
			productListDisplay(CartOperation.subcategoryChoice,scannerObject);
			

		} else {
			logger.info("Available Products are::");
			for (Product element : productsList) {

				if (element.getSubCatId() == subCategoryId)
					logger.info("{}\t{}\t{}\t{}",element.getProductId(),element.getProductName(),element.getProductPrice(),element.getProductAvailableQuantity());

			}
		}

	}

	public static void addProduct(Product product) {
		productsList.add(product);
	}

	public static void removeProduct(Product product) {
		productsList.remove(product);
	}

}
