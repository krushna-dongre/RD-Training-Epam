package inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SubCategoryList {

	private SubCategoryList() {
	}
	private static final Logger logger = LogManager.getLogger(SubCategoryList.class);
	static List<SubCategory> subCategoriesList = new ArrayList<>();

	public static void subCategoryListDisplay(int categoryId, Scanner scannerObject) {
		

		if (subCategoriesList.stream().noneMatch((SubCategory s) -> s.getCatId() == categoryId)) {
			logger.info("Category Id is invalid. Please re-enter it.");
			CartOperation.readingCategoryId(scannerObject);
			subCategoryListDisplay(CartOperation.categoryChoice,scannerObject);

		} else {
			logger.info("SubCategories are::");
			for (SubCategory element : subCategoriesList) {

				if (element.getCatId() == categoryId)
					logger.info("{}\t{}",element.subCatId,element.subCatName);

			}
		}

	}

	public static void addSubCategory(SubCategory subCategory) {
		subCategoriesList.add(subCategory);
	}

	public static void removeSubCategory(SubCategory subCategory) {
		subCategoriesList.remove(subCategory);
	}

}
