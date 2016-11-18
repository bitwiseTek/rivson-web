package com.bitwise.manageme.rssson.web.response;
/**
 *  
 * @author Sika Kay
 * @date 10/09/16
 *
 */
import java.io.Serializable;
import java.util.List;

public class GridResponse<T extends Serializable> {

	public GridResponse() {
		
	}
	
	public GridResponse(int page, int total, long records, List<T> rows) {
		super();
		this.page = page;
		this.total = total;
		this.records = records;
		this.rows = rows;
	}

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private int page;
	
	private int total;
	
	private long records;
	
	private List<T> rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public long getRecords() {
		return records;
	}

	public void setRecords(long records) {
		this.records = records;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	
	@Override
	public String toString() {
		return "GridResponse [page=" + page + ",  total="  + total + ", records=" + records + "]";
	}

}
