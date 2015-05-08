package cn.edu.hhu.reg.common.restful;

/**
 * 用于展示简单回显
 * 
 * @author wang.sheng
 * 
 */
public class SimpleResponse
{
	private boolean success = true;
	private String message;
	private Object data;

	public SimpleResponse(){
	}
	
	public SimpleResponse(boolean success, String message, Object data){
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	public boolean isSuccess()
	{
		return success;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Object getData()
	{
		return data;
	}

	public void setData(Object data)
	{
		this.data = data;
	}

}
