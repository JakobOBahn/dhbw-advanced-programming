package de.dhbw.course6.study;

public interface XmlAdapter {

    // Purpose: plain text (string) --> xml
    public String toXml(String plainText);

    // Purpose: xml --> plain text (string)
    public String fromXml(String xml) throws Exception;

    public String adapt(String xmlOrPlainText) throws Exception;

}