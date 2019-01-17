package paytmmoney.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.http.Header;





public class RequestSpecificationBuilder {
	
	public Map<String,List> reqSpec =new HashMap<String, List>();
	static Map<Specifications, Map<String,List>> spec = new HashMap<Specifications, Map<String,List>>();
	private String specificationType;
	private static Map<String,Object> pathParams = new HashMap<String,Object>();
	private Map<String,Object> queryParms = new HashMap<String,Object>();
	private Header header;
	
	





	public Header getHeader() {
		return header;
	}


	public RequestSpecificationBuilder setHeader(Header header) {
		this.header = header;
		return this;
	}


	public String getSpecificationType() {
		return specificationType;
	}

	public enum Specifications{
		queryParms,pathParms
	}
	
	
	
	public RequestSpecificationBuilder setSpecification(Specifications specs,Map<String,List> reqMap) {
		spec.put(specs, reqMap);
		return this;
	}
	
	
	public RequestSpecificationBuilder setParameters(String paramName,List value) {
		reqSpec.put(paramName,value );
		return this;
	}
	
	public RequestSpecificationBuilder setSpecificationType(Specifications specsType) {
		specificationType=specsType.toString();
		return this;
		
		
	}
	
	public Map<String, List> getSpecifications(Specifications key) {
	    return spec.get(key);
	  }
	

	

		public RequestSpecificationBuilder setQueryParameters(String parmName,String... paraVal) {
			List<String> lst= Arrays.asList(paraVal);
			reqSpec.put(parmName, lst);
			return this;
		}
		
		public RequestSpecificationBuilder getParameters(Specifications specifications) {
			spec.get(specifications);
			return this;
		}
		
		public String getParamkey() {
			
			return reqSpec.entrySet().iterator().next().getKey();
		}
		
			public List getParamValue() {
			
			return reqSpec.entrySet().iterator().next().getValue();
		}
		
		
	public RequestSpecificationBuilder setPathParameters(String paramName,Object paramVal) {
		pathParams.put(paramName, paramVal);
		setValue(pathParams);
		return this;
		
	}
	
	public Map<String, Object> getPathParams() {
		
		return pathParams;
	}
		
	public Map<String, Object> getQueryParms() {
		return queryParms;
	}


	public RequestSpecificationBuilder setQueryParms(String paramName,Object paramVal) {
		queryParms.put(paramName, paramVal);
		return this;
	}
	
	
	public void setValue(Map<String, Object> map)
    {
      this.pathParams = map;
    }
	
}
