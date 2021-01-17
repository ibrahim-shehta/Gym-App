package com.gym.common.response;

public class EntityResponse<T> extends BaseResponse<T> {

	private T data;

	public EntityResponse() {}
	
	public EntityResponse(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
