package com.bluedart.pod.exception;

public class TrackDartServiceException extends Exception {
	
	private static final long serialVersionUID = -7650179531578663910L;
	
	private WSFault trackDartServiceFalut;
	
	public TrackDartServiceException() {
	}
	
	public TrackDartServiceException(WSFault trackDartServiceFalut) {
		super(trackDartServiceFalut.getFaultString());
		this.trackDartServiceFalut = trackDartServiceFalut;
	}
	
	public TrackDartServiceException(String message, WSFault faultInfo) {
		super(message);
		this.trackDartServiceFalut = faultInfo;
	}
	
	public TrackDartServiceException(String message, WSFault faultInfo, Throwable cause) {
		super(message, cause);
		this.trackDartServiceFalut = faultInfo;
	}
	
	public WSFault getFaultInfo() {
		return trackDartServiceFalut;
	}

}
