package inventory;

public class SubCategory {

	int subCatId;
	int catId;
	String subCatName;

	public SubCategory(int subCatId, int catId, String subCatName) {
		this.subCatId = subCatId;
		this.catId = catId;
		this.subCatName = subCatName;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getSubCatName() {
		return subCatName;
	}

	public void setSubCatName(String subCatName) {
		this.subCatName = subCatName;
	}

	@Override
	public String toString() {
		return "SubCategory [subCatId=" + subCatId + ", catId=" + catId + ", subCatName=" + subCatName + "]";
	}

}
