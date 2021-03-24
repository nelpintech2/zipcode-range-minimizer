package com.williamssonoma.util;

import java.util.ArrayList;
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
	 * 
	 * @param zipRanges the array of input zip code ranges
	 * @return the list of validated Zip code ranges
	 * @throws ZipRangeMinimizerException
	 * 
	 */
	public static List<String> validateZipRange(String[] zipRangeArr) throws ZipRangeMinimizerException {
		// If no input provided throw exception
		if (zipRangeArr == null || zipRangeArr.length == 0) {
			throw new ZipRangeMinimizerException(ZipRangeConstants.ERROR_NO_INPUT);
		}

		List<String> zipRangeList = new ArrayList<>();
		for (String zipRange : zipRangeArr) {
			// If input Zip code range is of incorrect format, throw exception
			if (!Pattern.matches(ZipRangeConstants.ZIP_RANGE_REGEX, zipRange)) {
				throw new ZipRangeMinimizerException(ZipRangeConstants.ERROR_ZIP_RANGE);
			}
			String zipCodes[] = zipRange.replace(ZipRangeConstants.RANGE_START, "")
					.replace(ZipRangeConstants.RANGE_END, "").split(ZipRangeConstants.ZIP_DELIMITER);
			int lowZipCode = Integer.parseInt(zipCodes[0]);
			int highZipCode = Integer.parseInt(zipCodes[1]);
			int tmpZipCode = 0;
			// If lower bound zip code is greater than higher bound zip code, switch the zip
			// codes
			if (lowZipCode > highZipCode) {
				tmpZipCode = lowZipCode;
				lowZipCode = highZipCode;
				highZipCode = tmpZipCode;
			}
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(ZipRangeConstants.RANGE_START).append(lowZipCode + ZipRangeConstants.ZIP_DELIMITER)
					.append(highZipCode).append(ZipRangeConstants.RANGE_END);
			zipRangeList.add(strBuilder.toString());
		}
		return zipRangeList;
	}

	/**
	 * This method is used to extract list of ZipRange objects and individual zip
	 * codes from input zip code range.
	 * 
	 * @param zipRanges    the input zip code ranges
	 * @param zipRangeList the extracted list of ZipRange objects
	 * @param zipCodes     the extracted list of individual Zip codes
	 * @throws ZipRangeMinimizerException
	 * 
	 */
	public static void extractZipCodesandRange(String[] zipRanges, List<ZipRange> zipRangeList, List<Integer> zipCodes)
			throws ZipRangeMinimizerException {
		// If zipRangeList or zipCodes list is null, throw exception
		if (zipRangeList == null || zipCodes == null) {
			throw new ZipRangeMinimizerException(ZipRangeConstants.ERROR_EMPTY_ZIP_CODE_RANGE);
		}

		// Loop through input zip code ranges and extract individual zip codes
		for (String zipRange : zipRanges) {
			String[] zipRangeSplit = zipRange.replace(ZipRangeConstants.RANGE_START, "")
					.replace(ZipRangeConstants.RANGE_END, "").split(ZipRangeConstants.ZIP_DELIMITER);
			int lowZipCode = Integer.parseInt(zipRangeSplit[0]);
			int highZipCode = Integer.parseInt(zipRangeSplit[1]);
			zipCodes.add(lowZipCode);
			zipCodes.add(highZipCode);
			zipRangeList.add(new ZipRange(lowZipCode, highZipCode));
		}
	}

}
