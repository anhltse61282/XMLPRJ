/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.dbutil;

import com.demo.dbutil.ValidationHandler;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author HongLinh
 */
public class XMLUtils {

    public static <T> boolean validateJAXBObject(T entity, String xsdPath) {
        try {
            JAXBContext jc = JAXBContext.newInstance(entity.getClass());
            JAXBSource source = new JAXBSource(jc, entity);

            SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = sf.newSchema(new File(xsdPath));

            Validator validator = schema.newValidator();
            validator.setErrorHandler(new ValidationHandler());
            validator.validate(source);
        } catch (Exception ex) {
            Logger.getLogger(XMLUtils.class.getName()).log(Level.SEVERE, null, ex);
            
            return false;
        }
        return true;
    }
}
