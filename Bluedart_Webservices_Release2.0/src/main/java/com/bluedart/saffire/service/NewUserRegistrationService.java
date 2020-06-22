package com.bluedart.saffire.service;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Component;

import com.bluedart.exception.BlueDartException;
import com.bluedart.saffire.dto.NewUserRegistrationDTO;
@Component
public interface NewUserRegistrationService {
public NewUserRegistrationDTO saveNewUserRegistration(NewUserRegistrationDTO newUserRegistrationDTO) throws RemoteException;
public NewUserRegistrationDTO getOTPAndSendSMS(int length,String mobilenumber) throws RemoteException;
public boolean submitUserRegisterationData(NewUserRegistrationDTO newUserRegisteration);
}
