package com.bataryat.common.response;

import java.util.List;

public class ListResponse<T> extends BaseResponse<T> {

	private List<T> data;
	
	public ListResponse() {}
	
	public ListResponse(List<T> data) {
		this.setData(data);
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}
}
