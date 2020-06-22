package com.bluedart.autopod.daoImpl;

import com.bluedart.autopod.dto.AutoPodDto;


public class Test {
	
	AutoPodDaoImpl autoPodDaoImpl= new AutoPodDaoImpl();

	public static void main(String[] args) {
		try{
		AutoPodDaoImpl daoImpl = new AutoPodDaoImpl();
		// search test
		//daoImpl.getTestSearch();
		// insertion test
	       //getTestInsert();
		Test test = new Test();
		//test.getTestSearch();
		
		test.getTestEdit();
		 //daoImpl.getTestEdit();
		// daoImpl.getTestDelete();
		}
		catch(Exception unreco)
		{
			
			System.out.println("Unrecoverable>>>>" +unreco.getMessage());
		}
	}

	/*private void getTestDelete() {
		AutoPodDto autoPodDto = new AutoPodDto();
		autoPodDto.setLoginid("GGN00075");
		autoPodDto.setReporttype("DL");

		AutoPodDto autoPoDto = deleteAutoPodToEntry(autoPodDto);

	}*/
	
	private void getTestInsert() {
		AutoPodDto autoPodDto = new AutoPodDto();
		autoPodDto.setLoginid("TRZ00004");
		autoPodDto.setReporttype("DL");
		autoPodDto.setEmailid("rashmi.pintu@gmail.com");
		autoPodDto.setSortOrder("DESC");
		autoPodDto.setFrequency("D");
		autoPodDto.setPageSize(1);
		autoPodDto.setPageNo(1);
		autoPodDto.setCreatedBy("RA848436");
		AutoPodDaoImpl daoImpl = new AutoPodDaoImpl();
		AutoPodDto autoPoDto = daoImpl.createPod(autoPodDto);

	}

	private void getTestEdit() {
		AutoPodDto autoPodDto = new AutoPodDto();
		
		autoPodDto.setLoginid("JAI00018");
		autoPodDto.setReporttype("OP");
		autoPodDto.setEmailid("rashmi.pintu@gmail.com");
		autoPodDto.setSortOrder("DESC");
		autoPodDto.setFrequency("D");
		autoPodDto.setPageSize(10);
		autoPodDto.setPageNo(230);
		autoPodDto.setCreatedBy("RA848436");
		AutoPodDaoImpl daoImpl = new AutoPodDaoImpl();
		AutoPodDto autoPodto = daoImpl.editPod(autoPodDto);

	}

	private void getTestSearch() {
		AutoPodDto autoPodDto = new AutoPodDto();
	/*	autoPodDto.setLoginid("");
		autoPodDto.setReporttype(null);
		autoPodDto.setEmailid(null);
		autoPodDto.setPageSize(10);
		autoPodDto.setPageNo(1);
		autoPodDto.setStatus(null);
		autoPodDto.setReporttype(null);*/
		autoPodDto.setLoginid("DEL00243");
		autoPodDto.setEmailid("rashmi.pintu2@gmail.com");
		autoPodDto.setPageSize(10);
		autoPodDto.setPageNo(1);
		autoPodDto.setStatus("0");
		autoPodDto.setReporttype("DL");
		AutoPodDaoImpl daoImpl = new AutoPodDaoImpl();
		AutoPodDto autoPoDto = daoImpl.searchPod(autoPodDto) ;
	}



}
