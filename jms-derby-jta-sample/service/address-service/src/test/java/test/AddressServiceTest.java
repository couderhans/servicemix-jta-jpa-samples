package test;

import be.anova.samples.servicemix.model.entity.User;
import be.anova.samples.servicemix.service.AddressService;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Hans Couder
 * Date: 12/21/12
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
        {
                "classpath:META-INF/spring/test-context.xml",
                "classpath:META-INF/spring/bundle-context.xml"
        })
@TransactionConfiguration(transactionManager = "jpaTransactionManager")
public class AddressServiceTest extends AbstractJUnit4SpringContextTests {

    static SimpleNamingContextBuilder builder;
    static JAXBContext jaxbContext;

    @Resource
    AddressService addressService;

    EntityManager entityManager;

    @BeforeClass
    public static void setUpClass() throws Exception, JAXBException, IOException, SQLException {
        //JNDI setup
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.apache.derby.jdbc.EmbeddedDataSource40");
        dataSource.setUrl("jdbc:derby:target/testdb;create=true");

        dataSource.setDefaultAutoCommit(false);

        builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
        builder.bind("osgi:service/javax.sql.DataSource/(osgi.jndi.service.name=jdbc/dataSource/address)", dataSource);

        //jaxbContext setup
        //jaxbContext = JAXBContext.newInstance(ObjectFactory.class.getPackage().getName(), ObjectFactory.class.getClassLoader());

        Thread.sleep(1000);
    }

    @Before
    public void setUp() throws Exception {
        EntityManagerFactory emf = applicationContext.getBean("entityManagerFactory", EntityManagerFactory.class);
        entityManager = emf.createEntityManager();
    }

    @Test
    public void testAddress() throws Exception {
        System.out.println("testAcceptorContractManagement");
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        User user = (User) unmarshaller.unmarshal(new File("src/test/resources/META-INF/samples/user0.xml"));
        Assert.assertNotNull(user);

    }

}
