package paytmmoney.common;

public interface Endpoints {
	
	
	String mfTransection="/mftransaction/v1/{UserId}/upcoming-investment";
	String GET_user2="/users/2";
	String mfTransection_History="/mftransaction/v1/{UserId}/history";	
	String mf_transactionCount="/mftransaction/v1/{UserId}/transaction_count";

}
