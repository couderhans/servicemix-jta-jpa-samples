package be.anova.samples.servicemix.model.entity;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Created with IntelliJ IDEA.
 * User: Hans Couder
 * Date: 12/21/12
 * Time: 12:47 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Address createAddress() {
        return new Address();
    }

}
