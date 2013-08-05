package com.helpezee.dto.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 
 
/**
 * <p>Java class for address complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pincode" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(name="address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address", propOrder = {
    "street",
    "city",
    "state",
    "country",
    "pincode"
})
public class Address {
 
    @XmlElement(required = true)
    protected String street;
    @XmlElement(required = true)
    protected String city;
    @XmlElement(required = true)
    protected String state;
    @XmlElement(required = true)
    protected String country;
    protected long pincode;
 
    /**
     * Gets the value of the street property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *    
     */
    public String getStreet() {
        return street;
    }
 
    /**
     * Sets the value of the street property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *    
     */
    public void setStreet(String value) {
        this.street = value;
    }
 
    /**
     * Gets the value of the city property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *    
     */
    public String getCity() {
        return city;
    }
 
    /**
     * Sets the value of the city property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *    
     */
    public void setCity(String value) {
        this.city = value;
    }
 
    /**
     * Gets the value of the state property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *    
     */
    public String getState() {
        return state;
    }
 
    /**
     * Sets the value of the state property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *    
     */
    public void setState(String value) {
        this.state = value;
    }
 
    /**
     * Gets the value of the country property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *    
     */
    public String getCountry() {
        return country;
    }
 
    /**
     * Sets the value of the country property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *    
     */
    public void setCountry(String value) {
        this.country = value;
    }
 
    /**
     * Gets the value of the pincode property.
     *
     */
    public long getPincode() {
        return pincode;
    }
 
    /**
     * Sets the value of the pincode property.
     *
     */
    public void setPincode(long value) {
        this.pincode = value;
    }
}