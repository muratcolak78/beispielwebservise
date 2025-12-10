package com.allcompare.bingoastradirectwebservice.utils.exception;


public class ExtractXmlSectionException extends RuntimeException {

    private static final String INVALID_SECTION_EXCEPTION = "XmlSection is invalid. Schema should be : \n<tag>Value</tag>\n<otherTag>otherValue</otherTag>\n";

    public ExtractXmlSectionException(String message) {
        super(INVALID_SECTION_EXCEPTION + message);
    }
}