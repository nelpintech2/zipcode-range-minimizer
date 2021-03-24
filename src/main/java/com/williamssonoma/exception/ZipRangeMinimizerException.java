package com.williamssonoma.exception;

/**
 * This is the custom exception class for the ZipRangeMinimizer application.
 * 
 * @author Nelson Pinto
 *
 */
@SuppressWarnings("serial")
public class ZipRangeMinimizerException extends Exception {

	public ZipRangeMinimizerException(String errorMessage) {
		super(errorMessage);
	}
}
