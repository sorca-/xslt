<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8" />
    <xsl:param name="category"/>
    <xsl:param name="subcategory"/>

    <xsl:template match="/">
        <xsl:call-template name="form-of-addition" />
    </xsl:template>

    <xsl:template name="form-of-addition">
        <html>
            <head>
                <link href="css/style.css" rel="stylesheet" />
                <title>Creating product</title>
            </head>
            <body>
                <div class="container">
                    <h2>Creating product.</h2>
                    <hr/>
                    <form action="shop" method="post">
                        <div class="inner-block">
                            <div class="input-block">
                                <label class="name-label" for="category">Category:</label>
                                <input id="category" type="text" name="category" size="25" value="{$category}" readonly="readonly"/>
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="subcategory">Subcategory:</label>
                                <input id="subcategory" type="text" name="subcategory" size="25" value="{$subcategory}" readonly="readonly"/>
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="producer">Producer:</label>
                                <input id="producer" type="text" name="producer" size="25"/>
                                <!--<label class="error-label">-->
                                <!--<xsl:value-of select="$producerError" />-->
                                <!--</label>-->
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="model">Model:</label>
                                <input id="model" type="text" name="model" size="25"/>
                                <!--<label class="error-label">-->
                                <!--<xsl:value-of select="$modelError"/>-->
                                <!--</label>-->
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="date">Date of issue:</label>
                                <input id="date" type="text" name="dateOfIssue" size="25"/>
                                <!--<label class="error-label">-->
                                <!--<xsl:value-of select="$dateOfIssueError" />-->
                                <!--</label>-->
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="color">Color:</label>
                                <input id="color" type="text" name="color" size="25"/>
                                <!--<label class="error-label">-->
                                <!--<xsl:value-of select="$colorError" />-->
                                <!--</label>-->
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="price">Price:</label>
                                <input id="price" type="text" name="price" size="25"/>
                                <!--<label class="error-label">-->
                                <!--<xsl:value-of select="$priceError" />-->
                                <!--</label>-->
                            </div>
                            <div style="input-block">
                                <label class="name-label" for="inStock">In stock:</label>
                                <input id="inStock" type="checkbox" checked="checked" value="true" name="inStock"/>
                            </div>
                            <div>
                                <button class="btn" type="reset">Clear form</button>
                                <input type="hidden" name="command" value="save" />
                                <input type="hidden" name="category" value="{$category}"/>
                                <input type="hidden" name="subcategory" value="{$subcategory}"/>
                                <button class="btn" type="submit" name="save">Save</button>
                            </div>
                        </div>
                    </form>
                    <form action="shop" method="post">
                        <div class="cancel-btn">
                            <input type="hidden" name="command" value="show_products" />
                            <input type="hidden" name="category" value="{$category}"/>
                            <input type="hidden" name="subcategory" value="{$subcategory}"/>
                            <button class="btn" type="submit" name="cancel">Cancel</button>
                        </div>
                    </form>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>