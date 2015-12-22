package com.urong.mybatis.model;

public class SearchVo {

	private String searchSelect;
	private String searchText;
	
	public String getSearchSelect() {
		return searchSelect;
	}
	
	public void setSearchSelect(String searchSelect) {
		this.searchSelect = searchSelect;
	}
	
	public String getSearchText() {
		return searchText;
	}
	
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	
	public SearchVo(String searchSelect, String searchText) {
		this.searchSelect = searchSelect;
		this.searchText = searchText;
	}
	
	public SearchVo() {	}
}
