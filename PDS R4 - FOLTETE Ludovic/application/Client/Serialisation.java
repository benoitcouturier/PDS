import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Serialisation {

	public JSONObject serialisationDTO( Object dto ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
 		JSONObject k = new JSONObject();
 		JSONObject V1 = new JSONObject();
 		Field [] fields = dto.getClass().getDeclaredFields();
 		for (Field field : fields) {
 			V1.put(field.getName(), dto.getClass().getDeclaredMethod("get"+field.getName(), null).invoke(dto, null));
 		}
 		return V1;
	}
	
	public JSONObject deserialisation(String string) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject z = (JSONObject) jsonParser.parse(string);
		return z;
	}
	
	public JSONArray deserialisationarray(String string) throws ParseException{
		JSONParser jsonParser = new JSONParser();
		JSONArray array = (JSONArray)jsonParser.parse(string);
		return array;
	}
	
	public JSONArray serialisationDTOArray( ArrayList<Object> dto ) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
 		JSONArray k = new JSONArray();
 		for(int i=0; i<dto.size(); i++) {
 			Field [] fields = dto.get(i).getClass().getDeclaredFields();
 			JSONObject V1 = new JSONObject();
 			for(Field field : fields){
 				V1.put(field.getName(), dto.get(i).getClass().getDeclaredMethod("get"+field.getName(), null).invoke(dto.get(i), null));
 			}
 			k.add(V1);
 		}
		return k;
	}	
}