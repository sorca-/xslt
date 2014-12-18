<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" />
    <xsl:template match="/">
        <html>
            <head>
                <link href="css/style.css" rel="stylesheet" />
                <title>Category</title>
            </head>
            <body>
                <h1>Category:</h1>
                <hr />
                <xsl:for-each select="shop/category">
                    <xsl:call-template name="show-category"/>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>


    <xsl:template name="show-category">
        <xsl:param name="category" select="@name" />
        <div>
            <a href="shop?command=show_subcategory&amp;category={$category}">
                <xsl:value-of select="$category"/>
                [<xsl:value-of select="count(/shop/category[@name=$category]/subcategory)"/>]
            </a>
        </div>
    </xsl:template>
</xsl:stylesheet>