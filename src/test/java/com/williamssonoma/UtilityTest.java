package com.williamssonoma;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.williamssonoma.constants.ZipRangeConstants;
import com.williamssonoma.exception.ZipRangeMinimizerException;
import com.williamssonoma.model.ZipRange;
import com.williamssonoma.util.Utility;

/**
 * @author Nelson Pinto
 *
 */
public class UtilityTest {
	
	/**
	 * Test for validating null input Zip range.
	 */
	@Test
    public void testIsValidZipRange_When_Null() {
		Exception exception = assertThrows(ZipRangeMinimizerException.class, () -> {
			Utility.isValidZipRange(null);
	    });
		assertTrue(exception.getMessage().contains(ZipRangeConstants.ERROR_NO_INPUT));
    }
	
	/**
	 * Test for validating empty input Zip range.
	 */
	@Test
    public void testIsValidZipRange_When_Empty() {
		Exception exception = assertThrows(ZipRangeMinimizerException.class, () -> {
			Utility.isValidZipRange(new String[] {});
	    });
		assertTrue(exception.getMessage().contains(ZipRangeConstants.ERROR_NO_INPUT));
    }
	
	/**
	 * Test for validating invalid input Zip range.
	 */
	@Test
    public void testIsValidZipRange_When_Invalid_Format() {
		Exception exception = assertThrows(ZipRangeMinimizerException.class, () -> {
			Utility.isValidZipRange(new String[] {"[94226,94abc"});
	    });
		assertTrue(exception.getMessage().contains(ZipRangeConstants.ERROR_ZIP_RANGE));
    }
	
	/**
	 * Test for validating invalid Zip order.
	 */
	@Test
    public void testIsValidZipRange_When_Invalid_Order() {
		Exception exception = assertThrows(ZipRangeMinimizerException.class, () -> {
			Utility.isValidZipRange(new String[] {"[94226,94225]"});
	    });
		assertTrue(exception.getMessage().contains(ZipRangeConstants.ERROR_ZIP_ORDER));
    }
	
	/**
	 * Test for validating null Zip ranges and zip code list.
	 */
	@Test
    public void testExtractZipCodesandRange_When_Empty() {
		Exception exception = assertThrows(ZipRangeMinimizerException.class, () -> {
			Utility.extractZipCodesandRange(new String[] {"[94226,94225]"}, null, null);
	    });
		assertTrue(exception.getMessage().contains(ZipRangeConstants.ERROR_EMPTY_ZIP_CODE_RANGE));
    }
	
	/**
	 * Test for extracting Zip range list.
	 */
	@Test
    public void testExtractZipCodesandRange_ZipRanges() throws ZipRangeMinimizerException {	
		String[] zipRanges = {"[11000,11200]", "[11005,11005]", "[11005,11300]", "[11400,11500]", "[11300,11600]", "[11700,11700]"};
		List<ZipRange> zipRangeList = new ArrayList<>();
		List<Integer> zipCodes = new ArrayList<>();
		Utility.extractZipCodesandRange(zipRanges, zipRangeList, zipCodes);
		assertEquals(6, zipRangeList.size());
	}
	
	/**
	 * Test for extracting zip code list.
	 */
	@Test
    public void testExtractZipCodesandRange_ZipCodes() throws ZipRangeMinimizerException {	
		String[] zipRanges = {"[11000,11200]", "[11005,11005]", "[11005,11300]", "[11400,11500]", "[11300,11600]", "[11700,11700]"};
		List<ZipRange> zipRangeList = new ArrayList<>();
		List<Integer> zipCodes = new ArrayList<>();
		Utility.extractZipCodesandRange(zipRanges, zipRangeList, zipCodes);
		assertEquals(12, zipCodes.size());
	}
	
}
