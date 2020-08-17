package technicalResources.electronicBanking;

public class MomentumStatementBean {
	String sHADOW_ACCOUNT_NBR;
	String cARD_NUMBER; 
	String cLIENT_CODE;
	String tRANSACTION_DATE;
	String pROCESSING_DATE;
	String mICROFILM_REF_NUMBER;
	String tRANSACTION_TYPE;
	String oUTLET;
	String bILLING_AMT;
	String tRANSACTION_AMT;
	String tRANSACTION_CCY;


	
	public String getsHADOW_ACCOUNT_NBR() {
		return sHADOW_ACCOUNT_NBR;
	}
	public void setsHADOW_ACCOUNT_NBR(String sHADOW_ACCOUNT_NBR) {
		this.sHADOW_ACCOUNT_NBR = sHADOW_ACCOUNT_NBR;
	}
	public String getcARD_NUMBER() {
		return cARD_NUMBER;
	}
	public void setcARD_NUMBER(String cARD_NUMBER) {
		this.cARD_NUMBER = cARD_NUMBER;
	}
	public String getcLIENT_CODE() {
		return cLIENT_CODE;
	}
	public void setcLIENT_CODE(String cLIENT_CODE) {
		this.cLIENT_CODE = cLIENT_CODE;
	}
	public String gettRANSACTION_DATE() {
		return tRANSACTION_DATE;
	}
	public void settRANSACTION_DATE(String tRANSACTION_DATE) {
		this.tRANSACTION_DATE = tRANSACTION_DATE;
	}
	public String getpROCESSING_DATE() {
		return pROCESSING_DATE;
	}
	public void setpROCESSING_DATE(String pROCESSING_DATE) {
		this.pROCESSING_DATE = pROCESSING_DATE;
	}
	public String getmICROFILM_REF_NUMBER() {
		return mICROFILM_REF_NUMBER;
	}
	public void setmICROFILM_REF_NUMBER(String mICROFILM_REF_NUMBER) {
		this.mICROFILM_REF_NUMBER = mICROFILM_REF_NUMBER;
	}
	public String gettRANSACTION_TYPE() {
		return tRANSACTION_TYPE;
	}
	public void settRANSACTION_TYPE(String tRANSACTION_TYPE) {
		this.tRANSACTION_TYPE = tRANSACTION_TYPE;
	}
	public String getoUTLET() {
		return oUTLET;
	}
	public void setoUTLET(String oUTLET) {
		this.oUTLET = oUTLET;
	}
	public String getbILLING_AMT() {
		return bILLING_AMT;
	}
	public void setbILLING_AMT(String bILLING_AMT) {
		this.bILLING_AMT = bILLING_AMT;
	}
	public String gettRANSACTION_AMT() {
		return tRANSACTION_AMT;
	}
	public void settRANSACTION_AMT(String tRANSACTION_AMT) {
		this.tRANSACTION_AMT = tRANSACTION_AMT;
	}
	public String gettRANSACTION_CCY() {
		return tRANSACTION_CCY;
	}
	public void settRANSACTION_CCY(String tRANSACTION_CCY) {
		this.tRANSACTION_CCY = tRANSACTION_CCY;
	}
	
	
	
	public MomentumStatementBean(String sHADOW_ACCOUNT_NBR, String cARD_NUMBER, String cLIENT_CODE,
			String tRANSACTION_DATE, String pROCESSING_DATE, String mICROFILM_REF_NUMBER, String tRANSACTION_TYPE,
			String oUTLET, String bILLING_AMT, String tRANSACTION_AMT, String tRANSACTION_CCY) {
		
		this.sHADOW_ACCOUNT_NBR = sHADOW_ACCOUNT_NBR;
		this.cARD_NUMBER = cARD_NUMBER;
		this.cLIENT_CODE = cLIENT_CODE;
		this.tRANSACTION_DATE = tRANSACTION_DATE;
		this.pROCESSING_DATE = pROCESSING_DATE;
		this.mICROFILM_REF_NUMBER = mICROFILM_REF_NUMBER;
		this.tRANSACTION_TYPE = tRANSACTION_TYPE;
		this.oUTLET = oUTLET;
		this.bILLING_AMT = bILLING_AMT;
		this.tRANSACTION_AMT = tRANSACTION_AMT;
		this.tRANSACTION_CCY = tRANSACTION_CCY;
	}
	public MomentumStatementBean() {
		
	}
	
	

}
