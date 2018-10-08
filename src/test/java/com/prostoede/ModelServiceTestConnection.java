package com.prostoede;

import com.prostoede.service.ModelService;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FullXmlDataFileLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.ContextConfiguration;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author ProstoEde
 */
@ContextConfiguration("classpath:/ApplicationContext.xml")
public class ModelServiceTestConnection {
    @Autowired
    private ModelService modelService;
    @Autowired
    private DataSource dataSource;

    private Connection connect= null;

    public ModelService getModelService() {
        return modelService;
    }

    public IDatabaseConnection getDbConnection() throws Exception{
        connect = DataSourceUtils.getConnection(dataSource);
        IDatabaseConnection databaseConnection = new DatabaseConnection(connect);
        return databaseConnection;
    }

    public IDataSet getLoader(String contentDB){
        FullXmlDataFileLoader loader = new FullXmlDataFileLoader();
        IDataSet xmlDataSet = loader.load(contentDB);
        return xmlDataSet;

    }

    public void initDataBaseTest1() throws Exception{
        DatabaseOperation.DELETE_ALL.execute(getDbConnection(), getLoader("/contentBD/cleaner.xml"));
    }

    public void initDataBaseTest2() throws Exception{
        DatabaseOperation.CLEAN_INSERT.execute(getDbConnection(), getLoader("/contentBD/write.xml"));
    }

}
