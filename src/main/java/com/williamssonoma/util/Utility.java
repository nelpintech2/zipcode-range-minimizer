package com.williamssonoma.util;

import java.util.List;
import java.util.regex.Pattern;

import com.williamssonoma.constants.ZipRangeConstants;
import com.williamssonoma.exception.ZipRangeMinimizerException;
import com.williamssonoma.model.ZipRange;

/**
 * This is the Utility class used for ZipRangeMinimizer application.
 * 
 * @author Nelson Pinto
 *
 */
public class Utility {
	
	/**
	 * This method is used to validate input zip ranges.
	 * @param zipRanges the array of input zip code ranges
	 * @throws ZipRangeMinimizerException
	 * 
	 */	
	public static void isValidZipRange(String[] zipRangeArr) 
			throws ZipRangeMinimizerException{
		//If no input provided throw exception
		if(zipRangeArr == null || zipRangeArr.length == 0) {			
			throw new ZipRangeMinimizerException(ZipRangeConstants.ERROR_NO_INPUT);			
		}
		
		for(String zipRange : zipRangeArr)
        {
			//If input Zip code range is of incorrect format, throw exception
            if(!Pattern.matches(ZipRangeConstants.ZIP_RANGE_REGEX,zipRange))
            {
                throw new ZipRangeMinimizerException(ZipRangeConstants.ERROR_ZIP_RANGE);
            }            
            String zipCodes[] = zipRange.replace(ZipRangeConstants.RANGE_START, "")
            								.replace(ZipRangeConstants.RANGE_END, "")
            									.split(ZipRangeConstants.ZIP_DELIMITER);
            //If lower bound zip code is greater than higher bound zip code, throw exception 
            if(Integer.parseInt(zipCodes[0]) > Integer.parseInt(zipCodes[1]))
            {
                throw new ZipRangeMinimizerException(ZipRangeConstants.ERROR_ZIP_ORDER);
            }
        }
		
	}
	
	/**
	 * This method is used to extract list of ZipRange objects and individual zip codes from input zip code range.
	 * @param zipRanges the input zip code ranges
	 * @param zipRangeList the extracted list of ZipRange objects
	 * @param zipCodes the extracted list of individual Zip codes
	 * @throws ZipRangeMinimizerException
	 * 
	 */	
	public static void extractZipCodesandRange(String[] zipRanges, List<ZipRange> zipRangeList, List<Integer> zipCodes) 
										throws ZipRangeMinimizerException{
		//If zipRangeList or zipCodes list is null, throw exception
		if(zipRangeList == null || zipCodes == null) {
			throw new ZipRangeMinimizerException(ZipRangeConstants.ERROR_EMPTY_ZIP_CODE_RANGE);
		}
			
		//Loop through input zip code ranges and extract individual zip codes
		for (String zipRange : zipRanges) {			
			String[] zipRangeSplit = zipRange.replace(ZipRangeConstants.RANGE_START, "").replace(ZipRangeConstants.RANGE_END, "")
					.split(ZipRangeConstants.ZIP_DELIMITER);	
			int lowZipCode = Integer.parseInt(zipRangeSplit[0]);
			int highZipCode = Integer.parseInt(zipRangeSplit[1]);		
			zipCodes.add(lowZipCode);
			zipCodes.add(highZipCode);
			zipRangeList.add(new ZipRange(lowZipCode, highZipCode));			
		}
	}		
	
}
