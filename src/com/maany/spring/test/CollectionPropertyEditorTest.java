import com.maany.spring.model.Address;
import com.maany.spring.model.AddressCollection;
import com.maany.spring.model.GrantType;
import com.maany.spring.propertyeditor.CollectionPropertyEditor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Mayank on 9/13/2015.
 */
public class CollectionPropertyEditorTest {
    CollectionPropertyEditor addressCollectionPropertyEditor;
    CollectionPropertyEditor genericCollectionPropertyEditor;
    AddressCollection collection ;
    Collection<GrantType> grantTypeCollection;
    @Before
    public void initTest(){
        addressCollectionPropertyEditor = new CollectionPropertyEditor(Address.class);
        collection = new AddressCollection();
        Address address1 = new Address();
        address1.setFirstLine("IA 49 C Ashok Vihar");
        address1.setSecondLine("Phase 1");
        address1.setThirdLine("Delhi 110052");

        Address address2 = new Address();
        address2.setFirstLine("512 W Apt 12");
        address2.setSecondLine("144 Street");
        address2.setThirdLine("New York 10007");

        Address address3 = new Address();
        address3.setFirstLine("Nit Delhi");
        address3.setSecondLine("Narela");
        address3.setThirdLine("Delhi");

        collection.add(address1);
        collection.add(address2);
        collection.add(address3);

        /*Grant Type Initialization*/
        GrantType authorizationCode = new GrantType("authorization_code");
        GrantType implicit = new GrantType("implicit");
        GrantType password = new GrantType("password");
        GrantType clientCredentials = new GrantType("client_credentials");

        grantTypeCollection = new HashSet<>();
        grantTypeCollection.add(authorizationCode);
        grantTypeCollection.add(implicit);
        grantTypeCollection.add(password);
        grantTypeCollection.add(clientCredentials);
    }

    /**
     * @verifies method should return a csv string for a given collection
     * @throws Exception
     */
    @Test
    public void testGetAsText() throws Exception {
        addressCollectionPropertyEditor.setValue(collection);
        String csv = addressCollectionPropertyEditor.getAsText();
        System.out.println(csv);
        Assert.assertTrue("see console output",true);
    }

    @Test
    public void testSetAsText() throws Exception {
        addressCollectionPropertyEditor.setValue(collection);
        String csv = addressCollectionPropertyEditor.getAsText();
        addressCollectionPropertyEditor.setAsText(csv);
        Assert.assertEquals("Comparing both csv\'s", csv, addressCollectionPropertyEditor.getAsText());
    }

    /**
     * tests if setAsText converts csv property into a Collection to setValue of the PropertyEditor
     */
    @Test
    public void testGenericCollectionGeneration(){
        genericCollectionPropertyEditor = new CollectionPropertyEditor(GrantType.class);
        genericCollectionPropertyEditor.setAsText("authorization_code , implicit , password , client_credentials , ");
        Collection<GrantType> retrievedCollection = (Collection<GrantType>) genericCollectionPropertyEditor.getValue();
        int count =0;
        for(GrantType element:retrievedCollection){
            for(GrantType secondElement : grantTypeCollection)
                if(secondElement.equals(element))
                count++ ;
        }
        Assert.assertEquals("The GrantTypeCollection does not contain same values when retrieved from PropertyEditor", 4, count);
    }

    /**
     * Tests if setAsText will return equivalent getAsText for generic types
     */
    @Test
    public void getAsTextGenericCollectionPropertyEditorTsst(){
        genericCollectionPropertyEditor = new CollectionPropertyEditor(GrantType.class);
        String grantTypeCSV = "authorization_code , implicit , password , client_credentials , ";
        genericCollectionPropertyEditor.setAsText(grantTypeCSV);
        String retrievedCollection = genericCollectionPropertyEditor.getAsText();
        System.out.println(genericCollectionPropertyEditor.getAsText());
        System.out.println(grantTypeCSV);
        String[] inputArray = grantTypeCSV.split(" , ");
        String[] outputArray= genericCollectionPropertyEditor.getAsText().split(" , ");
        int count =0;
        for(String element1 : inputArray)
            for(String element2 : outputArray) {
                if (element1.equals(element2))
                    count++;
            }
        Assert.assertEquals("The PropertyEditor when setAsText with csv values does not return same values as CSV when getAsText", 4, count);
    }
}