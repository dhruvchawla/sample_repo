package com.bluedart.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;

/**
 * 
 * @author DH839598
 *
 */
public class Converter {

	private Converter() {
	}

	private static StringWriter stringWriter = new StringWriter();

	/**
	 * This method Convert Java Object to XMl Object. This method able to return
	 * as string and stored into given file also
	 * 
	 * @param element
	 * @param FILE_PATH_NAME
	 * @throws JAXBException
	 * @return String
	 */
	public static <E> String convertJavaObjTOXmlObj(E element, String FILE_PATH_NAME) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(element.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		if (FILE_PATH_NAME != null) {
			marshaller.marshal(element, new File(FILE_PATH_NAME));
		}
		marshaller.marshal(element, stringWriter);
		return stringWriter.toString();
	}

	/**
	 * This method convert XML Object to Java Object. This method will allow XML
	 * Input as file or String
	 * 
	 * @param element
	 * @param FILE_PATH_NAME
	 * @param xmlStr
	 * @return Object
	 */
	public static <E> Object convertXmlObjTOJavaObj(E element, String FILE_PATH_NAME, String xmlStr)
			throws JAXBException {
		Object object = null;
		JAXBContext context = JAXBContext.newInstance(element.getClass());
		Unmarshaller unmarshaller = context.createUnmarshaller();
		if (FILE_PATH_NAME != null) {
			object = unmarshaller.unmarshal(new File(FILE_PATH_NAME));
		} else if (xmlStr != null) {
			StringReader reader = new StringReader(xmlStr);
			object = unmarshaller.unmarshal(reader);
		}
		return object;
	}

