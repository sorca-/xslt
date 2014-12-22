<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:product="com.epam.shop.entities.Product"
                xmlns:validator="com.epam.shop.validator.EntityValidator">

    <xsl:param name="product"/>
    <xsl:param name="validator"/>


    <xsl:template match="/">
        <xsl:call-template name="showFormOfAddition"/>
    </xsl:template>

    <xsl:template name="showFormOfAddition">
        <xsl:param name="category" select="product:getCategory($product)" />
        <xsl:param name="subcategory" select="product:getSubcategory($product)" />
        <xsl:param name="producer" select="product:getProducer($product)" />
        <xsl:param name="model" select="product:getModel($product)" />
        <xsl:param name="dateOfIssue" select="product:getDateOfIssue($product)" />
        <xsl:param name="color" select="product:getColor($product)" />
        <xsl:param name="price" select="product:getPrice($product)" />
        <xsl:param name="inStock" select="product:isInStock($product)" />

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
                                <input id="producer" type="text" name="producer" size="25" value="{$producer}"/>
                                <label class="error-label">
                                    <xsl:if test="not(validator:isProducerValid($validator))">
                                        <span class="error">
                                            <br/>
                                            <xsl:value-of select="validator:errorMessageForProducer($validator)" />
                                        </span>
                                    </xsl:if>
                                </label>
                            </div>

                            <div class="input-block">
                                <label class="name-label" for="model">Model:</label>
                                <input id="model" type="text" name="model" size="25" value="{$model}"/>
                                <label class="error-label">
                                    <xsl:if test="not(validator:isProducerValid($validator))">
                                        <span class="error">
                                            <br/>
                                            <xsl:value-of select="validator:errorMessageForModel($validator)" />
                                        </span>
                                    </xsl:if>
                                </label>
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="date">Date of issue:</label>
                                <input id="date" type="text" name="dateOfIssue" size="25" value="{$dateOfIssue}" />
                                <label class="error-label">
                                    <xsl:if test="not(validator:isDateOfIssueValid($validator))">
                                        <span class="error">
                                            <br/>
                                            <xsl:value-of select="validator:errorMessageForDate($validator)" />
                                        </span>
                                    </xsl:if>
                                </label>
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="color">Color:</label>
                                <input id="color" type="text" name="color" size="25" value="{$color}"/>
                                <label class="error-label">
                                    <xsl:if test="not(validator:isColorValid($validator))">
                                        <span class="error">
                                            <br/>
                                            <xsl:value-of select="validator:errorMessageForColor($validator)" />
                                        </span>
                                    </xsl:if>
                                </label>
                            </div>
                            <div class="input-block">
                                <label class="name-label" for="price">Price:</label>
                                <input id="price" type="text" name="price" size="25" value="{$price}"/>
                                <label class="error-label">
                                    <xsl:if test="not(validator:isPriceValid($validator))">
                                        <span class="error">
                                            <br/>
                                            <xsl:value-of select="validator:errorMessageForPrice($validator)" />
                                        </span>
                                    </xsl:if>
                                </label>
                            </div>
                            <div style="input-block">
                                <label class="name-label" for="inStock">In stock:</label>
                                <input id="inStock" type="checkbox" checked="checked" value="{$inStock}" name="inStock"/>
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