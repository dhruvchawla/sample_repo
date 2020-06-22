
/**
 * PickupResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */


package org.datacontract.schemas._2004._07.bd_entities_pickup;


/**
 *  PickupResponse bean class
 */
@SuppressWarnings({"unchecked","unused"})

public  class PickupResponse extends org.datacontract.schemas._2004._07.bd_entities_common.ResponseBase
implements org.apache.axis2.databinding.ADBBean{
	/* This type was generated from the piece of schema that had
                name = PickupResponse
                Namespace URI = http://schemas.datacontract.org/2004/07/BD.Entities.Pickup
                Namespace Prefix = ns12
	 */


	/**
	 * field for Entity
	 */


	protected org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfEntityBase localEntity ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localEntityTracker = false ;

	public boolean isEntitySpecified(){
		return localEntityTracker;
	}



	/**
	 * Auto generated getter method
	 * @return org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfEntityBase
	 */
	public  org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfEntityBase getEntity(){
		return localEntity;
	}



	/**
	 * Auto generated setter method
	 * @param param Entity
	 */
	public void setEntity(org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfEntityBase param){
		localEntityTracker = true;

		this.localEntity=param;


	}


	/**
	 * field for Flag
	 */


	protected int localFlag ;

	/*  This tracker boolean wil be used to detect whether the user called the set method
	 *   for this attribute. It will be used to determine whether to include this field
	 *   in the serialized XML
	 */
	protected boolean localFlagTracker = false ;

	public boolean isFlagSpecified(){
		return localFlagTracker;
	}



	/**
	 * Auto generated getter method
	 * @return int
	 */
	 public  int getFlag(){
		 return localFlag;
	 }



	 /**
	  * Auto generated setter method
	  * @param param Flag
	  */
	 public void setFlag(int param){

		 // setting primitive attribute tracker to true
		 localFlagTracker =
				 param != java.lang.Integer.MIN_VALUE;

		 this.localFlag=param;


	 }




	 /**
	  *
	  * @param parentQName
	  * @param factory
	  * @return org.apache.axiom.om.OMElement
	  */
	 public org.apache.axiom.om.OMElement getOMElement (
			 final javax.xml.namespace.QName parentQName,
			 final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{



		 org.apache.axiom.om.OMDataSource dataSource =
				 new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
		 return factory.createOMElement(dataSource,parentQName);

	 }

	 public void serialize(final javax.xml.namespace.QName parentQName,
			 javax.xml.stream.XMLStreamWriter xmlWriter)
					 throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
		 serialize(parentQName,xmlWriter,false);
	 }

	 public void serialize(final javax.xml.namespace.QName parentQName,
			 javax.xml.stream.XMLStreamWriter xmlWriter,
			 boolean serializeType)
					 throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{




		 java.lang.String prefix = null;
		 java.lang.String namespace = null;


		 prefix = parentQName.getPrefix();
		 namespace = parentQName.getNamespaceURI();
		 writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);


		 java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://schemas.datacontract.org/2004/07/BD.Entities.Pickup");
		 if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
			 writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
					 namespacePrefix+":PickupResponse",
					 xmlWriter);
		 } else {
			 writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
					 "PickupResponse",
					 xmlWriter);
		 }

		 if (localErrorsTracker){
			 if (localErrors==null){

				 writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Common", "Errors", xmlWriter);

				 // write the nil attribute
				 writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
				 xmlWriter.writeEndElement();
			 }else{
				 localErrors.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","Errors"),
						 xmlWriter);
			 }
		 } if (localEntityTracker){
			 if (localEntity==null){

				 writeStartElement(null, "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup", "Entity", xmlWriter);

				 // write the nil attribute
				 writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
				 xmlWriter.writeEndElement();
			 }else{
				 localEntity.serialize(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","Entity"),
						 xmlWriter);
			 }
		 } if (localFlagTracker){
			 namespace = "http://schemas.datacontract.org/2004/07/BD.Entities.Pickup";
			 writeStartElement(null, namespace, "Flag", xmlWriter);

			 if (localFlag==java.lang.Integer.MIN_VALUE) {

				 throw new org.apache.axis2.databinding.ADBException("Flag cannot be null!!");

			 } else {
				 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlag));
			 }

			 xmlWriter.writeEndElement();
		 }
		 xmlWriter.writeEndElement();


	 }

	 private static java.lang.String generatePrefix(java.lang.String namespace) {
		 if(namespace.equals("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup")){
			 return "ns12";
		 }
		 return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
	 }

	 /**
	  * Utility method to write an element start tag.
	  */
	 private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
			 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
		 java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
		 if (writerPrefix != null) {
			 xmlWriter.writeStartElement(namespace, localPart);
		 } else {
			 if (namespace.length() == 0) {
				 prefix = "";
			 } else if (prefix == null) {
				 prefix = generatePrefix(namespace);
			 }

			 xmlWriter.writeStartElement(prefix, localPart, namespace);
			 xmlWriter.writeNamespace(prefix, namespace);
			 xmlWriter.setPrefix(prefix, namespace);
		 }
	 }

	 /**
	  * Util method to write an attribute with the ns prefix
	  */
	 private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
			 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
		 if (xmlWriter.getPrefix(namespace) == null) {
			 xmlWriter.writeNamespace(prefix, namespace);
			 xmlWriter.setPrefix(prefix, namespace);
		 }
		 xmlWriter.writeAttribute(namespace,attName,attValue);
	 }

	 /**
	  * Util method to write an attribute without the ns prefix
	  */
	 private void writeAttribute(java.lang.String namespace,java.lang.String attName,
			 java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
		 if (namespace.equals("")) {
			 xmlWriter.writeAttribute(attName,attValue);
		 } else {
			 registerPrefix(xmlWriter, namespace);
			 xmlWriter.writeAttribute(namespace,attName,attValue);
		 }
	 }


	 /**
	  * Util method to write an attribute without the ns prefix
	  */
	 private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
			 javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

		 java.lang.String attributeNamespace = qname.getNamespaceURI();
		 java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
		 if (attributePrefix == null) {
			 attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
		 }
		 java.lang.String attributeValue;
		 if (attributePrefix.trim().length() > 0) {
			 attributeValue = attributePrefix + ":" + qname.getLocalPart();
		 } else {
			 attributeValue = qname.getLocalPart();
		 }

		 if (namespace.equals("")) {
			 xmlWriter.writeAttribute(attName, attributeValue);
		 } else {
			 registerPrefix(xmlWriter, namespace);
			 xmlWriter.writeAttribute(namespace, attName, attributeValue);
		 }
	 }
	 /**
	  *  method to handle Qnames
	  */

	 private void writeQName(javax.xml.namespace.QName qname,
			 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
		 java.lang.String namespaceURI = qname.getNamespaceURI();
		 if (namespaceURI != null) {
			 java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
			 if (prefix == null) {
				 prefix = generatePrefix(namespaceURI);
				 xmlWriter.writeNamespace(prefix, namespaceURI);
				 xmlWriter.setPrefix(prefix,namespaceURI);
			 }

			 if (prefix.trim().length() > 0){
				 xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			 } else {
				 // i.e this is the default namespace
				 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
			 }

		 } else {
			 xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
		 }
	 }

	 private void writeQNames(javax.xml.namespace.QName[] qnames,
			 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

		 if (qnames != null) {
			 // we have to store this data until last moment since it is not possible to write any
			 // namespace data after writing the charactor data
			 java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
			 java.lang.String namespaceURI = null;
			 java.lang.String prefix = null;

			 for (int i = 0; i < qnames.length; i++) {
				 if (i > 0) {
					 stringToWrite.append(" ");
				 }
				 namespaceURI = qnames[i].getNamespaceURI();
				 if (namespaceURI != null) {
					 prefix = xmlWriter.getPrefix(namespaceURI);
					 if ((prefix == null) || (prefix.length() == 0)) {
						 prefix = generatePrefix(namespaceURI);
						 xmlWriter.writeNamespace(prefix, namespaceURI);
						 xmlWriter.setPrefix(prefix,namespaceURI);
					 }

					 if (prefix.trim().length() > 0){
						 stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					 } else {
						 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
					 }
				 } else {
					 stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
				 }
			 }
			 xmlWriter.writeCharacters(stringToWrite.toString());
		 }

	 }


	 /**
	  * Register a namespace prefix
	  */
	 private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
		 java.lang.String prefix = xmlWriter.getPrefix(namespace);
		 if (prefix == null) {
			 prefix = generatePrefix(namespace);
			 javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
			 while (true) {
				 java.lang.String uri = nsContext.getNamespaceURI(prefix);
				 if (uri == null || uri.length() == 0) {
					 break;
				 }
				 prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
			 }
			 xmlWriter.writeNamespace(prefix, namespace);
			 xmlWriter.setPrefix(prefix, namespace);
		 }
		 return prefix;
	 }



	 /**
	  * databinding method to get an XML representation of this object
	  *
	  */
	 public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
			 throws org.apache.axis2.databinding.ADBException{



		 java.util.ArrayList elementList = new java.util.ArrayList();
		 java.util.ArrayList attribList = new java.util.ArrayList();


		 attribList.add(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema-instance","type"));
		 attribList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","PickupResponse"));
		 if (localErrorsTracker){
			 elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common",
					 "Errors"));


			 elementList.add(localErrors==null?null:
				 localErrors);
		 } if (localEntityTracker){
			 elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					 "Entity"));


			 elementList.add(localEntity==null?null:
				 localEntity);
		 } if (localFlagTracker){
			 elementList.add(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup",
					 "Flag"));

			 elementList.add(
					 org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFlag));
		 }

		 return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());



	 }



	 /**
	  *  Factory class that keeps the parse method
	  */
	 public static class Factory{




		 /**
		  * static method to create the object
		  * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
		  *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
		  * Postcondition: If this object is an element, the reader is positioned at its end element
		  *                If this object is a complex type, the reader is positioned at the end element of its outer element
		  */
		 public static PickupResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
			 PickupResponse object =
					 new PickupResponse();

			 int event;
			 java.lang.String nillableValue = null;
			 java.lang.String prefix ="";
			 java.lang.String namespaceuri ="";
			 try {

				 while (!reader.isStartElement() && !reader.isEndElement())
					 reader.next();


				 if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
					 java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
							 "type");
					 if (fullTypeName!=null){
						 java.lang.String nsPrefix = null;
						 if (fullTypeName.indexOf(":") > -1){
							 nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
						 }
						 nsPrefix = nsPrefix==null?"":nsPrefix;

						 java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);

						 if (!"PickupResponse".equals(type)){
							 //find namespace for the prefix
							 java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
							 return (PickupResponse)org.tempuri.imports.ExtensionMapper.getTypeObject(
									 nsUri,type,reader);
						 }


					 }


				 }




				 // Note all attributes that were handled. Used to differ normal attributes
				 // from anyAttributes.
				 java.util.Vector handledAttributes = new java.util.Vector();




				 reader.next();


				 while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				 if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Common","Errors").equals(reader.getName())){

					 nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					 if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						 object.setErrors(null);
						 reader.next();

						 reader.next();

					 }else{

						 object.setErrors(org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfErrorBase.Factory.parse(reader));

						 reader.next();
					 }
				 }  // End of if for expected property start element

				 else {

				 }


				 while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				 if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","Entity").equals(reader.getName())){

					 nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					 if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						 object.setEntity(null);
						 reader.next();

						 reader.next();

					 }else{

						 object.setEntity(org.datacontract.schemas._2004._07.bd_entities_common.ArrayOfEntityBase.Factory.parse(reader));

						 reader.next();
					 }
				 }  // End of if for expected property start element

				 else {

				 }


				 while (!reader.isStartElement() && !reader.isEndElement()) reader.next();

				 if (reader.isStartElement() && new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/BD.Entities.Pickup","Flag").equals(reader.getName())){

					 nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
					 if ("true".equals(nillableValue) || "1".equals(nillableValue)){
						 throw new org.apache.axis2.databinding.ADBException("The element: "+"Flag" +"  cannot be null");
					 }


					 java.lang.String content = reader.getElementText();

					 object.setFlag(
							 org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

					 reader.next();

				 }  // End of if for expected property start element

				 else {

					 object.setFlag(java.lang.Integer.MIN_VALUE);

				 }

				 while (!reader.isStartElement() && !reader.isEndElement())
					 reader.next();

				 if (reader.isStartElement())
					 // A start element we are not expecting indicates a trailing invalid property
					 throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());




			 } catch (javax.xml.stream.XMLStreamException e) {
				 throw new java.lang.Exception(e);
			 }

			 return object;
		 }

	 }//end of factory class



}

