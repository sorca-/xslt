<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:param name="category" />
    <xsl:param name="subcategory" />

    <xsl:param name="new">
        <Resource name="abc..."/>
        <Environment name="xyz..."/>
    </xsl:param>

    <xsl:template match="/shop">
        <xsl:copy>
            <xsl:copy-of select="@* | node()"/>
            <xsl:copy-of select=""/>
        </xsl:copy>
    </xsl:template>

</xsl:stylesheet>