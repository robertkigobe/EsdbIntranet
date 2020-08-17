package technicalResources.corporateServices;

public class Item {

	String ItemNo;
	String ItemDesc;
	String record;
	String comments;
	
	
	public Item(String itemNo, String itemDesc, String record, String comments) {
		super();
		ItemNo = itemNo;
		ItemDesc = itemDesc;
		this.record = record;
		this.comments = comments;
	}
	
	
	public Item(String itemNo, String itemDesc) {
		super();
		ItemNo = itemNo;
		ItemDesc = itemDesc;
	}


	@Override
	public String toString() {
		return "Item [ItemNo=" + ItemNo + ", ItemDesc=" + ItemDesc
				+ ", record=" + record + ", comments=" + comments + "]";
	}


	public String getItemNo() {
		return ItemNo;
	}
	public void setItemNo(String itemNo) {
		ItemNo = itemNo;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	public String getRecord() {
		return record;
	}
	public void setRecord(String record) {
		this.record = record;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
