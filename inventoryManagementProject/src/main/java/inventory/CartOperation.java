package inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CartOperation {
	private static final Logger logger = LogManager.getLogger(CartOperation.class);

	private CartOperation() {

	}

	static int productChoice;
	static int productQuantity;
	static int subcategoryChoice;
	static int categoryChoice;

	static List<CartProduct> cartList = new ArrayList<>();

	public static void addToCart(Scanner scannerObject) {

		readingValues(scannerObject);
		addingProductToCart(scannerObject);

	}

	public static void addingProductToCart(Scanner scannerObject) {
		if (ProductList.productsList.stream().noneMatch((Product s) -> s.productId == productChoice)) {
			logger.warn("Product Id is invalid. Please re-enter it.");
			readingProductId(scannerObject);
			addingProductToCart(scannerObject);

		} else if (cartList.stream().anyMatch((CartProduct s) -> s.productId == productChoice)) {
			CartProduct existingProduct = cartList.stream()
					.filter(CartProduct -> CartProduct.getProductId() == productChoice).findAny().get();
			int productPrice = existingProduct.getTotalProductPrice() / existingProduct.getProductRequiredQuantity();
			existingProduct.setProductRequiredQuantity(existingProduct.getProductRequiredQuantity() + productQuantity);

			existingProduct
					.setTotalProductPrice(existingProduct.getTotalProductPrice() + (productQuantity * productPrice));

		} else {

			for (Product element : ProductList.productsList) {

				if (element.getProductId() == productChoice) {
					if (element.getProductAvailableQuantity() >= productQuantity) {
						element.setProductAvailableQuantity(element.getProductAvailableQuantity() - productQuantity);

						cartList.add(
								new CartProduct(element.getProductId(), element.getSubCatId(), element.getProductName(),
										productQuantity, element.getProductPrice() * productQuantity));

						logger.info("{} with quantity {} Added Successfully!!!!!!!!!!!!!!!!!!!!!!!!!!",
								element.getProductName(), productQuantity);
						break;

					} else {
						logger.warn("Required quantity is not available.Please re-verify it.");
						readingProductId(scannerObject);
						addingProductToCart(scannerObject);

					}
				}

			}
		}
	}

	public static void readingValues(Scanner scannerObject) {
		readingCategoryId(scannerObject);

		readingSubCategoryId(scannerObject);

		readingProductId(scannerObject);
	}

	public static void readingProductId(Scanner scannerObject) {
		ProductList.productListDisplay(subcategoryChoice, scannerObject);

		logger.info("Enter the product id you wanna add to the cart::");
		productChoice = scannerObject.nextInt();

		logger.info("Enter The Product Quantity::");
		productQuantity = scannerObject.nextInt();
	}

	public static void readingSubCategoryId(Scanner scannerObject) {
		SubCategoryList.subCategoryListDisplay(categoryChoice, scannerObject);

		logger.info("Enter Subcategory Id to dispaly products inside it::");
		subcategoryChoice = scannerObject.nextInt();
	}

	public static void readingCategoryId(Scanner scannerObject) {
		logger.info("Available Categories::");
		CategoryList.categoryListDisplay();

		logger.info("Enter category Id to continue::");
		categoryChoice = scannerObject.nextInt();
	}

	public static void viewCart() {
		int totalPrice = 0;
		if (cartList.isEmpty()) {
			logger.info("CART IS EMPTY.");
			logger.info("Add Items To The Cart...................!!");

		} else {
			logger.info("========================================");
			logger.info("CART::");
			logger.info("........................................");
			for (CartProduct elementInCart : cartList) {
				logger.info("{}\t{}\t{}\t{}",elementInCart.getProductId(),elementInCart.getProductName(),elementInCart.getTotalProductPrice(),elementInCart.getProductRequiredQuantity());
				totalPrice += elementInCart.getTotalProductPrice();
			}
			logger.info("........................................");
			logger.info("Total Amount To Be Paid :: {}",totalPrice);
			logger.info("=========================================");
		}

	}

	public static void removeItemsFromCart(Scanner scannerObject) {
		int productIdToBeRemoved;
		int removedQuantity = 0;
		if (cartList.isEmpty()) {
			logger.info("No Item Present In Cart To Remove.");
			return;
		}
		viewCart();
		logger.info("Enter The Product ID You Want To Remove::");
		productIdToBeRemoved = scannerObject.nextInt();
		logger.info("Enter The Product Quantity To Remove::");
		removedQuantity = scannerObject.nextInt();

		if (cartList.stream().noneMatch((CartProduct s) -> s.getProductId() == productIdToBeRemoved)) {
			logger.info("Product Id is invalid. Please re-enter it.");
			removeItemsFromCart(scannerObject);

		} else {
			removingProductFromCart(scannerObject, productIdToBeRemoved, removedQuantity);
		}
		for (Product element : ProductList.productsList) {

			if (element.getProductId() == productIdToBeRemoved) {
				element.setProductAvailableQuantity(removedQuantity + element.getProductAvailableQuantity());
				break;
			}

		}

	}

	public static void removingProductFromCart(Scanner scannerObject, int productIdToBeRemoved, int removedQuantity) {
		for (CartProduct element : cartList) {

			if (element.getProductId() == productIdToBeRemoved) {
				int originalProductPrice = element.getTotalProductPrice() / element.getProductRequiredQuantity();
				if ((element.getProductRequiredQuantity()) >= removedQuantity) {

					if (element.productRequiredQuantity == 1) {
						cartList.remove(element);

					} else {
						element.setTotalProductPrice(
								element.getTotalProductPrice() - (originalProductPrice * removedQuantity));
						element.setProductRequiredQuantity(element.getProductRequiredQuantity() - removedQuantity);
					}
					logger.info("Item Removed Successfully");
					break;
				} else {
					logger.info("Product quantity is greater than present quantity. Please re-enter it.");
					removeItemsFromCart(scannerObject);
				}

			}

		}
	}

	public static void checkOut(Scanner scannerObject) {
		if (cartList.isEmpty()) {
			logger.info("Your cart is empty.Do you really want to Checkout without shopping");
			logger.info("1->Yes");
			logger.info("2->No");
			int checkoutChoice = scannerObject.nextInt();
			if (checkoutChoice == 1) {
				logger.info("VISIT AGAIN");
			} else if (checkoutChoice == 2) {
				Inventory.operationSelection();
			} else {
				logger.info("Invalid Choice. Re-enter it");
				checkOut(scannerObject);
			}
		} else {
			viewCart();
			logger.info("THANK YOU FOR SHOPPING.VISIT AGAIN");
		}

	}

}
