package inventory;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CategoryList {
	
	private CategoryList() {}
	private static final Logger logger = LogManager.getLogger(CategoryList.class);
	
	static List<Category> categoriesList=new ArrayList<>();
	
	public static void categoryListDisplay() {
		logger.info("ID\t\tCategory Name");
		for(Category element :categoriesList ) {
			logger.info("{}\t\t{}",element.getCatId(),element.getCatName());
			
		}
		
	}
	public static void addCategory(Category category) {
		categoriesList.add(category);
	}
       static void removeCategory(Category category) {
		categoriesList.remove(category);
	}
}
