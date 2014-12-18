<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8" />
    <xsl:param name="category"/>
    <xsl:param name="subcategory"/>

    <xsl:template match="/">
        <html>
            <head>
                <link href="css/style.css" rel="stylesheet" />
                <title>Products:</title>
            </head>
            <body>
                <h1>Products</h1>
                <hr />
                <div class="btn-container">
                    <form action="shop" method="post">
                        <input type="hidden" name="command" value="show_subcategory"/>
                        <input type="hidden" name="category" value="{$category}"/>
                        <input type="hidden" name="subcategory" value="{$subcategory}"/>
                        <button class="btn right" type="submit" name="back">Back</button>
                    </form>
                    <form action="shop" method="post">
                        <input type="hidden" name="command" value="create"/>
                        <input type="hidden" name="category" value="{$category}"/>
                        <input type="hidden" name="subcategory" value="{$subcategory}"/>
                        <button class="btn left" type="submit" name="addProduct">Add product</button>
                    </form>
                </div>
                <table border="1">
                    <tr>
                        <th>Producer:</th>
                        <th>Model:</th>
                        <th>Data of issue:</th>
                        <th>Color:</th>
                        <th>Price:</th>
                        <th>In stock:</th>
                    </tr>
                    <xsl:for-each select="shop/category[@name=$category]/subcategory[@name=$subcategory]/product">
                        <xsl:call-template name="show-products" />
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>


    <xsl:template name="show-products">
        <tr>
            <td>
                <xsl:value-of select="producer" />
            </td>
            <td>
                <xsl:value-of select="model" />
            </td>
            <td>
                <xsl:value-of select="dateOfIssue" />
            </td>
            <td>
                <xsl:value-of select="color" />
            </td>
            <td>
                <xsl:value-of select="price"/>
            </td>
            <td>
                <xsl:value-of select="inStock"/>
            </td>
        </tr>
        <br />
    </xsl:template>

</xsl:stylesheet>