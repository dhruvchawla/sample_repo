
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package com.providian.bluedart.wipro.ws;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://ws.wipro.bluedart.Providian.com/".equals(namespaceURI) &&
                  "ImportLeadOutput".equals(typeName)){
                   
                            return  com.providian.bluedart.wipro.ws.ImportLeadOutput.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.wipro.bluedart.Providian.com/".equals(namespaceURI) &&
                  "SendLeadInfoToSafireRequest".equals(typeName)){
                   
                            return  com.providian.bluedart.wipro.ws.SendLeadInfoToSafireRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.wipro.bluedart.Providian.com/".equals(namespaceURI) &&
                  "LeadInfo".equals(typeName)){
                   
                            return  com.providian.bluedart.wipro.ws.LeadInfo.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://ws.wipro.bluedart.Providian.com/".equals(namespaceURI) &&
                  "SendLeadInfoToSafireResponse".equals(typeName)){
                   
                            return  com.providian.bluedart.wipro.ws.SendLeadInfoToSafireResponse.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    