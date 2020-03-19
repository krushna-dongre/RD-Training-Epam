package inventory;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Inventory {
	private static final Logger logger = LogManager.getLogger(Inventory.class);
	public static void main(String[] args) {
		

		LoadDataForList.addCategories();

		LoadDataForList.addSubCategories();

		LoadDataForList.addProducts();

		operationSelection();

	}


	public static void operationSelection() {
		int userChoice = 0;

		Scanner scannerObject = new Scanner(System.in);
		do {
			logger.info("Choose The Operation You Want To Perform::");
			logger.info("1->Add Items To Cart");
			logger.info("2->View Cart");
			logger.info("3->Remove Items From Cart");
			logger.info("4->CheckOut");
			logger.info("5->Exit");
			logger.info("Enter Your Choice to proceed further::");
			try {
				userChoice = scannerObject.nextInt();
				switch (userChoice) {
				case 1:
					CartOperation.addToCart(scannerObject);
					break;
				case 2:
					CartOperation.viewCart();
					break;
				case 3:
					CartOperation.removeItemsFromCart(scannerObject);
					break;
				case 4:
					CartOperation.checkOut(scannerObject);
					break;
				case 5:
					logger.info("Exiting.................Thank You");
					return;
				default:logger.info("Enter A Valid Cart Operation");
				}
			} catch (Exception e) {
				logger.error("Invalid input format");
				return;
			}

			


		} while (userChoice != 4);
	}

}
