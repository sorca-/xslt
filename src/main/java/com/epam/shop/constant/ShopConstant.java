package com.epam.shop.constant;

/**
 * The Class ShopConstant.
 */
public final class ShopConstant {

    /**
     * Instantiates a new shop constant.
     */
    private ShopConstant() {
        super();
    }
    /** The Constant COMMAND_PARAM_SHOW_CATEGORY. */
//    public static final String COMMAND_PARAM_SHOW_CATEGORY = "showCategory";

    /** The Constant COMMAND_PARAM_SHOW_SUBCATEGORY. */
//    public static final String COMMAND_PARAM_SHOW_SUBCATEGORY = "showSubcategory";

    /** The Constant COMMAND_PARAM_SHOW_PRODUCTS. */
    public static final String COMMAND_PARAM_SHOW_PRODUCTS = "showProducts";

    /** The Constant COMMAND_PARAM_CREATE_PRODUCT. */
//    public static final String COMMAND_PARAM_CREATE_PRODUCT = "createProduct";

    /** The Constant COMMAND_PARAM_SAVE_PRODUCT. */
//    public static final String COMMAND_PARAM_SAVE_PRODUCT = "saveProduct";

    /** The Constant PARAM_CATEGORY. */
    public static final String PARAM_CATEGORY = "category";

    /** The Constant PARAM_SUBCATEGORY. */
    public static final String PARAM_SUBCATEGORY = "subcategory";

    /** The Constant PARAM_PRODUCT. */
    public static final String PARAM_PRODUCT = "product";

    /** The Constant PARAM_PRODUCER. */
    public static final String PARAM_PRODUCER = "producer";

    /** The Constant PARAM_COLOR. */
    public static final String PARAM_COLOR = "color";

    /** The Constant PARAM_MODEL. */
    public static final String PARAM_MODEL = "model";

    /** The Constant PARAM_DATE_OF_ISSUE. */
    public static final String PARAM_DATE_OF_ISSUE = "dateOfIssue";

    /** The Constant PARAM_PRICE. */
    public static final String PARAM_PRICE = "price";

    /** The Constant PARAM_IN_STOCK. */
    public static final String PARAM_IN_STOCK = "inStock";

    /** The Constant PARAM_ON. */
    public static final String PARAM_ON = "on";

    /** The Constant PARAM_DATE_FORMAT. */
    public static final String PARAM_DATE_FORMAT = "dd-MM-yyyy";

    /** The Constant VALIDATION_DATE. */
    public static final String VALIDATION_DATE = "dateOfIssueError";

    /** The Constant VALIDATION_COLOR. */
    public static final String VALIDATION_COLOR = "colorError";

    /** The Constant VALIDATION_MODEL. */
    public static final String VALIDATION_MODEL = "modelError";

    /** The Constant VALIDATION_PRODUCER. */
    public static final String VALIDATION_PRODUCER = "producerError";

    /** The Constant VALIDATION_PRICE. */
    public static final String VALIDATION_PRICE = "priceError";

    /** The Constant PARAM_COMMAND. */
    public static final String PARAM_COMMAND = "command";



    //Path
    public static final String XSL_ADD_PRODUCT = "/WEB-INF/xsl/showFormOfAddition.xsl";
    public static final String XSL_SAVE_PRODUCT = "/WEB-INF/xsl/saveProduct.xsl";
    public static final String XSL_CATEGORY = "/WEB-INF/xsl/showCategory.xsl";
    public static final String XSL_SUBCATEGORY = "/WEB-INF/xsl/showSubCategory.xsl";
    public static final String XSL_PRODUCTS = "/WEB-INF/xsl/showProduct.xsl";
    public static final String XML_SHOP = "/WEB-INF/xml/shop.xml";
    public static final String XML_SHOP_TEST = "/WEB-INF/xml/shopTest.xml";


    //Param



    /** The Constant CONTENT_TYPE. */
    public static final String CONTENT_TYPE = "text/html";
}