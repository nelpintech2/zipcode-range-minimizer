package com.williamssonoma;

import com.williamssonoma.exception.ZipRangeMinimizerException;
import com.williamssonoma.service.ZipRangeService;
import com.williamssonoma.service.ZipRangeServiceImpl;
import com.williamssonoma.util.Utility;

/**
 * This is the main class for minimizing the zip code range.
 * 
 * @author Nelson Pinto
 *
 */
public class ZipRangeMinimizerApp 
{
	
    public static void main( String[] args ) throws ZipRangeMinimizerException
    {	
    	Utility.isValidZipRange(args);		
		ZipRangeService zipRangeService = new ZipRangeServiceImpl();
		String minimizedZipRange = zipRangeService.minimizeZipRange(args);	
		System.out.println("Output: "+minimizedZipRange);
    }
}
