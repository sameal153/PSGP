

/**
 * ClassName: DmnDbSchemaManager
 * Package: org.flowable.dmn.engine.impl.db
 * Description:
 *
 * @Author ZackCao
 * @Create 2023/10/12 16:15
 * @Version 1.0
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.flowable.dmn.engine.impl.db;

import org.flowable.common.engine.impl.db.EngineDatabaseConfiguration;
import org.flowable.common.engine.impl.db.LiquibaseBasedSchemaManager;
import org.flowable.common.engine.impl.db.LiquibaseDatabaseConfiguration;
import org.flowable.common.engine.impl.db.SchemaManager;
import org.flowable.dmn.engine.impl.util.CommandContextUtil;

public class DmnDbSchemaManager extends LiquibaseBasedSchemaManager {
    public static final String LIQUIBASE_CHANGELOG = "classpath:ruoyi-admin/src/main/resources/org/flowable/dmn/db/liquibase/custom-flowable-dmn-db-changelog.xml.tld";

    public DmnDbSchemaManager() {
        super("dmn", "org/flowable/dmn/db/liquibase/flowable-dmn-db-changelog.xml", "ACT_DMN_");
    }

    protected LiquibaseDatabaseConfiguration getDatabaseConfiguration() {
        return new EngineDatabaseConfiguration(CommandContextUtil.getDmnEngineConfiguration());
    }

    public void initSchema() {
        this.initSchema(CommandContextUtil.getDmnEngineConfiguration().getDatabaseSchemaUpdate());
    }

    public void schemaCreate() {
        this.getCommonSchemaManager().schemaCreate();
        super.schemaCreate();
    }

    public void schemaDrop() {
        try {
            super.schemaDrop();
        } catch (Exception var3) {
            this.logger.info("Error dropping dmn engine tables", var3);
        }

        try {
            this.getCommonSchemaManager().schemaDrop();
        } catch (Exception var2) {
            this.logger.info("Error dropping common tables", var2);
        }

    }

    public String schemaUpdate() {
        this.getCommonSchemaManager().schemaUpdate();
        return super.schemaUpdate();
    }

    protected SchemaManager getCommonSchemaManager() {
        return CommandContextUtil.getDmnEngineConfiguration().getCommonSchemaManager();
    }
}

