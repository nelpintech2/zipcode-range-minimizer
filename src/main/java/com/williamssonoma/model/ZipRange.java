package com.williamssonoma.model;

/**
 * This is the Value object for ZipRangeMinimizer application.
 * 
 * @author Nelson Pinto
 *
 */
public final class ZipRange {
	/**
	 * The lower bound zip code
	 */
	private final Integer lowZipCode;
	/**
	 * The higher bound zip code
	 */
	private final Integer highZipCode;

	/**
	 * Constructor for ZipRange
	 * 
	 * @param lowZipCode  the lower bound zip code
	 * @param highZipCode the higher bound zip code
	 */
	public ZipRange(Integer lowZipCode, Integer highZipCode) {
		this.lowZipCode = lowZipCode;
		this.highZipCode = highZipCode;
	}

	/**
	 * Getter for lowZipCode
	 * 
	 * @return lower bound zip code
	 */
	public Integer getLowZipCode() {
		return lowZipCode;
	}

	/**
	 * Getter for highZipCode
	 * 
	 * @return higher bound zip code
	 */
	public Integer getHighZipCode() {
		return highZipCode;
	}

	/**
	 * Converts to String
	 * 
	 * @return string value
	 */
	@Override
	public String toString() {
		return "ZipRange [lowZipCode=" + lowZipCode + ", highZipCode=" + highZipCode + "]";
	}

	/**
	 * Calculates Hash value
	 * 
	 * @return the hash value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((highZipCode == null) ? 0 : highZipCode.hashCode());
		result = prime * result + ((lowZipCode == null) ? 0 : lowZipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZipRange other = (ZipRange) obj;
		if (highZipCode == null) {
			if (other.highZipCode != null)
				return false;
		} else if (!highZipCode.equals(other.highZipCode))
			return false;
		if (lowZipCode == null) {
			if (other.lowZipCode != null)
				return false;
		} else if (!lowZipCode.equals(other.lowZipCode))
			return false;
		return true;
	}
}
