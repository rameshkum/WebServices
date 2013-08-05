package com.helpezee.dto.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 
 
/**
 * <p>Java class for customer complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="customer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="address" type="{}address"/>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
    "address",
    "customerId",
    "customerName",
    "phone"
})
public class Customer {
 
    @XmlElement(required = true)
    protected Address address;
    protected long customerId;
    @XmlElement(required = true)
    protected String customerName;
    protected long phone;
 
    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link Address }
     *    
     */
    public Address getAddress() {
        return address;
    }
 
    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link Address }
     *    
     */
    public void setAddress(Address value) {
        this.address = value;
    }
 
    /**
     * Gets the value of the customerId property.
     *
     */
    public long getCustomerId() {
        return customerId;
    }
 
    /**
     * Sets the value of the customerId property.
     *
     */
    public void setCustomerId(long value) {
        this.customerId = value;
    }
 
    /**
     * Gets the value of the customerName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *    
     */
    public String getCustomerName() {
        return customerName;
    }
 
    /**
     * Sets the value of the customerName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *    
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }
 
    /**
     * Gets the value of the phone property.
     *
     */
    public long getPhone() {
        return phone;
    }
 
    /**
     * Sets the value of the phone property.
     *
     */
    public void setPhone(long value) {
        this.phone = value;
    }
}