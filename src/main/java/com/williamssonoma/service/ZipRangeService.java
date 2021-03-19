package com.williamssonoma.service;

import com.williamssonoma.exception.ZipRangeMinimizerException;

/**
 * This is the business service interface used to minimize the zip code range.
 * 
 * @author Nelson Pinto
 *
 */
public interface ZipRangeService {

	/**
	 * This is the method used to minimize the input zip code range by looping through each of 
	 * the zip codes and comparing it against the input zip code range. If the zip code is 
	 * found in more than one range, then its ignored. If not, its used in the minimized zip 
	 * range.
	 * @param zipRanges the array of input zip code ranges
	 * @return the minimized zip code range
	 * @throws ZipRangeMinimizerException
	 * 
	 */	
	public String minimizeZipRange(String[] zipRanges) throws ZipRangeMinimizerException;
}
