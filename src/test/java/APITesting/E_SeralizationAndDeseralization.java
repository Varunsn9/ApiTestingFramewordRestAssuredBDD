package APITesting;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class E_SeralizationAndDeseralization {
/*What is Serialization and Deserialization?
Serialization is a process of conversion of the Instance of a Class 
(state of the Java object) to a byte stream. Then, 
this serialized object or we say this Byte steam can be stored in files 
or external sources and can be transferred over networks.  
While on the other hand, 
Deserialization is simply the reverse of Serialization meaning 
converting the byte stream back to the Java object.
To achieve Serialization, a class needs to implement Serializable Interface 
and such class are actually Java Beans or say POJO (Plain Old Java Object). 
So, basically Serialization is the process of Converting a POJO to a JSON object 
and converting a JSON object back to POJO is called Deserialization.
*/
	@Test
	public void Serialization() throws Throwable, JsonMappingException, IOException {
		int number=new Random().nextInt(100);
		F_PojoClass p=new F_PojoClass("varun"+number, "armaznar"+number, "complete"+number, 5);
		ObjectMapper omap=new ObjectMapper();
		omap.writeValue(new File("./serialization.json"), p);
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./serializationWWDPP.json"), p);
	}
	@Test
	public void deserialization() throws Throwable, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		F_PojoClass p=omap.readValue(new File("./serialization.json"), F_PojoClass.class);
		System.out.println(p.createdBy);
		System.out.println(p.projectName);
		System.out.println(p.status);
		System.out.println(p.teamSize);
	}
	
	@Test
	public void serializationAndDeserialization()throws Throwable {
		F_PojoClass p=new F_PojoClass("va", "aa", "complete", 0);
		ObjectMapper omap=new ObjectMapper();
		omap.writeValue(new File("./bothSerAndDeser.json"), p);
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./wwdpp.json"), p);
		System.out.println(p.createdBy);	
		F_PojoClass data =omap.readValue(new File("./bothSerAndDeser.json"), F_PojoClass.class);
		System.out.println(data.createdBy);
	}
}
