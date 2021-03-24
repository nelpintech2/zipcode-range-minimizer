package com.williamssonoma;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.williamssonoma.exception.ZipRangeMinimizerException;
import com.williamssonoma.service.ZipRangeService;
import com.williamssonoma.service.ZipRangeServiceImpl;

/**
 * @author Nelson Pinto
 *
 */
public class ZipRangeServiceTest {

	private final ZipRangeService zipRangeService = new ZipRangeServiceImpl();

	/**
	 * Test for a single Zip code range.
	 */
	@Test
	public void testMinimizeZipRange_When_SingleRange() throws ZipRangeMinimizerException {
		String[] zipRanges = { "[94200,94299]" };
		String minimizedZipRange = zipRangeService.minimizeZipRange(zipRanges);
		assertEquals("[94200,94299]", minimizedZipRange);
	}

	/**
	 * Test for a non-overlapping zip code range with regular order.
	 */
	@Test
	public void testMinimizeZipRange_When_NonOverlap_RegularOrder() throws ZipRangeMinimizerException {
		String[] zipRanges = { "[94133,94150]", "[94200,94299]", "[94600,94699]" };
		String minimizedZipRange = zipRangeService.minimizeZipRange(zipRanges);
		assertEquals("[94133,94150] [94200,94299] [94600,94699]", minimizedZipRange);
	}

	/**
	 * Test for a overlapping zip code range with arbitrary order.
	 */
	@Test
	public void testMinimizeZipRange_When_Overlap_ArbitraryOrder() throws ZipRangeMinimizerException {
		String[] zipRanges = { "[11000,11200]", "[11005,11005]", "[11005,11300]", "[11400,11500]", "[11300,11600]",
				"[11700,11700]" };
		String minimizedZipRange = zipRangeService.minimizeZipRange(zipRanges);
		assertEquals("[11000,11600] [11700,11700]", minimizedZipRange);
	}

	/**
	 * Test for a zip code range with arbitrary order.
	 */
	@Test
	public void testMinimizeZipRange_When_ArbitraryOrder() throws ZipRangeMinimizerException {
		String[] zipRanges = { "[94200,94299]", "[94133,94150]", "[94600,94699]" };
		String minimizedZipRange = zipRangeService.minimizeZipRange(zipRanges);
		assertEquals("[94200,94299] [94133,94150] [94600,94699]", minimizedZipRange);
	}
}
