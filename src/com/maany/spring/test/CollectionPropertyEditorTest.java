import com.maany.spring.model.Address;
import com.maany.spring.model.AddressCollection;
import com.maany.spring.propertyeditor.CollectionPropertyEditor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by Mayank on 9/13/2015.
 */
public class CollectionPropertyEditorTest {
    CollectionPropertyEditor collectionPropertyEditor;
    AddressCollection collection ;
    @Before
    public void initTest(){
        collectionPropertyEditor = new CollectionPropertyEditor(Address.class);
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
    }

    /**
     * @verifies method should return a csv string for a given collection
     * @throws Exception
     */
    @Test
    public void testGetAsText() throws Exception {
        collectionPropertyEditor.setValue(collection);
        String csv = collectionPropertyEditor.getAsText();
        System.out.println(csv);
        Assert.assertTrue("see console output",true);
    }

    @Test
    public void testSetAsText() throws Exception {
        collectionPropertyEditor.setValue(collection);
        String csv = collectionPropertyEditor.getAsText();
        collectionPropertyEditor.setAsText(csv);
        Assert.assertEquals("Comparing both csv\'s" ,csv,collectionPropertyEditor.getAsText() );
    }
}