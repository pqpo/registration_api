package cn.edu.hhu.reg.common.restful;

/**
 * 分页页面数据结果
 * 
 * @author wang.sheng
 */
public final class PagingResult<T>
{
	private long totalCount;
	private T[] results;

	public PagingResult(long totalCount, T[] results)
	{
		this.totalCount = totalCount;
		this.results = results;
	}

	public long getTotalCount()
	{
		return totalCount;
	}

	public T[] getResults()
	{
		return results;
	}

}
