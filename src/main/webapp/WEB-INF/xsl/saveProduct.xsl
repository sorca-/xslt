<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:validator="xalan://com.epam.shop.validator.EntityValidator">
    <xsl:param name="validator"/>
    <xsl:param name="category"/>
    <xsl:param name="subcategory"/>

    <xsl:template match="/">
        <xsl:choose>
            <xsl:when test="validator:isProductValid($validator)">
                <xsl:apply-templates />
            </xsl:when>
            <xsl:otherwise>

            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>



    <!-- Attribute : match Optional. An XPath expression or expressions that
        this template will be applied to. Note if this is omitted, then a name attribute
        must be used. Either a namoe or a match are to be used, but not both. -->
    <xsl:template match="node()|@*">
        <xsl:copy>
            <!-- Attribute : select Optional. Specifies the XPath criteria to be used
                to apply the templates. -->
            <xsl:apply-templates select="node()|@*" />
        </xsl:copy>
    </xsl:template>

    <xsl:template name="saveProduct"
                  match="shop/category[@name=$category]/subcategory[@name=$subcategory]">
        <xsl:copy>
            <xsl:apply-templates select="node()|@*" />
            <xsl:element name="product">
                <xsl:element name="producer">
                    <xsl:value-of select="validator:getProducer($validator)" />
                </xsl:element>
                <xsl:element name="model">
                    <xsl:value-of select="validator:getModel($validator)" />
                </xsl:element>
                <xsl:element name="dateOfIssue">
                    <xsl:value-of select="validator:getDateOfIssue($validator)" />
                </xsl:element>
                <xsl:element name="color">
                    <xsl:value-of select="validator:getColor($validator)" />
                </xsl:element>
                <xsl:choose>
                    <xsl:when test="validator:getPrice($validator) != '0'">
                        <xsl:element name="price">
                            <xsl:value-of select="validator:getPrice($validator)" />
                        </xsl:element>
                    </xsl:when>
                    <xsl:otherwise>
                        <xsl:element name="outOfStock" />
                    </xsl:otherwise>
                </xsl:choose>
            </xsl:element>
        </xsl:copy>
    </xsl:template>


</xsl:stylesheet>