	/**
	 * This method convert Java Object to Json Object This method able to return
	 * as string and stored into given file also
	 * 
	 * @param element
	 * @param FILE_PATH_NAME
	 * @return String
	 * @throws IOException
	 */
	public static <E> String convertJavaObjTOJsonObj(E element, String FILE_PATH_NAME) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		if (FILE_PATH_NAME != null) {
			mapper.writeValue(new File(FILE_PATH_NAME), element);
		}
		String jsonInString = mapper.writeValueAsString(element);
		jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(element);
		return jsonInString;
	}

	/**
	 * This method convert Json Object to Java Object. This method will allow
	 * Json Input as file or String
	 * 
	 * @param element
	 * @param FILE_PATH_NAME
	 * @param jsonStr
	 * @return Object
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static <E> Object convertJsonObjTOJavaObj(E element, String FILE_PATH_NAME, String jsonStr)
			throws JsonParseException, JsonMappingException, IOException {
		Object object = null;
		ObjectMapper mapper = new ObjectMapper();
		if (FILE_PATH_NAME != null) {
			object = mapper.readValue(new File(FILE_PATH_NAME), element.getClass());
		} else if (jsonStr != null) {
			object = mapper.readValue(jsonStr, element.getClass());
		}
		return object;
	}

	/**
	 * @author : Subhransu kumar Maharana
	 * @Description : This Method is used to convert list of generic objects
	 *              into formatted text file
	 * @CreateDate : 8th June 2016
	 * @param objs
	 * @param FILE_PATH_NAME
	 * @return
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <E> byte[] convertJavaObjToTextFile(List<E> objs, String FILE_PATH_NAME)
			throws IOException, IllegalArgumentException, IllegalAccessException {
		String borderTop = "----------------------------------------------------------------------------";
		String borderBottom = "----------------------------------------------------------------------------";
		ByteArrayOutputStream byteArrayOutputStream = null;
		try (PrintWriter pw = new PrintWriter(new FileOutputStream(FILE_PATH_NAME))) {

			// To Output to Byte array
			byteArrayOutputStream = new ByteArrayOutputStream();

			Class<?> objClass = objs.get(0).getClass();
			Field[] fields = objClass.getDeclaredFields();
			int[] fieldMaxLength = new int[fields.length];

			ArrayList<String> listOfFieldName = new ArrayList<>();
			for (Field field : fields)
				listOfFieldName.add(field.getName());

			String[] fieldNameArray = new String[listOfFieldName.size()];
			fieldNameArray = listOfFieldName.toArray(fieldNameArray);
			for (int i = 0; i < listOfFieldName.size(); i++) {
				int fieldNameSize = listOfFieldName.get(i).length();
				if (fieldMaxLength[i] < fieldNameSize)
					fieldMaxLength[i] = fieldNameSize + 1;
			}

			for (Object obj : objs) {
				ArrayList<String> listOfFieldValues = new ArrayList<>();
				for (Field field : fields) {
					field.setAccessible(true);
					listOfFieldValues.add(field.get(obj).toString());
				}
				for (int i = 0; i < listOfFieldValues.size(); i++) {
					int fieldValueSize = listOfFieldValues.get(i).length();
					if (fieldMaxLength[i] < fieldValueSize)
						fieldMaxLength[i] = fieldValueSize + 1;
				}
			}

			StringBuffer formatStrBuffer = new StringBuffer();
			for (int length : fieldMaxLength)
				formatStrBuffer.append("%-" + length + "s");
			formatStrBuffer.append(" %n");

			String formatStr = formatStrBuffer.toString();
			pw.println(borderTop);
			pw.print(String.format(formatStr, fieldNameArray));
			pw.println(borderBottom);
			for (Object obj : objs) {
				ArrayList<String> listOfFieldValues = new ArrayList<>();
				for (Field field : fields) {
					field.setAccessible(true);
					Object fieldValue = field.get(obj);
					listOfFieldValues.add(fieldValue.toString());
				}

				String[] fieldArray = new String[listOfFieldValues.size()];
				fieldArray = listOfFieldValues.toArray(fieldArray);
				pw.print(String.format(formatStr, fieldArray));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return byteArrayOutputStream.toByteArray();
	}

	/*public static <E> void convertJavaObjsToPdf(List<E> objs, String FILE_PATH_NAME) {
		try {
			OutputStream file = new FileOutputStream(new File(FILE_PATH_NAME));
			Document document = new Document();
			PdfWriter.getInstance(document, file);
			document.open();
			String string = Converter.convertJavaObjsToFormattedString(objs, FILE_PATH_NAME);
			System.out.println(string);
			document.add(new Paragraph(string));
			document.close();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * @author : Subhransu kumar Maharana
	 * @Description : This Method is used to convert list of generic objects
	 *              into formatted String
	 * @CreateDate :
	 * @param objs
	 * @param outputPath
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static <E> String convertJavaObjsToFormattedString(List<E> objs, String outputPath)
			throws IllegalArgumentException, IllegalAccessException {
		String borderTop = "----------------------------------------------------------------------------";
		String borderBottom = "----------------------------------------------------------------------------";
		StringBuffer result = new StringBuffer();

		Class<?> objClass = objs.get(0).getClass();
		Field[] fields = objClass.getDeclaredFields();
		int[] fieldMaxLength = new int[fields.length];

		ArrayList<String> listOfFieldName = new ArrayList<>();
		for (Field field : fields)
			listOfFieldName.add(field.getName());

		String[] fieldNameArray = new String[listOfFieldName.size()];
		fieldNameArray = listOfFieldName.toArray(fieldNameArray);
		for (int i = 0; i < listOfFieldName.size(); i++) {
			int fieldNameSize = listOfFieldName.get(i).length();
			if (fieldMaxLength[i] < fieldNameSize)
				fieldMaxLength[i] = fieldNameSize + 1;
		}

		for (Object obj : objs) {
			ArrayList<String> listOfFieldValues = new ArrayList<>();
			for (Field field : fields) {
				field.setAccessible(true);
				listOfFieldValues.add(field.get(obj).toString());
			}
			for (int i = 0; i < listOfFieldValues.size(); i++) {
				int fieldValueSize = listOfFieldValues.get(i).length();
				if (fieldMaxLength[i] < fieldValueSize)
					fieldMaxLength[i] = fieldValueSize + 1;
			}

		}

		StringBuffer formatStrBuffer = new StringBuffer();
		for (int length : fieldMaxLength) {
			formatStrBuffer.append("%-" + length + "s");
		}
		formatStrBuffer.append(" %n");

		String formatStr = formatStrBuffer.toString();
		result.append(borderTop + "\n");
		result.append(String.format(formatStr, fieldNameArray));
		result.append(borderBottom + "\n");

		for (Object obj : objs) {
			ArrayList<String> listOfFieldValues = new ArrayList<>();
			for (Field field : fields) {
				field.setAccessible(true);
				Object fieldValue = field.get(obj);
				listOfFieldValues.add(fieldValue.toString());
			}

			String[] fieldArray = new String[listOfFieldValues.size()];
			fieldArray = listOfFieldValues.toArray(fieldArray);
			result.append(String.format(formatStr, fieldArray));
		}
		return result.toString();
	}

	public static String objToString(Object object) {
		return object == null ? "" : object.toString();
	}
}
