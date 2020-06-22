/**
 * 
 */
package com.bluedart.autopod.dao;

import com.bluedart.autopod.dto.AutoPodDto;

/**
 * @author RA848436
 *
 */
public interface AutoPodDao {

	public AutoPodDto createPod(AutoPodDto autoPodDto);

	public AutoPodDto searchPod(AutoPodDto autoPodDto);

	public AutoPodDto editPod(AutoPodDto autoPodDto);

	public AutoPodDto softDeletePod(AutoPodDto autoPodDto);
	
}
