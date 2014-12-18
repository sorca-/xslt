package com.epam.shop.command;

import com.epam.shop.command.impl.*;

public enum CommandEnum {
    CREATE {
        {
            this.command = new ShowFormOfAdditionCommand();
        }
    },
    SAVE {
        {
            this.command = new SaveProductCommand();
        }
    },
    SHOW_CATEGORY {
        {
            this.command = new ShowCategoryCommand();
        }
    },
    SHOW_SUBCATEGORY {
        {
            this.command = new ShowSubcategoryCommand();
        }
    },
    SHOW_PRODUCTS {
        {
            this.command = new ShowProductsCommand();
        }
    };

    AbstractCommand command;
    public AbstractCommand getCurrentCommand() {
        return command;
    }
}


