package com.lgd.ssh.spider.bean;

/**
 * 爬虫任务bean
 * @author lgd
 *
 */
public class SpiderTask extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5837061511032616360L;

	/**
	 * url md5值
	 */
	private String urlMd5;

	/**
	 * 任务最后更新时间
	 */
	private String updateTime;

	/**
	 * 任务当前状态 0处理成功 1处理失败 2待处理 3等待重试
	 */
	private Integer status;

	/**
	 * 可重试次数，当重试次数为0 表示任务处理失败
	 */
	private Integer retryTime;

	/**
	 * 当前页面是否要进行详细解析，并保存到数据文件中
	 */
	private Integer isDownload;

	public String getUrlMd5() {
		return urlMd5;
	}

	public void setUrlMd5(String urlMd5) {
		this.urlMd5 = urlMd5;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRetryTime() {
		return retryTime;
	}

	public void setRetryTime(Integer retryTime) {
		this.retryTime = retryTime;
	}

	public Integer getIsDownload() {
		return isDownload;
	}

	public void setIsDownload(Integer isDownload) {
		this.isDownload = isDownload;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SpiderTask{");
		builder.append("key=" + getKey());
		builder.append(",urlMd5=" + urlMd5);
		builder.append(",updateTime=" + updateTime);
		builder.append(",status=" + status);
		builder.append(",retryTime=" + retryTime);
		builder.append(",isDownload=" + isDownload);
		builder.append("}");
		return builder.toString();

	}
}
