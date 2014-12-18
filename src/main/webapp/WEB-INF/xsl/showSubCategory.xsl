<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" />
    <xsl:param name="category"/>
    <xsl:template match="/">
        <html>
            <head>
                <link href="css/style.css" rel="stylesheet" />
                <title>Subcategory</title>
            </head>
            <body>
                <h1>Subcategory:</h1>
                <hr />
                <xsl:for-each select="shop/category[@name=$category]/subcategory">
                    <xsl:call-template name="show-subcategory"/>
                </xsl:for-each>
                <div>
                    <form action="shop" method="post">
                        <input type="hidden" name="command" value="show_category"/>
                        <button class="btn" type="submit" name="back">Back</button>
                    </form>
                </div>
            </body>
        </html>
    </xsl:template>


    <xsl:template name="show-subcategory">
        <xsl:param name="subcategory" select="@name" />
        <div>
            <a href="shop?command=show_products&amp;category={$category}&amp;subcategory={$subcategory}">
                <xsl:value-of select="$subcategory" />
                [<xsl:value-of select="count(/shop/category[@name=$category]/subcategory[@name=$subcategory]/product)"/>]
            </a>
        </div>
    </xsl:template>
</xsl:stylesheet>