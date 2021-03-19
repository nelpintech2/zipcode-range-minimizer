package com.williamssonoma.service;

import java.util.ArrayList;
import java.util.List;

import com.williamssonoma.constants.ZipRangeConstants;
import com.williamssonoma.exception.ZipRangeMinimizerException;
import com.williamssonoma.model.ZipRange;
import com.williamssonoma.util.Utility;

/**
 * This is the business service implementation class used to minimize the zip code range.
 * 
 * @author Nelson Pinto
 *
 */
public class ZipRangeServiceImpl implements ZipRangeService {

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
	@Override
	public String minimizeZipRange(String[] zipRanges) throws ZipRangeMinimizerException{
		//Holds list of input zip ranges
		List<ZipRange> zipRangeList = new ArrayList<>();
		//Holds list of individual zip codes
		List<Integer> zipCodes = new ArrayList<>();
		//Holds the minimized zip range which will be returned as the output.
		StringBuilder minimizedZipRange = new StringBuilder("");
		
		//counter for deciding where to place the zip code in the minimized range, 
		//lower or upper bound.
		int zipRangeCounter = 0;
		//counter for tracking number of times the zip code is found in the input range.
		int occurences = 0; 
		
		Utility.extractZipCodesandRange(zipRanges, zipRangeList, zipCodes);
		
        for (Integer zipCode : zipCodes) {
        	//Loop through the zip range list and track the number of times zip code is 
        	//found in the list.
            for (ZipRange zipRange : zipRangeList) {                   
                if (zipCode >= zipRange.getLowZipCode() 
                		&& zipCode <= zipRange.getHighZipCode()) {
                	occurences++;
                }                
            }
            //if zip code is found once, then its added in the minimized zip range.
            //If zipRangeCounter is 0, then zip code is added as lower bound.
            //If zipRangeCounter is 1, then zip code is added as higher bound.
            if (occurences == 1) {                
                if (zipRangeCounter == 0) {
                	minimizedZipRange.append(ZipRangeConstants.RANGE_START).append(zipCode);
                	zipRangeCounter++;

                } else if (zipRangeCounter == 1) {
                	minimizedZipRange.append(ZipRangeConstants.ZIP_DELIMITER).append(zipCode);
                    zipRangeCounter++;
                }
            }      
            //If zipRangeCounter is 2. then the range is closed and space is added for the next range.
            if (zipRangeCounter == 2) {
            	minimizedZipRange.append(ZipRangeConstants.RANGE_END).append(" ");
            	zipRangeCounter = 0;
            }
            occurences = 0;
        }
        
        return minimizedZipRange.toString().trim();
	}

}
