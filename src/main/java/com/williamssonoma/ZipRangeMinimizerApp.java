package com.williamssonoma;

import java.util.List;

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
public class ZipRangeMinimizerApp {

	public static void main(String[] args) throws ZipRangeMinimizerException {
		List<String> zipRangeList = Utility.validateZipRange(args);
		ZipRangeService zipRangeService = new ZipRangeServiceImpl();
		String minimizedZipRange = zipRangeService.minimizeZipRange(zipRangeList.toArray(new String[zipRangeList.size()]));
		System.out.println("Output: " + minimizedZipRange);
	}
}
