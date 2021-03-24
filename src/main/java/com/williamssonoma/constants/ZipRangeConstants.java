package com.williamssonoma.constants;

/**
 * This is the constants class for the ZipRangeMinimizer application.
 * 
 * @author Nelson Pinto
 *
 */
public final class ZipRangeConstants {

	public static final String RANGE_START = "[";
	public static final String RANGE_END = "]";
	public static final String ZIP_DELIMITER = ",";
	public static final String INPUT_FILE = "zip_range.input";
	public static final String OUTPUT_FILE = "zip_range.output";
	public static final String ZIP_RANGE_REGEX = "\\[\\d{5}\\,\\d{5}\\]";
	public static final String ERROR_NO_INPUT = "No input provided. Please input Zip Code range in [ZipCode_LowerBound,ZipCode_HigherBound] format.";
	public static final String ERROR_ZIP_RANGE = "Invalid Zip Code Range format. Please input Zip Code range in [ZipCode_LowerBound,ZipCode_HigherBound] format.";
	public static final String ERROR_ZIP_ORDER = "Invalid Zip Code order. Higher bound Zip Code should be greater than lower bound Zip Code.";
	public static final String ERROR_EMPTY_ZIP_CODE_RANGE = "Empty Zip codes list or Zip range list";

}
