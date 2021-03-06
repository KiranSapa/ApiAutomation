package paytm.paytmmoney.paytmmoneyapi;

import java.text.ParseException;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import paytm.paytmmoney.ApiUtils.curdUtils;
import paytmmoney.common.Endpoints;
import paytmmoney.common.RequestSpecificationBuilder;

public class SampleApiTest {
	RequestSpecificationBuilder rsp=new RequestSpecificationBuilder();
	
	@Test
	public void test1() {
		rsp.setPathParameters("UserId", 11564439);
		rsp.setQueryParms("pageSize", 100);
		Response response=curdUtils.getinstance().jsonClientGet(Endpoints.mfTransection,rsp);
		response.then().statusCode(200);
		
			
	}
	
	@Test
	public void test2() throws ParseException {
		rsp.setPathParameters("UserId", 400385)
		.setQueryParms("pageSize", 3660).setQueryParms("fromDate","01/07/2019").setQueryParms("toDate", "03/31/2019");
		Response response=curdUtils.getinstance().jsonClientGet(Endpoints.mfTransection_History,rsp);
		response.then().statusCode(200);
		response.then().log().status();
		curdUtils.getResponseBody();
		
	}
	
	@Test
	public void test3() {
	
		String users="6699125;3345260;26068420;2851110;11564439;1454494;17718098;24961526;11538207;240456690;5423173;27070433;253861019;19971424;137295154;29015530;5746956;1439970;312019506;68774010;262598863;24302233;653130487;1672940;106363592;223314669;29713138;2540007;251542204;189943083;56270476;6845483;22558823;450165966;62379528;285540825;1013261;1566923;4680627;127296802;1978750;21619112;353993461;149742798;3388857;31807771;229603489;25576872;30012715;339055405;21532612;19387022;189135639;604635967;95197578;185598487;217894333;475897044;2704198;522178976;660210563;200767853;9157784";
		String[] user=users.split(";");
		for(int i=0;i<user.length;i++) {
		rsp.setPathParameters("UserId", user[i]);
		Response response=curdUtils.getinstance().jsonClientGet(Endpoints.mf_transactionCount,rsp);
		response.then().statusCode(200);
		System.out.println("user id:"+user[i]+"--count:"+response.body().jsonPath().get("data"));
		
		response.then().log().status();
	}
	}
	

}
